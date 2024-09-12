package com.eshopp.pets.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.eshop.eshop.R

import com.eshopp.pets.ui.theme.data.DataProvider.puppy
import com.eshopp.pets.ui.theme.data.Puppy

@Composable
fun ProfileScreen(puppy: Puppy, navController: NavHostController) {
    val scrollState= rememberScrollState()

    Column ( modifier=Modifier.fillMaxSize() ){
        BoxWithConstraints { this
            Surface {
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ){
                    // TODO:
                    ProfileHeader(puppy = puppy, containerHeightStyle = this@BoxWithConstraints.maxHeight)
                    ProfileContent(puppy = puppy, containerHeightStyle = this@BoxWithConstraints.maxHeight)
                }
            }
        }
    }

}

@Composable
private fun ProfileHeader (puppy: Puppy,containerHeightStyle: Dp) {
    Image(modifier = Modifier
        .heightIn(max = containerHeightStyle / 2)
        .fillMaxWidth(),
        painter = painterResource(id = puppy.puppyImageId),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )

}

@Composable
private fun ProfileContent(puppy: Puppy,containerHeightStyle: Dp) {
    Column { this
    // TODO
        Title(puppy = puppy)
        ProfileProperty(label = stringResource(id= R.string.Sex), value = puppy.sex)
        ProfileProperty(label = stringResource(id=R.string.Age), value = puppy.age.toString())
        ProfileProperty(label = stringResource(id=R.string.personality), value = puppy.description)
        Spacer(modifier = Modifier.height((containerHeightStyle-320.dp).coerceAtLeast(0.dp)))

    }

}
@Composable
private fun Title(puppy: Puppy) {
    Column (modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp))
    {
        Text(text = puppy.title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold


            )
    }

    }

@Composable
private fun ProfileProperty(label:String,value: String) {
    Column(modifier = Modifier.padding(16.dp))
    {
        HorizontalDivider(modifier = Modifier.padding(bottom = 4.dp))
        Text(
            text= label,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.labelLarge

        )
        Text(

            text = value, modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.bodyLarge,
            overflow = TextOverflow.Visible

        )

    }

}

@Preview
@Composable
private fun ProfileScreenall() {
    ProfileScreen(puppy, rememberNavController() )

}