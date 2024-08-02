package com.kolappan.aarathana.ui.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kolappan.aarathana.helpers.JsonHelper
import com.kolappan.aarathana.models.Song
import com.kolappan.aarathana.ui.components.AarathanaTopBar
import com.kolappan.aarathana.ui.components.SongLyricComponent

@Composable
fun SongLyricPage(
    navController: NavController,
    song: Song) {
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
    val context = LocalContext.current;
    val songs = JsonHelper().getSongs(context);
    SongLyricPage(navController = rememberNavController(), song = songs.songs.first())
}