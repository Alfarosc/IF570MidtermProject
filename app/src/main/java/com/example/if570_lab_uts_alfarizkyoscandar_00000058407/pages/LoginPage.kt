package com.example.if570_lab_uts_alfarizkyoscandar_00000058407.pages

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.if570_lab_uts_alfarizkyoscandar_00000058407.R


//@Preview
@OptIn(ExperimentalMaterial3Api::class)
//@Preview
@Composable
fun LoginPage(navController: NavHostController){
//    var text by rememberSaveable { mutableStateOf("") }
//    val errorMessage = "Text input too long"
//    var isError by rememberSaveable { mutableStateOf(false) }
//    val charLimit = 10

//    fun validate(text: String) {
//        isError = text.length > charLimit
//    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "UNION",
            fontSize = 45.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,)

        Text(
            text = "Class Enrollment",
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,)

        Image(
            painter = painterResource(id = R.drawable.book),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(100.dp),)

        var credentials by remember { mutableStateOf(Credentials()) }
        val context = LocalContext.current

        LoginField(
            value = credentials.login,
            onChange = { data -> credentials = credentials.copy(login = data) },
//            onTextChange = { /* do something */ },
//            isError = isError,
//            errorMessage = "Text input too long",
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
        )

//        OutlinedTextField(
//            value = text,
//            onValueChange = {
//                text = it
//                validate(text)
//            },
//            singleLine = true,
//            label = { Text(if (isError) "Username*" else "Username") },
//            supportingText = {
//                Text(
//                    modifier = Modifier.fillMaxWidth(),
//                    text = "Limit: ${text.length}/$charLimit",
//                    textAlign = TextAlign.End,
//                )
//            },
//            isError = isError,
//            keyboardActions = KeyboardActions { validate(text) },
//            modifier = Modifier.semantics {
//                // Provide localized description of the error
//                if (isError) error(errorMessage)
//            }
//        )

        Button(
//            onClick = {null},
            onClick = {
                if (credentials.login.isEmpty()){
                    Toast.makeText(context, "Please fill the username", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
                    navController.navigate("home/${credentials.login}")
                }
            },
//            enabled = credentials.isNotEmpty(),
//            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .padding(vertical = 8.dp)
        ) {
            Text(
                text = "Login",
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 32.dp, end = 32.dp, top = 4.dp, bottom = 4.dp),)
        }
    }
}

data class Credentials(
    var login: String = "",
    var remember: Boolean = false
) {
    fun isNotEmpty(): Boolean {
        return login.isNotEmpty()
    }
}

@ExperimentalMaterial3Api
@Composable
fun LoginField(
    value: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    submit : () -> Unit = { },
    label: String = "Login",
    placeholder: String = "Enter your name"
//    isError: Boolean,
//    errorMessage: String,
) {
    var text by rememberSaveable { mutableStateOf("") }
//    val errorMessage = "Text input too long"
    var isError by rememberSaveable { mutableStateOf(false) }
//    val charLimit = 10
//
//    fun validate(text: String) {
//        isError = text.length > 10
//    }

    OutlinedTextField(
        value = value,
        onValueChange = onChange,
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = { submit() },
        ),
        placeholder = { Text(placeholder) },
        label = { Text(label) },
//        label = { Text(if (isError) "Username*" else "Username") },
//        supportingText = {
//            Text(
//                modifier = Modifier.fillMaxWidth(),
//                text = "Limit: ${text.length}/10",
//                textAlign = TextAlign.End,
//            )
//        },
//        isError = isError,
//        modifier = modifier.semantics {
//            // Provide localized description of the error
//            if (isError) error(errorMessage)
//        }
    )
}
