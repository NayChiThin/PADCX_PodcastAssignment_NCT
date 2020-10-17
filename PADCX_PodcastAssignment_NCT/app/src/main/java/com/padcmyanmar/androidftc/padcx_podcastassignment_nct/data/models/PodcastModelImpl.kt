package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.models

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DataVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DownloadVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.GenreVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.FirebaseApi
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.PodcastApi
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.dataagents.CloudFirestoreFirebaseDataAgent
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.dataagents.RealtimeDatabaseFirebaseDataAgent
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.dataagents.RetrofitDataAgent
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.dataagents.RetrofitDataAgent.mTheDB
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.*
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.utils.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PodcastModelImpl :BaseModel(),PodcastModel{

//    var mPodcastApi : PodcastApi = RetrofitDataAgent
//    var mFirebaseApi : FirebaseApi = RealtimeDatabaseFirebaseDataAgent
    var mFirebaseApi : FirebaseApi = CloudFirestoreFirebaseDataAgent
    @SuppressLint("CheckResult")
    override fun getRandomEpisodeFromApi(onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        // api
        /*mPodcastApi.getRandomEpisode()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.randomEpisodeDao().insertRandomEpisode(it)
            },{
                onFailure(it.localizedMessage?: EM_NO_INTERNET_CONNECTION)
            })*/
        // firebase
        /*mFirebaseApi.getRandomEpisode(
            onSuccess = {
                mTheDB.randomEpisodeDao().insertRandomEpisode(it)
            }
            ,onFailure = {
                onFailure(it)
            })*/
    }

    override fun getRandomEpisodeFromDb(): LiveData<DataVO> {
//        return mTheDB.randomEpisodeDao().getRandomEpisode()
        return mTheDB.episodeDao().getRandomEpisode()
    }

    @SuppressLint("CheckResult")
    override fun getGenresFromApi(onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        /*mPodcastApi.getGenres()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.genresDao().insertGenres(it)
                mTheDB.genresDao().insertGenre(it.genres?.toMutableList()?: arrayListOf())
            },{
                onFailure(it.localizedMessage?: EM_NO_INTERNET_CONNECTION)
            })*/
        mFirebaseApi.getGenres(
            onSuccess = {
                mTheDB.genresDao().insertGenre(it)
            },
            onFailure = {
                onFailure(it)
            }
        )
    }

    override fun getGenresFromDb(): LiveData<List<GenreVO>> {
        return mTheDB.genresDao().getGenresList()
    }



    @SuppressLint("CheckResult")
    override fun getPlaylistInfoFromApi(onSuccess: () -> Unit, onFailure: (String) -> Unit,id:String) {
        /*mPodcastApi.getPlaylistInfo(id,PARAM_TYPE, PARAM_LAST_TIMESTAMP_MS, PARAM_SORT)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.playlistInfoDao().insertPlaylistInfo(it)
                onSuccess()
            },{
                onFailure(it.localizedMessage?: EM_NO_INTERNET_CONNECTION)
            })*/
        mFirebaseApi.getEpisodes(
            onSucess = {
                mTheDB.episodeDao().deleteEpisodes()
                mTheDB.episodeDao().insertEpisodes(it)
            },
            onFailure = {
                onFailure(it)
            }
        )
    }

    override fun getPlaylistInfoFromDb(id:String): LiveData<List<DataVO>> {
//        return mTheDB.playlistInfoDao().getPlaylistInfo()
        return mTheDB.episodeDao().getEpisodes()
    }

    @SuppressLint("CheckResult")
    override fun getDetailById(id: String): LiveData<DataVO> {
        /*mPodcastApi.getDetailById(id)
            .subscribeOn(Schedulers.io())
            .subscribe({
                mTheDB.detailDao().insertDetail(it)
            },{
                Log.e("Error" ,it.localizedMessage?: EM_NO_INTERNET_CONNECTION)
            })
        return mTheDB.detailDao().getDetailById(id)
        */
        return mTheDB.episodeDao().getDetailById(id)
    }

    override fun saveEpisodesIntoDb(episode: DownloadVO) {
        mTheDB.downloadDao().insertDownloadEpisode(episode)
    }

    override fun getDownloadEpisodesFromDb(): LiveData<List<DownloadVO>> {
        return mTheDB.downloadDao().getDownloadEpisodes()
    }

    override fun getDownloadEpisodeByIdFromDb(id: String): LiveData<DownloadVO> {
        return mTheDB.downloadDao().getDownloadEpisodeById(id)
    }

    override fun getGenreNameById(genreId: Int): String {
        return mTheDB.genresDao().getGenreName(genreId)
    }

}