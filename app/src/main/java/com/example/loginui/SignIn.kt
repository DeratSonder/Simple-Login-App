
package com.example.loginui

//import androidx.compose.foundation.layout.RowScopeInstance.align
//import android.text.style.StyleSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.RowScopeInstance.align
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
//import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignIn(
    navController: NavController
) {
    var mailStage by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    val passwordHidden by rememberSaveable {
        mutableStateOf(true)
    }
    val colorStops = arrayOf(

        0.9f to Color(0xFF191919),
        1f to Color.Black
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Brush.verticalGradient(colorStops = colorStops))
            .padding(top = 80.dp),

        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sign In",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Yellow
        )
        Spacer(modifier = Modifier.height(15.dp))
        Column(
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = "Email",
                fontSize = 15.sp,
                //fontWeight = FontWeight.Thin,
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
                        painter = painterResource(id = R.drawable.baseline_email_24),
                        contentDescription = null
                    )
                },
                placeholder = {
                    Text(text = "Enter your email", fontSize = 15.sp, color = Color.Yellow,
                    )
                },
                shape = RoundedCornerShape(10.dp)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Column(
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = "Password",
                fontSize = 15.sp,
                //fontWeight = FontWeight.Thin,
                color = Color.Yellow,
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 5.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                textStyle = TextStyle(
                    color = Color.Yellow
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_key_24),
                        contentDescription = null
                    )
                },
                placeholder = {
                    Text(text = "Enter your password", fontSize = 15.sp, color = Color.Yellow)
                },
                shape = RoundedCornerShape(10.dp),
                visualTransformation =
                    if(passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            )
            Text(
                text = "Forgot Password?",
                fontSize = 15.sp,
                //fontWeight = FontWeight.Thin,
                color = Color.Yellow,
                modifier = Modifier
                    .padding(0.dp, 10.dp, 0.dp, 0.dp)
                    .align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        val (checkedState, onStateChange) = remember {
            mutableStateOf(false)
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 54.dp)
                .toggleable(
                    value = checkedState,
                    onValueChange = { onStateChange(!checkedState) },
                    role = Role.Checkbox
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checkedState,
                onCheckedChange = null // null recommended for accessibility with screenreaders
            )
            Text(
                text = "Remember me",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 10.dp),
                color = Color.Yellow
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.Yellow),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
            Text(text = "LOGIN", fontSize = 25.sp, fontWeight = FontWeight.Bold,
            color = Color(0xFF191919)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        //Spacer(modifier = Modifier.height(1.dp))
        Image(painter = painterResource(id = R.drawable.taixuong),
            contentDescription = null,
            modifier = Modifier
                .width(250.dp)
                .height(220.dp)
                .clip(CircleShape),

            contentScale = ContentScale.FillBounds

        )
        Row(){
            Text(text = "Don't have an account? ", fontSize = 20.sp, color = Color.Yellow)
            Text(text = "Sign up", fontSize = 20.sp,
                color = Color.Yellow,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.navigate(Screen.SignUpScreen.route)
                }
            )
        }
    }
}




