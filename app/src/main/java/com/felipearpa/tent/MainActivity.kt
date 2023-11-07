package com.felipearpa.tent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.felipearpa.product.detail.ui.productDetailView
import com.felipearpa.product.list.ui.productListView
import com.felipearpa.tent.home.view.ui.HomeRoute
import com.felipearpa.tent.home.view.ui.homeView
import com.felipearpa.tent.ui.theme.TentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Content()
                }
            }
        }
    }
}

@Composable
fun Content() {
    Outlet()
}

@Composable
fun Outlet() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeRoute.route) {
        homeView(navController = navController)
        productListView(navController = navController)
        productDetailView(navController = navController)
    }
}