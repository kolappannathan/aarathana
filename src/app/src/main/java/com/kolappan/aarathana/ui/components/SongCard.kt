package com.kolappan.aarathana.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kolappan.aarathana.models.Song

@Composable
fun SongCard(song: Song, navController: NavController, modifier: Modifier = Modifier) {
    Card(
        onClick = { navController.navigate("lyrics/${song.title}") },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 1.dp, vertical = 3.dp)
    ) {
        Column(modifier = Modifier.padding(all = 8.dp)) {
            Text(
                text = song.title,
                modifier = Modifier.padding(bottom = 3.dp)
            )
            if (song.author.isNotEmpty()) {
                Text(
                    text = song.author,
                    fontSize = 8.sp
                )
            }
        }
    }
}