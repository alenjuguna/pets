package com.eshop.eshop


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.eshop.eshop.navigation.AppNavHost
import com.eshop.eshop.ui.theme.EshopTheme
import com.eshopp.pets.ui.theme.BarkHomeContent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           EshopTheme  {

               myApp()

                AppNavHost()
            }
        }
    }
}

@Composable
fun myApp() {
    Scaffold (content = {it
        BarkHomeContent()
    })

}

