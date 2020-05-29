package com.corporation.myapplication


import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

/**
 * Retrofit interface to retrofit
 */
interface RetrofitInterface {

    //get data
    @Headers("Content-Type: application/json")
    @POST("task/initial_load")
    fun getData(@Body dataRequest: Map<String, @JvmSuppressWildcards Any>): Call<JsonObject>

}