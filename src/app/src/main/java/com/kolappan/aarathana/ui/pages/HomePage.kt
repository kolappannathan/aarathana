package com.kolappan.aarathana.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kolappan.aarathana.ui.components.AarathanaTopBar
import com.kolappan.aarathana.ui.components.SongList

@Composable
fun HomePage(
    navController: NavController
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            AarathanaTopBar(navController, false)
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            SongList(navController, modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
@Preview
fun HomePagePreview(
    navController: NavController = rememberNavController()
){
    HomePage(navController)
}