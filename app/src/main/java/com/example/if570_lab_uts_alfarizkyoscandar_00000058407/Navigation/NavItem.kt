package com.example.if570_lab_uts_alfarizkyoscandar_00000058407.Navigation

data class NavItem(
    val label: String,
    val route: String
)

val listOfNavItems = listOf(
    NavItem(
        label = "Class Enrollment",
        route = Pagees.ClassEnrollmentPage.name
    ),
    NavItem(
        label = "Profile",
        route = Pagees.ProfilePage.name
    )
)