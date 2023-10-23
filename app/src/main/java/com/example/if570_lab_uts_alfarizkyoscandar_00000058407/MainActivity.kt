package com.example.if570_lab_uts_alfarizkyoscandar_00000058407

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.if570_lab_uts_alfarizkyoscandar_00000058407.Navigation.Pagees
import com.example.if570_lab_uts_alfarizkyoscandar_00000058407.pages.ClassEnrollmentPage
import com.example.if570_lab_uts_alfarizkyoscandar_00000058407.pages.HomePage
import com.example.if570_lab_uts_alfarizkyoscandar_00000058407.pages.LoginPage
import com.example.if570_lab_uts_alfarizkyoscandar_00000058407.pages.ProfilePage
import com.example.if570_lab_uts_alfarizkyoscandar_00000058407.ui.theme.IF570_LAB_UTS_AlfarizkyOscandar_00000058407Theme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IF570_LAB_UTS_AlfarizkyOscandar_00000058407Theme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    composable(
                        route = "home/{name}", // Define a parameter for the "home" destination
                        arguments = listOf(navArgument("name") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val name = backStackEntry.arguments?.getString("name")
                        HomePage(navController, name.orEmpty())
                    }
                    composable("login") {
                        LoginPage(navController)
                    }
//                    composable(route = Pagees.ClassEnrollmentPage.name) {
//                        ClassEnrollmentPage()
//                    }
//                    composable(route = Pagees.ProfilePage.name) {
//                        ProfilePage()
//                    }
//                    composable("ClassEnrollment") {
//                        ClassEnrollmentPage(navController)
//                    }
//                    composable("ClassEnrollment") {
//                        ProfilePage(navController)
//                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    IF570_LAB_UTS_AlfarizkyOscandar_00000058407Theme {
//        Greeting("Android")
//    }
//}