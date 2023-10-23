package com.example.if570_lab_uts_alfarizkyoscandar_00000058407.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Preview
@ExperimentalMaterial3Api
@Composable
fun ClassEnrollmentPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        for (i in 1..5) {
            listItem()
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun listItem(
//    text: String,
//    onClick: () -> Unit
) {
    ListItem(
        headlineText = { Text(text = "IF570 Mobile Application Programming") },
        supportingText = { Text(text = "3 upcoming assignment") },
        leadingContent = {
            Icon(
                imageVector = Icons.Filled.CheckCircle,
                contentDescription = "Localized description",
                tint = Color.Black,
            ) },
    )
}