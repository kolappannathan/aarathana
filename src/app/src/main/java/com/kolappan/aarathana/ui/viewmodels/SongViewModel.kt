package com.kolappan.aarathana.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.kolappan.aarathana.data.SongRepository
import com.kolappan.aarathana.models.Song
import com.kolappan.aarathana.models.SongList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SongViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = SongRepository(application)

    private val _songsState = MutableStateFlow<SongList?>(null)
    val songsState: StateFlow<SongList?> = _songsState.asStateFlow()

    init {
        loadSongs()
    }

    private fun loadSongs() {
        _songsState.value = repository.getSongs()
    }

    fun getSongByTitle(title: String): Song? {
        return _songsState.value?.songs?.find { it.title == title }
    }

    fun getSongsByAuthor(author: String): List<Song> {
        return _songsState.value?.songs?.filter { it.author == author } ?: emptyList()
    }

    fun searchSongs(query: String): List<Song> {
        val songs = _songsState.value?.songs ?: return emptyList()
        if (query.isBlank()) return songs
        
        return songs.filter { 
            it.title.contains(query, ignoreCase = true) || 
            it.author.contains(query, ignoreCase = true)
        }
    }
}
