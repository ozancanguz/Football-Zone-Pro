package com.ozancanguz.footballzonepro.ui.fragments.result

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ozancanguz.footballzonepro.data.repository.Repository
import com.ozancanguz.footballzonepro.data.results.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ResultViewModel@Inject constructor(private val repository: Repository, application: Application):AndroidViewModel(application) {


    val results=MutableLiveData<Results>()

    fun getResults(){
        viewModelScope.launch {
            val response=repository.remote.getResults()
            if(response.isSuccessful){
                results.postValue(response.body())
            }else{
                Log.e("results","no data")
            }
        }
    }

}