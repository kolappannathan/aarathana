package com.kolappan.aarathana.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kolappan.aarathana.models.Song
import com.kolappan.aarathana.ui.components.AarathanaTopBar
import com.kolappan.aarathana.ui.components.SongListContent

@Composable
fun HomePage(
    navController: NavController,
    songs: List<Song>,
    onMenuClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            AarathanaTopBar(
                navController = navController,
                canNavigateBack = false,
                onMenuClick = onMenuClick,
                actions = {
                    IconButton(onClick = { navController.navigate("search") }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }
            )
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            SongListContent(songs, navController, modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomePagePreview(){
    val navController = rememberNavController()
    val mockSongs = listOf(
        Song("Song 1", "Author 1", "Lyrics 1", "God 1"),
        Song("Song 2", "Author 2", "Lyrics 2", "God 2"),
        Song("Song 3", "Author 3", "Lyrics 3", "God 3")
    )
    HomePage(navController, mockSongs, onMenuClick = {})
}
