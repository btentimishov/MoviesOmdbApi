package com.baktyiar.moviesomdbapi.data.remote.model

import com.google.gson.annotations.SerializedName

data class Search(
    @SerializedName("Search")
    val resultSearch: List<RemoteMovie>
)