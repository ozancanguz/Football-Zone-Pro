package com.ozancanguz.footballzonepro.data.results.api

import com.ozancanguz.footballzonepro.data.models.goalkings.GoalKings
import com.ozancanguz.footballzonepro.data.models.rankings.Rankings
import com.ozancanguz.footballzonepro.data.results.LatestResults
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface Footballzoneapi {

    @Headers("authorization: apikey 2xAW88zA1iemGAxzWMNumI:47IyS3uICCasjqzWaFtxnn", "content-type: application/json")
    @GET("results?data.league=super-lig")
    suspend fun getResults(): Response<LatestResults>

    @Headers("authorization: apikey 2xAW88zA1iemGAxzWMNumI:47IyS3uICCasjqzWaFtxnn", "content-type: application/json")
    @GET("league?data.league=super-lig")
    suspend fun getRankings():Response<Rankings>

    @Headers("authorization: apikey 2xAW88zA1iemGAxzWMNumI:47IyS3uICCasjqzWaFtxnn", "content-type: application/json")
    @GET("goalKings?data.league=super-lig")
    suspend fun getGoalKings():Response<GoalKings>



}
