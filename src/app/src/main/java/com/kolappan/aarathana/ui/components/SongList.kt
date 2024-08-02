package com.kolappan.aarathana.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kolappan.aarathana.helpers.JsonHelper

@Composable
fun SongList(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current;
    val songs = JsonHelper().getSongs(context);
    LazyColumn(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp)
    ) {
        items(songs.songs) { song ->
            SongCard(song, navController)
        }
    }
}

@Composable
@Preview
fun SongListPreview() {
    val navController = rememberNavController()
    SongList(navController)
}