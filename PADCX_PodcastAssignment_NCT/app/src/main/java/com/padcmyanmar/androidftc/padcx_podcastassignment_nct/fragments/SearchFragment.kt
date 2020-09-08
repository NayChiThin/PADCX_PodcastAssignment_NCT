package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.R
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.adapters.CategoryListAdapter
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters.SearchPresenter
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters.SearchPresenterImpl
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views.SearchView
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetGenresResponse
import kotlinx.android.synthetic.main.fragment_search.*

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment(),SearchView {

    private lateinit var mCategoryListAdapter: CategoryListAdapter
    private lateinit var mPresenter : SearchPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpPresenter()
        setUpRecyclerView()
        mPresenter.onUiReady(this)
    }

    override fun navigateToHome() {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.flBottomNavigationContainer,HomeFragment())
            ?.commit()
    }

    override fun displayGenres(genres: GetGenresResponse) {
        mCategoryListAdapter.setNewData(genres.genres?.toMutableList()?: arrayListOf())
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(SearchPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }
    private fun setUpRecyclerView() {
        mCategoryListAdapter = CategoryListAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rvCategories.adapter = mCategoryListAdapter
        rvCategories.layoutManager = linearLayoutManager
    }


}
