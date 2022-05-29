package com.leon.homework.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TimeZoneRequest(
    @field:Json(name = "timeZone") val timeZone: String
)
