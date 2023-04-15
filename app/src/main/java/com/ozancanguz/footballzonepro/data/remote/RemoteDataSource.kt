package com.ozancanguz.footballzonepro.data.remote

import com.ozancanguz.footballzonepro.data.results.Results
import com.ozancanguz.footballzonepro.data.results.api.Footballzoneapi
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource@Inject constructor(private val footballzoneapi: Footballzoneapi) {


    suspend fun getResults(): Response<Results> {

        return  footballzoneapi.getResults()
    }

}