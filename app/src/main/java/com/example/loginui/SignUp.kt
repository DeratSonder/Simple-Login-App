package com.example.loginui
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// TextField that user fill in
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldLabels(
   datafields: DataField
) {
    var mailStage by remember{
        mutableStateOf("")
    }
    Column(
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = datafields.name,
            fontSize = 15.sp,
            color = Color.Yellow,
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 5.dp)
        )
        OutlinedTextField(
            value = mailStage,
            onValueChange = { mailStage = it },
            textStyle = TextStyle(
                color = Color.Yellow
            ),
            leadingIcon = {
                Icon(
                    painter = datafields.icon ,
                    contentDescription = null
                )
            },
            placeholder = {
                Text(text = datafields.placeholder, fontSize = 15.sp, color = Color.Yellow,
                )
            },
            shape = RoundedCornerShape(10.dp)
        )
    }
}

// TextFields that user fill in
@Composable
fun TextFields(
  datafields: List<DataField>
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
         datafields.forEachIndexed { _, dataField ->
             TextFieldLabels(datafields = dataField)
             Spacer(modifier = Modifier.height(15.dp))
         }
    }
}

@Composable
fun SignUp(
    navController: NavController
) {
    val colorStops = arrayOf(
        0.5f to Color(0xFF191919),
        1f to Color.Black
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colorStops = colorStops))
            .padding(top = 40.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Sign Up",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Yellow
        )
        Spacer(modifier = Modifier.height(15.dp))
        TextFields(
            datafields = listOf(
                DataField(
                    name = "Full Name",
                    placeholder = "Enter your Name",
                    icon = painterResource(id = R.drawable.baseline_account_circle_24)
                ),
                DataField(
                    name = "Phone No",
                    placeholder = "Enter your Phone no",
                    icon = painterResource(id = R.drawable.baseline_phone_android_24)
                ),
                DataField(
                    name = "Email",
                    placeholder = "Enter your Email",
                    icon = painterResource(id = R.drawable.baseline_email_24)
                ),
                DataField(
                    name = "Password",
                    placeholder = "Enter your Password",
                    icon = painterResource(id = R.drawable.baseline_key_24)
                ),
                DataField(
                    name = "Confirm Password",
                    placeholder = "Confirm Password",
                    icon = painterResource(id = R.drawable.baseline_key_24)
                )
            )
        )
        Spacer(modifier = Modifier.height(25.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.Yellow),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
            Text(
                text = "REGISTER", fontSize = 25.sp, fontWeight = FontWeight.Bold,
                color = Color(0xFF191919)
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row{
            Text(text = "Have an account? ", fontSize = 20.sp, color = Color.Yellow)
            Text(text = "Sign in", fontSize = 20.sp,
                color = Color.Yellow,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.navigate(Screen.SignInScreen.route)
                }
            )
        }

    }
}







