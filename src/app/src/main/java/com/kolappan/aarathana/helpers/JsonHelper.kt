package com.kolappan.aarathana.helpers

import android.content.Context
import com.kolappan.aarathana.models.Song
import com.kolappan.aarathana.models.SongList
import org.json.JSONObject

class JsonHelper {
    fun getSongs(context: Context): SongList {
        // Json mock in https://run.mocky.io/v3/96a6b986-3275-4091-b8e8-99c7ebb83325
        val jsonString = context.assets.open("devotionalSongs.json").bufferedReader().use { it.readText() }
        val jsonObject = JSONObject(jsonString)

        val jsonArray = jsonObject.getJSONArray("songs")
        val songs = List(jsonArray.length()) { index ->
            val songObject = jsonArray.getJSONObject(index)
            Song(
                title = songObject.getString("title"),
                author = songObject.getString("author"),
                lyrics = songObject.getString("lyrics"),
                mainGod = songObject.getString("mainGod")
            )
        }

        return SongList(
            version = jsonObject.getInt("version"),
            updated = jsonObject.getString("updated"),
            songs = songs
        )
    }
}