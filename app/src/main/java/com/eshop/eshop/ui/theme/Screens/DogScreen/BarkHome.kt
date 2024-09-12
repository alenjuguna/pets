package com.eshopp.pets.ui.theme

import android.provider.ContactsContract.Profile
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController

import com.eshopp.pets.ui.theme.data.DataProvider
import com.eshopp.pets.ui.theme.data.Puppy

@Composable
fun BarkHomeContent() {
    val puppies= remember { DataProvider.puppyList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {

        items(
            items = puppies,
            itemContent={

                PuppyListItem(puppy=it, rememberNavController())
            }
        )



    }

}