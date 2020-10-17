package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.dataagents

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DataVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.GenreVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.FirebaseApi
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.PodcastApi
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetDetailResponse
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetGenresResponse
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetPlaylistInfoResponse
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetRandomEpisodeResponse
import io.reactivex.Observable

object RealtimeDatabaseFirebaseDataAgent : FirebaseApi {

    private val database: DatabaseReference = Firebase.database.reference

    override fun getGenres(
        onSuccess: (genresList: List<GenreVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        database.child("genres").addValueEventListener(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val genresList = arrayListOf<GenreVO>()
                snapshot.children.forEach{dataSnapshot->
                    dataSnapshot.getValue(GenreVO::class.java)?.let {
                        genresList.add(it)
                    }
                }
                onSuccess(genresList)
            }
        })
    }

    override fun getEpisodes(
        onSucess: (episodeList: List<DataVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        database.child("latest_episodes").addValueEventListener(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val episodeList = arrayListOf<DataVO>()
                snapshot.children.forEach{dataSnapshot->
                    dataSnapshot.getValue(DataVO::class.java)?.let {
                        episodeList.add(it)
                    }
                }
                onSucess(episodeList)
            }
        })
    }

/*
    override fun getRandomEpisode(): Observable<GetRandomEpisodeResponse> {
        database.child("latest_episodes").addValueEventListener(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                randomEpisode = snapshot.children.first().getValue(GetRandomEpisodeResponse::class.java)!!
            }
        })
        return Observable.just(randomEpisode)
    }

    override fun getGenres(): Observable<GetGenresResponse> {
        database.child("genres").addValueEventListener(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {

            }
        })
    }

    override fun getPlaylistInfo(
        id: String,
        type: String,
        timeStamp: String,
        sort: String
    ): Observable<GetPlaylistInfoResponse> {

    }

    override fun getDetailById(id: String): Observable<GetDetailResponse> {

    }*/
}