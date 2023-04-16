package com.ozancanguz.footballzonepro.data.remote

import android.util.Log
import com.ozancanguz.footballzonepro.data.models.rankings.Rankings
import com.ozancanguz.footballzonepro.data.results.LatestResults
import com.ozancanguz.footballzonepro.data.results.api.Footballzoneapi

import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource@Inject constructor(private val footballzoneapi: Footballzoneapi) {


    suspend fun getResults(): Response<LatestResults> {
        val response = footballzoneapi.getResults()
        if (response.isSuccessful) {
            return response
        } else {
            Log.e("RemoteDataSource", "API request error: ${response.code()} - ${response.errorBody()?.string()}")
            return Response.error(response.code(), response.errorBody()!!)
        }
    }

    suspend fun getRankings():Response<Rankings>{
        return footballzoneapi.getRankings()
    }


}