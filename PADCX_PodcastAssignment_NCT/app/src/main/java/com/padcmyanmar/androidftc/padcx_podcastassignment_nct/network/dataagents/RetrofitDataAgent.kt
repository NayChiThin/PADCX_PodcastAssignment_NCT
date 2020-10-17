package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.dataagents

import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.PodcastApi
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetDetailResponse
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetGenresResponse
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetPlaylistInfoResponse
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetRandomEpisodeResponse
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.db.PodcastDB
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.utils.BASE_URL
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitDataAgent : PodcastApi {
    var mPodcastApi : PodcastApi
    lateinit var mTheDB: PodcastDB
    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mPodcastApi = retrofit.create(PodcastApi::class.java)
    }
    override fun getRandomEpisode(): Observable<GetRandomEpisodeResponse> {
        return mPodcastApi.getRandomEpisode()
    }

    override fun getGenres(): Observable<GetGenresResponse> {
        return mPodcastApi.getGenres()
    }

    override fun getPlaylistInfo(
        id: String,
        type: String,
        timeStamp: String,
        sort: String
    ): Observable<GetPlaylistInfoResponse> {
        return mPodcastApi.getPlaylistInfo(id,type,timeStamp,sort)
    }

    override fun getDetailById(id: String): Observable<GetDetailResponse> {
        return mPodcastApi.getDetailById(id)
    }
}