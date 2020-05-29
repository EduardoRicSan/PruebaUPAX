package com.corporation.pruebaupax.domain.model

/**
 * Data class for call enque of webservices
 */
data class DataRequest(
    var userId: String,
    var env: String,
    var os: String
)