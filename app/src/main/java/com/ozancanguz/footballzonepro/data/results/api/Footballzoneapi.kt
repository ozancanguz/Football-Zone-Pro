package com.ozancanguz.footballzonepro.data.results.api

import com.ozancanguz.footballzonepro.data.results.Results
import retrofit2.Response
import retrofit2.http.GET

interface Footballzoneapi {

    @GET("results?data.league=super-lig")
    suspend fun getResults():Response<Results>



}