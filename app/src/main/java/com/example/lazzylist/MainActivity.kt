package com.example.lazzylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lazzylist.ui.theme.LazzyListTheme

class MainActivity : ComponentActivity() {

    companion object {
        val items : List<Item> = listOf(
            Item(
                title = "Item 1",
                image = R.drawable.image1
            ),
            Item(
                title = "Item 2",
                image =R.drawable.image2
            ),
            Item(
                title = "Item 3",
                image =R.drawable.image3
            ),
            Item(
                title = "Item 4",
                image =R.drawable.image4
            ),
            Item(
                title = "Item 5",
                image =R.drawable.image5
            )
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazzyListTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    val navHostController = rememberNavController()
                    NavHost(navController = navHostController,
                        startDestination ="home_screen" ){
                        composable("home_screen"){
                            HomeScreen(navHostController = navHostController)
                        }
                        composable("lazy_row_screen"){
                            LazyRowScreen()
                        }
                        composable("lazy_column_screen"){
                            LazyColumnScreen()
                        }
                        composable("lazy_grid_screen"){
                            LazyGridScreen()
                        }
                    }
                }
            }
        }
    }
}



@Composable
fun HomeScreen(
    navHostController: NavController
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navHostController.navigate("lazy_row_screen")}) {
            Text(text = "Lazy Row ")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { navHostController.navigate("lazy_column_screen")}) {
            Text(text = "Lazy Column ")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { navHostController.navigate("lazy_grid_screen")}) {
            Text(text = "Lazy Grid ")
        }
        Spacer(modifier = Modifier.height(30.dp))
    }
}
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    LazzyListTheme {
        HomeScreen(navHostController = rememberNavController())
    }
}