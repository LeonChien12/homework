package com.leon.homework.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class News(
    @field:Json(name = "chtmessage") val chtmessage: String,
    @field:Json(name = "engmessage") val engmessage: String,
    @field:Json(name = "starttime") val starttime: String,
    @field:Json(name = "endtime") val endtime: String,
    @field:Json(name = "updatetime") val updatetime: String,
    @field:Json(name = "content") val content: String,
    @field:Json(name = "url") val url: String
)
