package com.kolappan.aarathana.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kolappan.aarathana.helpers.JsonHelper
import com.kolappan.aarathana.models.Song

@Composable
fun SongLyricComponent(song: Song, modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(start = 7.dp, bottom = 12.dp)
    )
    {
        Column {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "பாடல் இயற்றியவர்: " + song.author)
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = song.lyrics)
        }
    }
}

@Preview
@Composable
fun SongLyricComponentPreview() {
    val context = LocalContext.current;
    val songs = JsonHelper().getSongs(context);
    SongLyricComponent(songs.songs.first(), Modifier.padding(5.dp))
}