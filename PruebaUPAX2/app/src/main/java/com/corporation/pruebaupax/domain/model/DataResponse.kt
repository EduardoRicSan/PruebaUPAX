package com.corporation.pruebaupax.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Data class for response of webservices
 */
data class DataResponse(
    @SerializedName("code")
    @Expose
    val code: String,
    @SerializedName("message")
    @Expose
    val message: String,
    @SerializedName("response")
    @Expose
    val response: Any,
    @SerializedName("success")
    @Expose
    val success: Boolean
)
