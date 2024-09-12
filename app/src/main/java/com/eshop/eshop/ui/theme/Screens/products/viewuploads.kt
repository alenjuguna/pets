package com.eshop.eshop.ui.theme.Screens.products
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.eshop.eshop.data.productviewmodel
import com.eshop.eshop.model.Upload
import com.eshop.eshop.navigation.ROUTE_UPDATE_PRODUCT

@Composable
fun ViewUploadsScreen(navController:NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background,

        ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            var context = LocalContext.current
            var productRepository = productviewmodel(navController, context)


            val emptyUploadState = remember { mutableStateOf(Upload("", "", "", "", "")) }
            var emptyUploadsListState = remember { mutableStateListOf<Upload>() }

            var uploads = productRepository.viewUploads(emptyUploadState, emptyUploadsListState)


            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "All uploads",
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Cursive,
                    color = Color.Red
                )

                Spacer(modifier = Modifier.height(20.dp))

                LazyColumn() {
                    items(uploads) {
                        UploadItem(
                            name = it.name,
                            quantity = it.quantity,
                            price = it.price,
                            imageUrl = it.imageUrl,
                            id = it.id,
                            navController = navController,
                            productRepository = productRepository
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun UploadItem(name:String, quantity:String, price:String, imageUrl:String, id:String,
               navController:NavHostController, productRepository:productviewmodel) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = quantity)
        Text(text = price)
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
        Button(onClick = {
            productRepository.deleteProduct(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            navController.navigate(ROUTE_UPDATE_PRODUCT+"/$id")
        }) {
            Text(text = "Update")
        }
    }
}