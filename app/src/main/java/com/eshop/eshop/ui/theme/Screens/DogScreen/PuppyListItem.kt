package com.eshopp.pets.ui.theme

import android.provider.ContactsContract.Profile
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.eshop.eshop.navigation.ROUTE_ADD_PRODUCT
import com.eshop.eshop.navigation.ROUTE_DOG_HOME_SCREEN
import com.eshop.eshop.navigation.ROUTE_UPDATE_PRODUCT

import com.eshop.eshop.ui.theme.Typography
import com.eshopp.pets.ui.theme.data.DataProvider.puppy
import com.eshopp.pets.ui.theme.data.Puppy

@Composable
fun PuppyListItem(puppy: Puppy,navController: NavHostController
                  )
{



        Card (
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(2.dp),
            shape = RoundedCornerShape(corner = CornerSize(16.dp))


        ) {
            Row(

            ) {
                PuppyImage(puppy = puppy)
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                )
                {

                    Text(
                        text = puppy.title,
                        style = Typography.headlineLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "view detail", style = Typography.headlineSmall)
                }
            }
        }
    }


@Composable
fun PuppyImage(puppy: Puppy) {
Image(
    painter = painterResource(id = puppy.puppyImageId),
    contentDescription = null,
    contentScale = ContentScale.Crop,
    modifier = Modifier
        .padding(8.dp)
        .size(84.dp)
        .clip(
            RoundedCornerShape(corner = CornerSize(16.dp))
        )
)

}




@Preview
@Composable
private fun PuppyListprev() {
    PuppyListItem(puppy, rememberNavController())

}

