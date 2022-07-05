package zw.co.gosave.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Login(navController: NavHostController){

    val phone = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }

    var isPasswordVisible = remember {
        mutableStateOf(false)
    }
    val isFormValid by derivedStateOf {
        phone.value.isNotBlank() && password.value.length >= 4
    }



    Scaffold(){
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
          Card(
              Modifier
                  .weight(4f)
                  .padding(8.dp)
                  .verticalScroll(
                      rememberScrollState()
                  ),
              shape = RoundedCornerShape(32.dp)
          ){
              Column(
                  Modifier
                      .fillMaxSize()
                      .padding(32.dp),
                  horizontalAlignment = Alignment.CenterHorizontally
              ) {
                  Text(text = "Login GoSave", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                  Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                      Spacer(modifier = Modifier.height(8.dp))
                      OutlinedTextField(
                          modifier = Modifier.fillMaxWidth(),
                          value = phone.value,
                          onValueChange = { phone.value = it },
                          keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                          label = { Text(text = "Phone") },
                          singleLine = true,
                          trailingIcon = {
                              if (phone.value.isNotBlank())
                                  IconButton(onClick = { phone.value = "" }) {
                                      Icon(imageVector = Icons.Filled.Clear, contentDescription = "")
                                  }
                          }
                      )

                      Spacer(modifier = Modifier.height(8.dp))
                      OutlinedTextField(
                          modifier = Modifier.fillMaxWidth(),
                          value = password.value,
                          onValueChange = { password.value = it.toString() },
                          label = { Text(text = "Password") },
                          singleLine = true,
                          keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                      )

                      Button(
                          onClick = {navController.navigate("home")},
                          enabled = true,
                          modifier = Modifier.fillMaxWidth(),
                          shape = RoundedCornerShape(16.dp)
                      ) {
                          Text(text = "Log In")
                      }
                  }
              }
          }
        }
    }
}

