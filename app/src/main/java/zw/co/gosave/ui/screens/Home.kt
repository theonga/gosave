package zw.co.gosave.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun Home(navController: NavHostController){

    val openDialog =  remember {
        mutableStateOf(false)
    }

    val action =  remember {
        mutableStateOf("deposit")
    }

    if (openDialog.value){
        GoAlert(action = action.value, openDialog)
    }



   Scaffold() {

       Column(
           Modifier
               .padding(horizontal = 20.dp, vertical = 40.dp)
               .verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top
       ) {
           Button(
               onClick = {
                   action.value =   "deposit"
                   openDialog.value = true
               },
               modifier = Modifier.fillMaxWidth(),
               shape = RoundedCornerShape(16.dp)
           ) {
               Text(text = "Deposit")
           }

           Spacer(modifier = Modifier.height(8.dp))

           Button(
               onClick = {
                   action.value =   "withdrawal"
                   openDialog.value = true
               },
               modifier = Modifier.fillMaxWidth(),
               shape = RoundedCornerShape(16.dp)
           ) {
               Text(text = "Withdrawal")
           }

           Spacer(modifier = Modifier.height(8.dp))

           Button(
               onClick = {
                   action.value =   "other"
                   openDialog.value = true
               },
               modifier = Modifier.fillMaxWidth(),
               shape = RoundedCornerShape(16.dp)
           ) {
               Text(text = "Other")
           }
       }
   }
}

@Composable
fun GoAlert(action: String, openDialog: MutableState<Boolean>){
    if (action=="withdrawal"){
        WithDialog(openDialog, title="Withdrawal")
    }else if(action=="deposit"){
        DepositDialog(openDialog, title="Deposit")
    }else{
        OtherDialog(openDialog, title="Other")
    }
}


@Composable
fun WithDialog(openDialog: MutableState<Boolean>, title: String){
    AlertDialog(
        onDismissRequest = {
            openDialog.value = false
        },
        title = {
            Column() {
                Text(text = title, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            }
        },
        text = {
            Column() {
                Text("Call Variables", fontWeight = FontWeight.ExtraBold, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(20.dp))
                Text("- Version = WITHDRAWAL", fontWeight = FontWeight.Normal, fontSize = 10.sp)
                Text("- Amount = 500", fontWeight = FontWeight.Normal, fontSize = 10.sp)
                Text("- AccNumber = 20009258", fontWeight = FontWeight.Normal, fontSize = 10.sp)
                Spacer(modifier = Modifier.height(20.dp))
                Text("-> Method(Version, Amount, AccNumber)", fontWeight = FontWeight.ExtraBold, fontSize = 10.sp)
            }
        },
        buttons = {
            Row(
                modifier = Modifier.padding(all = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Dismiss")
                }
            }
        }
    )
}


@Composable
fun DepositDialog(openDialog: MutableState<Boolean>, title: String){
    AlertDialog(
        onDismissRequest = {
            openDialog.value = false
        },
        title = {
            Column() {
                Text(text = title, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            }
        },
        text = {
            Column() {
                Text("Call Variables", fontWeight = FontWeight.ExtraBold, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(20.dp))
                Text("- Version = DEPOSIT", fontWeight = FontWeight.Normal, fontSize = 10.sp)
                Text("- Amount = 500", fontWeight = FontWeight.Normal, fontSize = 10.sp)
                Text("- AccNumber = 20009258", fontWeight = FontWeight.Normal, fontSize = 10.sp)
                Spacer(modifier = Modifier.height(20.dp))
                Text("-> Method(Version, Amount, AccNumber)", fontWeight = FontWeight.ExtraBold, fontSize = 10.sp)
            }
        },
        buttons = {
            Row(
                modifier = Modifier.padding(all = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Dismiss")
                }
            }
        }
    )
}


@Composable
fun OtherDialog(openDialog: MutableState<Boolean>, title: String){
    AlertDialog(
        onDismissRequest = {
            openDialog.value = false
        },
        title = {
            Column() {
                Text(text = title, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            }
        },
        text = {
            Column() {
                Text("Invalid Transaction", fontWeight = FontWeight.ExtraBold, fontSize = 14.sp)
            }
        },
        buttons = {
            Row(
                modifier = Modifier.padding(all = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Dismiss")
                }
            }
        }
    )
}