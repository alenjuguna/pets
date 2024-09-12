package com.eshop.eshop.ui.theme.Screens.home
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.CheckCircle
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.eshop.eshop.R
import com.eshop.eshop.data.AuthViewModel
import com.eshop.eshop.navigation.ROUTE_ADD_PRODUCT
import com.eshop.eshop.navigation.ROUTE_DOG_HOME_SCREEN
import com.eshop.eshop.navigation.ROUTE_LOGIN
import com.eshop.eshop.navigation.ROUTE_UPDATE_PRODUCT
import com.eshop.eshop.navigation.ROUTE_VIEW_PRODUCT
import com.eshop.eshop.navigation.ROUTE_VIEW_UPLOAD
import com.eshop.eshop.ui.theme.creme


@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(253,251,212)),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
//        var productdata=productviewmodel(navController,context)

        Text(
            text = "Home page",
            color = Color.Black,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            fontSize = 60.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Image(
            painter = painterResource(R.drawable.d3), contentDescription = null,
            modifier = Modifier.size(170.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_ADD_PRODUCT)
        }, modifier = Modifier.width(250.dp), shape = RoundedCornerShape(20.dp)) {
            Text(text = "Add Product")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_VIEW_PRODUCT)
        }, modifier = Modifier.width(250.dp), shape = RoundedCornerShape(20.dp)) {
            Text(text = "Update Products")
        }



        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navController.navigate(ROUTE_DOG_HOME_SCREEN)
        }, modifier = Modifier.width(250.dp), shape = RoundedCornerShape(20.dp)) {
            Text(text = "View Listed Dogs")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            val mylogout= AuthViewModel(navController, context )
            mylogout.logout()
            navController.navigate(ROUTE_LOGIN)
        }, modifier = Modifier.width(250.dp), shape = RoundedCornerShape(20.dp)) {
            Text(text = "Sign out")
        }
        Spacer(modifier = Modifier.height(20.dp))
        BottomNavigation(rememberNavController())











    }

}





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
            title = "Add",
            selectedIcon =Icons.Filled.Add,
            unselectedicon = Icons.Outlined.Add,
            route = ROUTE_ADD_PRODUCT
        ),
        BottomNavigationItem(
            title = "View Upload",
            selectedIcon =Icons.Filled.CheckCircle,
            unselectedicon = Icons.Outlined.CheckCircle,
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
        Scaffold (containerColor = Color(253,251,212),
            bottomBar = {
                NavigationBar{
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selectedItemIndex==index,
                            onClick = {
                                selectedItemIndex=index
                                navController.navigate(item.route)
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
fun Homepreview() {
    HomeScreen(rememberNavController())
}