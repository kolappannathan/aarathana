package com.kolappan.aarathana.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kolappan.aarathana.models.Song

@Composable
fun SongListContent(
    songs: List<Song>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(start = 8.dp, end = 8.dp)
    ) {
        items(songs) { song ->
            SongCard(song, navController)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SongListPreview() {
    val navController = rememberNavController()
    val mockSongs = listOf(
        Song("Song 1", "Author 1", "Lyrics 1", "God 1"),
        Song("Song 2", "Author 2", "Lyrics 2", "God 2"),
        Song("Song 3", "Author 3", "Lyrics 3", "God 3")
    )
    SongListContent(mockSongs, navController)
}
