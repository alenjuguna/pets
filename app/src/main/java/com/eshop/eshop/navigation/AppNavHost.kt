package com.eshop.eshop.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eshop.eshop.ui.theme.Screens.home.HomeScreen
import com.eshop.eshop.ui.theme.Screens.login.LoginScreen
import com.eshop.eshop.ui.theme.Screens.products.AddProductsScreen
import com.eshop.eshop.ui.theme.Screens.products.UpdateProductsScreen
import com.eshop.eshop.ui.theme.Screens.products.ViewProductsScreen
import com.eshop.eshop.ui.theme.Screens.products.ViewUploadsScreen
import com.eshop.eshop.ui.theme.Screens.register.RegisterScreen
import com.eshop.eshop.ui.theme.Screens.splash.SplashScreen
import com.eshopp.pets.ui.theme.PuppyListItem
import com.eshopp.pets.ui.theme.data.DataProvider.puppy
import com.eshopp.pets.ui.theme.data.Puppy


@Composable
fun AppNavHost(modifier: Modifier=Modifier,navController:NavHostController= rememberNavController(),startDestination:String= ROUTE_SPLASH) {

    NavHost(navController = navController, modifier=modifier, startDestination = startDestination ){
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }

        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_ADD_PRODUCT) {
            AddProductsScreen(navController)
        }
        composable(ROUTE_VIEW_PRODUCT){
            ViewProductsScreen(navController)
        }
        composable(ROUTE_UPDATE_PRODUCT+ "/{id}"){passedData ->
            UpdateProductsScreen(navController,passedData.arguments?.getString("id")!!)
        }
        composable(ROUTE_VIEW_UPLOAD){
            ViewUploadsScreen(navController)
        }
        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUTE_DOG_HOME_SCREEN) {
            PuppyListItem(puppy ,navController)

        }

        }
    }

