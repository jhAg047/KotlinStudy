package he.dev.kotlinstudy.layoutActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class NavigationActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavgationBar(navController) }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            NavigationGraph(navController)
        }
    }
}

@Composable
fun BottomNavgationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("home","홈", Icons.Filled.Home),
        BottomNavItem("search","검색", Icons.Filled.Search),
        BottomNavItem("settings","설정", Icons.Filled.Settings),
    )
    NavigationBar {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        for (item in items) {
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {

                        }
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController){

}

@Composable
fun HomeScreen() {
    ScreenContent("홈 화면")
}

@Composable
fun SearchScreen() {
    ScreenContent("검색 화면")
}

@Composable
fun SettingsScreen() {
    ScreenContent("설정 화면")
}

@Composable
fun ScreenContent(title:String){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(title, style = MaterialTheme.typography.headlineMedium)
    }
}

data class BottomNavItem(val route:String, val title:String, val icon: ImageVector)