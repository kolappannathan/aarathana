package com.kolappan.aarathana.models

import kotlinx.serialization.Serializable

@Serializable
data class Song(
    val title: String,
    val author: String,
    val lyrics: String,
    val mainGod: String
)

@Serializable
data class SongList(
    val version: Int,
    val updated: String,
    val songs: List<Song>
)
