package com.atom.teststarwars.domain.models.films


import com.google.gson.annotations.SerializedName

data class Films(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: Any,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<Kino>
)