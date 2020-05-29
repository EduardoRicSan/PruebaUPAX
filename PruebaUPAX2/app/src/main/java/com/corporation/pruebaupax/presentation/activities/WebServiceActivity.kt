package com.corporation.pruebaupax.presentation.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.corporation.myapplication.RetrofitInterface
import com.corporation.pruebaupax.R
import com.corporation.pruebaupax.RetrofitClient
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_web_service.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WebServiceActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var retrofitClient: RetrofitClient
    lateinit var retrofitInterface: RetrofitInterface


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_service)

        retrofitInit()
        btWebServ.setOnClickListener(this)
    }
    //init retrofit instance
    private fun retrofitInit() {
        retrofitClient = RetrofitClient.instance!!
        retrofitInterface = retrofitClient.authApiService
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btWebServ -> queryData()
        }
    }

    //method to get url link and download zip
    private fun queryData() {
        val requestBody: MutableMap<String,@JvmSuppressWildcards Any> = HashMap()
        requestBody["userId"] = 89602
        requestBody["env"] = "dev"
        requestBody["os"] = "android"

         val call: Call<JsonObject> = retrofitInterface.getData(requestBody)
           call.enqueue(object : Callback<JsonObject> {
               override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                   t.message
               }
               override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                   if (response.isSuccessful){
                       response
                   }else{
                       response.errorBody()
                   }
               }


           })

    }
}
