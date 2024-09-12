package com.eshop.eshop.ui.theme.Screens.login
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.material.TextButton

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.eshop.eshop.R
import com.eshop.eshop.data.AuthViewModel
import com.eshop.eshop.navigation.ROUTE_REGISTER
import com.eshop.eshop.ui.theme.creme

@Composable
fun LoginScreen(navController:NavHostController) {

    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var context= LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .background(creme),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(100.dp))
        Box(modifier = Modifier.size(100.dp)
            .background(creme)
            , contentAlignment = Alignment.Center){
            Image(painter = painterResource(R.drawable.d3), contentDescription = null, modifier = Modifier.size(100.dp))
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text("Eshop your most convinient pet store")


        Spacer(modifier = Modifier.height(50.dp))


        Text(text = "Login",
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Cursive,
            fontSize = 40.sp)
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value =email , onValueChange = {email=it},
            label = { Text(text = "Enter Email") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value =pass , onValueChange = {pass=it},
            label = { Text(text = "Enter Password") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val mylogin= AuthViewModel(navController, context )
            mylogin.login(email.text.trim(),pass.text.trim())
        }, modifier = Modifier.width(250.dp),) {
            Text(text = "Log In")
        }
        Spacer(modifier = Modifier.height(0.dp))

        TextButton (onClick = {
            navController.navigate(ROUTE_REGISTER)
        }, modifier = Modifier.width(250.dp)) {
            Text(text = "Don't have account? Register")
        }

    }


}
@Preview
@Composable
fun Loginpage() {
    LoginScreen(rememberNavController())
}