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
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.adapters.ShowListAdapter
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters.DownloadPresenter
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters.DownloadPresenterImpl
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views.DownloadView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_download.*
import kotlinx.android.synthetic.main.fragment_download.*

/**
 * A simple [Fragment] subclass.
 */
class DownloadFragment : Fragment(),DownloadView {
    private lateinit var mShowListAdapter : ShowListAdapter
    private lateinit var mPresenter : DownloadPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_download, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpPresenter()
        setUpRecyclerView()
        setUpListener()
    }

    private fun setUpListener() {
        ivBack.setOnClickListener {
            mPresenter.onTapBack()
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DownloadPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }
    private fun setUpRecyclerView() {
        mShowListAdapter = ShowListAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rvShows.adapter = mShowListAdapter
        rvShows.layoutManager = linearLayoutManager
    }

    override fun navigateToDetails(podcastId: Int) {
        /*fragmentManager?.beginTransaction()
            ?.replace(R.id.flBottomNavigationContainer,DetailFragment())
            ?.commit()*/
        startActivity(DetailActivity.newIntent(context,podcastId))
    }

    override fun navigateToHome() {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.flBottomNavigationContainer,HomeFragment())
            ?.commit()
        activity?.bottomNavigation!!.selectedItemId = R.id.action_home
    }




}
