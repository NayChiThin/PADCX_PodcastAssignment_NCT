package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.R
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.activities.DetailActivity
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.adapters.PodcastListAdapter
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters.HomePresenter
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters.HomePresenterImpl
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views.HomeView
import kotlinx.android.synthetic.main.content_home.*

class HomeFragment : Fragment(),HomeView {

    private lateinit var mPodcastListAdapter : PodcastListAdapter
    private lateinit var mPresenter : HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpPresenter()
        setUPRecyclerview()
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

    override fun navigateToDetails(podcastId: Int) {
        /*fragmentManager?.beginTransaction()
            ?.replace(R.id.flBottomNavigationContainer,DetailFragment())
            ?.commit()*/
        startActivity(DetailActivity.newIntent(context,podcastId))
    }

}
