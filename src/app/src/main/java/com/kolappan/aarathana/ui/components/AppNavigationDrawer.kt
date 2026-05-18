package com.kolappan.aarathana.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppNavigationDrawerContent(
    currentRoute: String?,
    onNavigate: (String) -> Unit,
    onCloseDrawer: () -> Unit
) {
    ModalDrawerSheet {
        Text("Aarathana", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleLarge)
        HorizontalDivider()
        Spacer(modifier = Modifier.height(8.dp))
        NavigationDrawerItem(
            label = { Text("Home") },
            selected = currentRoute == "home",
            onClick = {
                onNavigate("home")
                onCloseDrawer()
            },
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
        NavigationDrawerItem(
            label = { Text("Search") },
            selected = currentRoute == "search",
            onClick = {
                onNavigate("search")
                onCloseDrawer()
            },
            icon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
        NavigationDrawerItem(
            label = { Text("About") },
            selected = currentRoute == "about",
            onClick = {
                onNavigate("about")
                onCloseDrawer()
            },
            icon = { Icon(Icons.Default.Info, contentDescription = null) },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
    }
}

@Preview
@Composable
fun AppNavigationDrawerContentPreview() {
    AppNavigationDrawerContent(
        currentRoute = "home",
        onNavigate = {},
        onCloseDrawer = {}
    )
}
