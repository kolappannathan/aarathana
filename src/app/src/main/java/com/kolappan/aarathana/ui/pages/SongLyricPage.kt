package com.kolappan.aarathana.ui.pages

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kolappan.aarathana.models.Song
import com.kolappan.aarathana.ui.components.AarathanaTopBar
import com.kolappan.aarathana.ui.components.SongLyricComponent

@Composable
fun SongLyricPage(
    navController: NavController,
    song: Song,) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            AarathanaTopBar(navController, true, song.title)
        }) { innerPadding ->
        SongLyricComponent(song, modifier = Modifier.padding(innerPadding))
    }
}

@Preview
@Composable
fun SongLyricPreview() {
    val song = Song(
        title = "Preview Song",
        author = "Author Name",
        lyrics = "Lyrics go here...",
        mainGod = "God Name"
    )
    SongLyricPage(navController = rememberNavController(), song = song)
}
