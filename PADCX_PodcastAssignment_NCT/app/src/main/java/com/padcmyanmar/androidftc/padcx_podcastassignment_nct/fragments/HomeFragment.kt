package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.fragments

import android.Manifest
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.text.parseAsHtml
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.R
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.activities.DetailActivity
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.adapters.PodcastListAdapter
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DownloadVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.ItemVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters.HomePresenter
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters.HomePresenterImpl
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views.HomeView
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetPlaylistInfoResponse
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetRandomEpisodeResponse
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.utils.PlaybackStateListener
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewpods.MediaPlayerViewPod
import kotlinx.android.synthetic.main.content_home.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(),HomeView {

    private lateinit var mPodcastListAdapter : PodcastListAdapter
    private lateinit var mPresenter : HomePresenter
    private lateinit var mMediaPlayerViewPod : MediaPlayerViewPod
    private var downloadId : Long = 0
    private var url : String? = ""
    private var fileName : String? = ""
    private var episode : DownloadVO = DownloadVO()

    companion object {
        const val REQUEST_CODE = 100
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        context?.registerReceiver(onDownloadComplete, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpPresenter()
        setUPRecyclerview()
        setUpViewPods()
        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(HomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }
    private fun setUPRecyclerview() {
        mPodcastListAdapter = PodcastListAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rvPodcast.adapter = mPodcastListAdapter
        rvPodcast.layoutManager = linearLayoutManager
    }
    private fun setUpViewPods() {
        mMediaPlayerViewPod = viewpodMediaPlayer as MediaPlayerViewPod
    }
    private val onDownloadComplete: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(
            context: Context,
            intent: Intent
        ) { //Fetching the download id received with the broadcast
            val id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
            //Checking if the received broadcast is for our enqueued download by matching download id
            if (downloadId == id) {
                Toast.makeText(context, "Download Completed", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun beginDownload(context: Context,data:ItemVO?) {
        val audioUrl = data?.data?.listenNotesUrl
        val imageUrl = data?.data?.image
        val title = data?.data?.title
        // download audio
        url = audioUrl?.removeSurrounding("/")
        fileName = audioUrl?.substring(url?.lastIndexOf('/')!! +1)

        val audioRequest : DownloadManager.Request = DownloadManager.Request(Uri.parse(url))
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
            .setDescription("Downloading")
            .setTitle(fileName)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"${title?.trim()?.substring(0,8)}.mp3")

        val downloadManager : DownloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        downloadId = downloadManager.enqueue(audioRequest)
        // download image
        url = imageUrl
        fileName = imageUrl?.substring(url?.lastIndexOf('/')!! + 1)
        val imageRequest : DownloadManager.Request = DownloadManager.Request(Uri.parse(url))
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
            .setDescription("Downloading")
            .setTitle(fileName)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"${title?.trim()?.substring(0,8)}.jpg")
        downloadManager.enqueue(imageRequest)
    }
    override fun navigateToDetails(podcastId: String) {
        startActivity(DetailActivity.newIntent(context,podcastId))
    }

    override fun displayRandomEpisode(randomEpisode: GetRandomEpisodeResponse) {
        mMediaPlayerViewPod.bindData(randomEpisode)
        tvDescription.text = randomEpisode.description.parseAsHtml()
    }

    override fun displayUpNextEpisodes(upnextEpisodes: GetPlaylistInfoResponse) {
        mPodcastListAdapter.setNewData(upnextEpisodes.items?.toMutableList()?: arrayListOf())
    }

    override fun downloadEpisode(context: Context, data:ItemVO?) {
        if(checkPermission()) {
            beginDownload(context,data)
        }
        data?.data?.let {
            episode.title = it.title
            episode.id = it.id
            episode.description = it.description
            episode.audioLengthSec = it.audioLengthSec.toLong()
            episode.image = it.image
            episode.audio = "${Environment.DIRECTORY_DOWNLOADS}/${it.title.trim().substring(0,8)}.mp3"
//            episode.genre = it.podcast?.genreIds?.first() ?: 0
        }
        episode.let {
            mPresenter.saveDownload(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mMediaPlayerViewPod.onDestroy()
        context?.unregisterReceiver(onDownloadComplete)
    }
    private fun checkPermission():Boolean {
        when {
            context?.let {
                ContextCompat.checkSelfPermission(
                    it,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            }==PackageManager.PERMISSION_GRANTED -> {
                // download
                return true
            }
            else -> {
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    REQUEST_CODE)
            }
        }
        return false
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            REQUEST_CODE -> {
                if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED) {

                }else {

                }
                return
            }else -> {

        }
        }
    }
}
