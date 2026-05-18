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
}
