package com.eshopp.pets

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import com.eshop.eshop.ui.theme.EshopTheme

import com.eshopp.pets.ui.theme.ProfileScreen
import com.eshopp.pets.ui.theme.data.Puppy


class ProfileActivity : AppCompatActivity() {







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EshopTheme  () {
               Text(text = "Hello World")

            }
        }
    }
    companion object{
        private const val PUPPY_ID="puppy_id"
        fun newIntent(context: Context,puppy: Puppy)=
            Intent(context,ProfileActivity::class.java).apply {
                putExtra(PUPPY_ID,puppy)
            }
    }


}