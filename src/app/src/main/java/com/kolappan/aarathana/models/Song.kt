package com.kolappan.aarathana.models

data class Song(
    var title: String,
    var author: String,
    var lyrics: String,
    var mainGod: String
)

data class SongList(
    var version: Int,
    var updated: String,
    var songs: List<Song>
)