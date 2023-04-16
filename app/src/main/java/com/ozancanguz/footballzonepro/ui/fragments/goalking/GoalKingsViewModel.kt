package com.ozancanguz.footballzonepro.ui.fragments.goalking

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ozancanguz.footballzonepro.data.models.goalkings.GoalKings
import com.ozancanguz.footballzonepro.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoalKingsViewModel @Inject constructor(private val repository: Repository, application: Application):AndroidViewModel(application){

    val goalKingsList=MutableLiveData<GoalKings>()

    fun getGoalKings(){
        viewModelScope.launch {
            val response=repository.remote.getGoalKings()
            if(response.isSuccessful){
                goalKingsList.postValue(response.body())
            }else{
                Log.e("goalkingsviewmodel","no data")
            }
        }
    }

}