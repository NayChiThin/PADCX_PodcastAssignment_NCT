package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.models

import android.content.Context
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.dataagents.RetrofitDataAgent.mTheDB
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.db.PodcastDB
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

abstract class BaseModel {
    fun initDatabase(context:Context) {
        mTheDB = PodcastDB.getDbInstance(context)
    }
}