package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.dataagents

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DataVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.GenreVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.PodcastVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.FirebaseApi

object CloudFirestoreFirebaseDataAgent : FirebaseApi {

    private val databaseReference = Firebase.firestore


    override fun getGenres(
        onSuccess: (genresList: List<GenreVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        databaseReference.collection("genres")
            .addSnapshotListener{value,error->
                error?.let {
                    onFailure(it.message?:"Please check connection!")
                }?: run {
                    val genreList : MutableList<GenreVO> = arrayListOf()
                    val result = value?.documents?: arrayListOf()
                    for(document in result) {
                        val data = document.data
                        val genre = GenreVO()
                        genre.id = (data?.get("id") as Long).toInt()
                        genre.name = data["name"] as String
                        genre.parentId = (data["parent_id"] as Long).toInt()
                        genreList.add(genre)
                    }
                    onSuccess(genreList)
                }
            }
    }

    override fun getEpisodes(
        onSucess: (episodeList: List<DataVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        databaseReference.collection("latest_episodes")
            .addSnapshotListener{value,error->
                error?.let {
                    onFailure(it.message?:"Please check connection!")
                }?:run {
                    val episodeList : MutableList<DataVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()
                    for(document in result) {
                        val data = document.data
                        episodeList.add(castToDataVO(data))
                    }
                    onSucess(episodeList)
                }
            }
    }
    private fun castToDataVO(data: MutableMap<String, Any>?) : DataVO {
        val episode = DataVO()
        episode.audio = data?.get("audio") as String
        episode.audioLengthSec = (data["audio_length_sec"] as Long).toInt()
        episode.description = data["description"] as String
        episode.id = data["id"] as String
        episode.explicitContent = data["explicit_content"] as Boolean
        episode.image = data["image"] as String
        episode.link = data["link"] as String
        episode.listenNotesEditUrl = data["listennotes_edit_url"] as String
        episode.maybeAudioInvalid = data["maybe_audio_invalid"] as Boolean
        val podcastData : Map<String,Any> = data["podcast"] as Map<String,Any>
        val podcastItem = PodcastVO()
        podcastItem.id = podcastData.get("id") as String
        podcastItem.image = podcastData["image"] as String
        podcastItem.listenNotesUrl = podcastData["listennotes_url"] as String
        podcastItem.publisher = podcastData["publisher"] as String
        podcastItem.thumbnail = podcastData["thumbnail"] as String
        podcastItem.title = podcastData["title"] as String
        episode.podcast = podcastItem
        episode.pubDateMs = data["pub_date_ms"] as Long
        episode.thumbnail = data["thumbnail"] as String
        episode.title = data["title"] as String

        return episode
    }
}