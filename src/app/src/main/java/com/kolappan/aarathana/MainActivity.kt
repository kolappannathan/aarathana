package com.kolappan.aarathana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kolappan.aarathana.helpers.JsonHelper
import com.kolappan.aarathana.models.Song
import com.kolappan.aarathana.ui.pages.HomePage
import com.kolappan.aarathana.ui.pages.SongLyricPage
import com.kolappan.aarathana.ui.theme.AarathanaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AarathanaTheme {
                AppNavigation()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AarathanaTheme {
        AppNavigation()
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomePage(navController)
        }
        composable(
            route = "lyrics/{songTitle}",
            arguments = listOf(navArgument("songTitle") { type = NavType.StringType })
        ) { backStackEntry ->
            val songTitle = backStackEntry.arguments?.getString("songTitle");
            if(songTitle != null) {
                val context = LocalContext.current;
                val songs = JsonHelper().getSongs(context);

                val song = songs.songs.first { item: Song -> item.title == songTitle };
                SongLyricPage(navController, song = song)
            }
        }
    }
}
