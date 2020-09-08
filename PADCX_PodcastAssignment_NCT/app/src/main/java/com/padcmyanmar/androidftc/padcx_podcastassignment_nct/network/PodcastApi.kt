package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network

import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.*
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface PodcastApi {
    @Headers("$API_HEADER:$API_KEY")
    @GET(GET_RANDOM_EPISODE)
    fun getRandomEpisode() : Observable<GetRandomEpisodeResponse>

    @Headers("$API_HEADER:$API_KEY")
    @GET(GET_GENRES)
    fun getGenres() : Observable<GetGenresResponse>

    @Headers("$API_HEADER:$API_KEY")
    @GET("$GET_PLAYLIST_INFO/{id}")
    fun getPlaylistInfo(@Path("id")id:String,@Query(PARAM_TYPE)type : String, @Query(PARAM_LAST_TIMESTAMP_MS)timeStamp:String, @Query(PARAM_SORT)sort:String):Observable<GetPlaylistInfoResponse>

    @Headers("$API_HEADER:$API_KEY")
    @GET("$GET_DETAIL/{EPISODE_ID}")
    fun getDetailById(@Path("EPISODE_ID")id:String): Observable<GetDetailResponse>
}