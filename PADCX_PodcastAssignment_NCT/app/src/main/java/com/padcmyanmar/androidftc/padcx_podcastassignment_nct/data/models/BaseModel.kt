package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.models

import android.content.Context
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.PodcastApi
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.db.PodcastDB
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

abstract class BaseModel {
    protected var mPodcastApi : PodcastApi
    protected lateinit var mTheDB: PodcastDB
    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15,TimeUnit.SECONDS)
            .readTimeout(15,TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mPodcastApi = retrofit.create(PodcastApi::class.java)
    }
    fun initDatabase(context:Context) {
        mTheDB = PodcastDB.getDbInstance(context)
    }
}