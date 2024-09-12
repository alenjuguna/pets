package com.eshop.eshop.ui.theme.Screens.splash

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.eshop.eshop.navigation.ROUTE_DOG_HOME_SCREEN
import com.eshop.eshop.navigation.ROUTE_HOME
import com.eshop.eshop.navigation.ROUTE_LOGIN
import com.eshop.eshop.ui.theme.creme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate(ROUTE_LOGIN)
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(creme), horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(400.dp)
                .background(creme), contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = com.eshop.eshop.R.drawable.d3),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
        }
        Text("EShop", modifier = Modifier, color = Color.Black, textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Cursive,
            fontSize = 60.sp)
        Text("Your convinient pet store", modifier = Modifier, color = Color.Black, textAlign = TextAlign.Center,
            fontWeight = FontWeight.Thin,
            fontFamily = FontFamily.Default,
            fontSize = 30.sp)
        Text("For all your pet needs", modifier = Modifier, color = Color.Black, textAlign = TextAlign.Center,
            fontWeight = FontWeight.Thin,
            fontFamily = FontFamily.Cursive,
            fontSize = 20.sp)

    }
}

@Preview
@Composable
private fun SplashScreenPrev() {
    SplashScreen(rememberNavController())

}