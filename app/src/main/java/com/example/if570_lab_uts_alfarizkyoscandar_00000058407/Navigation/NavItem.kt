package com.example.if570_lab_uts_alfarizkyoscandar_00000058407.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val listOfNavItems = listOf(
    NavItem(
        label = "Class Enrollment",
        icon = Icons.Default.Home,
        route = Pagees.ClassEnrollmentPage.name
    ),
    NavItem(
        label = "Profile",
        icon = Icons.Default.Person,
        route = Pagees.ProfilePage.name
    )
)