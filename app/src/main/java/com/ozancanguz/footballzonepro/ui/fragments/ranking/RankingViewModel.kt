package com.ozancanguz.footballzonepro.ui.fragments.ranking

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ozancanguz.footballzonepro.data.models.rankings.Rankings
import com.ozancanguz.footballzonepro.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RankingViewModel@Inject constructor(private val repository: Repository, application: Application):AndroidViewModel(application) {


    val rankings=MutableLiveData<Rankings>()

    fun getRankings(){

        viewModelScope.launch {
            val response=repository.remote.getRankings()
            if(response.isSuccessful){
                rankings.postValue(response.body())
            }else{
                Log.e("rankingviewmodel","no data")
            }
        }
    }


}