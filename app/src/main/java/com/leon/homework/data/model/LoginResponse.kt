package com.leon.homework.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginResponse(
    @field:Json(name = "objectId") val objectId: String,
    @field:Json(name = "username") val username: String,
    @field:Json(name = "code") val code: String,
    @field:Json(name = "isVerifiedReportEmail") val isVerifiedReportEmail: Boolean,
    @field:Json(name = "reportEmail") val reportEmail: String,
    @field:Json(name = "createdAt") val createdAt: String,
    @field:Json(name = "updatedAt") val updatedAt: String,
    @field:Json(name = "timezone") val timezone: Int,
    @field:Json(name = "parameter") val parameter: Int,
    @field:Json(name = "number") val number: Int,
    @field:Json(name = "phone") val phone: String,
    @field:Json(name = "timeZone") val timeZone: String,
    @field:Json(name = "timone") val timone: String,
    @field:Json(name = "sessionToken") val sessionToken: String
)
