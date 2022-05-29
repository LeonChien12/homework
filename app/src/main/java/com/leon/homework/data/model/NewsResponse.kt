package com.leon.homework.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsResponse(
    @field:Json(name = "updateTime") val updateTime: String,
    @field:Json(name = "News") val news: List<News>
)
