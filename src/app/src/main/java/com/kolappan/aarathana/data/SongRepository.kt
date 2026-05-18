package com.kolappan.aarathana.data

import android.content.Context
import com.kolappan.aarathana.models.SongList
import kotlinx.serialization.json.Json

class SongRepository(private val context: Context) {
    private var cachedSongs: SongList? = null

    private val json = Json {
        ignoreUnknownKeys = true
    }

    fun getSongs(): SongList {
        return cachedSongs ?: loadSongs().also { cachedSongs = it }
    }

    private fun loadSongs(): SongList {
        val jsonString = context.assets.open("devotionalSongs.json").bufferedReader().use { it.readText() }
        return json.decodeFromString<SongList>(jsonString)
    }
}
