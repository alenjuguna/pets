package com.eshop.eshop.ui.theme.Screens

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.eshop.eshop.navigation.ROUTE_ADD_PRODUCT
import com.eshop.eshop.navigation.ROUTE_DOG_HOME_SCREEN
import com.eshop.eshop.navigation.ROUTE_UPDATE_PRODUCT
import okhttp3.Route

data class BottomNavigationItem(
    val title: String,
    val selectedIcon:ImageVector,
    val unselectedicon:ImageVector,
    val route: String


)

@Composable
fun BottomNavigation(navController: NavHostController) {
    val items= listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon =Icons.Filled.Home,
            unselectedicon = Icons.Outlined.Home,
            route = ROUTE_DOG_HOME_SCREEN

        ),
        BottomNavigationItem(
            title = "Email",
            selectedIcon =Icons.Filled.Email,
            unselectedicon = Icons.Outlined.Email,
            route = ROUTE_ADD_PRODUCT
        ),
        BottomNavigationItem(
            title = "Setting",
            selectedIcon =Icons.Filled.Settings,
            unselectedicon = Icons.Outlined.Settings,
            route = ROUTE_UPDATE_PRODUCT

        ),
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold (
            bottomBar = {
                NavigationBar{
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selectedItemIndex==index,
                            onClick = {
                                selectedItemIndex=index
                                navController.navigate(item.title)
                            },
                            label = {
                                Text(text = item.title)

                            },
                            icon = {
                                Icon(imageVector =if (index==selectedItemIndex){
                                    item.selectedIcon
                                }else item.unselectedicon,
                                    contentDescription = item.title
                                )

                            }

                        )
                    }

                } }
        ){it

        }

    }

}

@Preview
@Composable
private fun preview() {
    BottomNavigation(rememberNavController())

}
