package com.corporation.pruebaupax

import com.corporation.myapplication.RetrofitInterface
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Singleton class of retrofit client
 */
class RetrofitClient {
    private val retrofitInterface: RetrofitInterface
    /**
     *
     */
    val authApiService: RetrofitInterface
        get() = retrofitInterface

    companion object {

       // https://apisls.upaxdev.com/task/initial_load
        private const val BASE_URL = "https://apisls.upaxdev.com/"
        private lateinit var retrofit: Retrofit
        /**
         * Singleton Method
         * @return
         */
        var instance: RetrofitClient? = null
            get() {
                if (field == null) {
                    field = RetrofitClient()
                }
                return field
            }
            private set
    }

    init {
        val gson = GsonBuilder()
            .setLenient()
            //.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
        val okHttpClientBuilder = OkHttpClient.Builder()
            .readTimeout(3, TimeUnit.MINUTES)
            .writeTimeout(3, TimeUnit.MINUTES)
            .connectTimeout(3, TimeUnit.MINUTES)
        // okHttpClientBuilder.addInterceptor(new AuthInterceptor());
        val client = okHttpClientBuilder.build()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
           // .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
        retrofitInterface =
            retrofit.create<RetrofitInterface>(
                RetrofitInterface::class.java)
    }
}
