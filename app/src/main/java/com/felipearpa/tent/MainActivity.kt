package com.felipearpa.tent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.felipearpa.tent.home.view.ui.HomeRoute
import com.felipearpa.tent.product.view.ui.ProductRoute
import com.felipearpa.tent.productDetail.view.ui.ProductDetailRoute
import com.felipearpa.tent.ui.theme.TentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
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
        HomeRoute.composable(navGraphBuilder = this, navHostController = navController)
        ProductRoute.composable(navGraphBuilder = this, navHostController = navController)
        ProductDetailRoute.composable(navGraphBuilder = this, navHostController = navController)
    }
}