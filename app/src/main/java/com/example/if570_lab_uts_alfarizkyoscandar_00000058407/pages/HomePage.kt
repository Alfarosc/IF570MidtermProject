package com.example.if570_lab_uts_alfarizkyoscandar_00000058407.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.if570_lab_uts_alfarizkyoscandar_00000058407.Navigation.Pagees
import com.example.if570_lab_uts_alfarizkyoscandar_00000058407.Navigation.listOfNavItems

@ExperimentalMaterial3Api
@Composable
fun HomePage(navController: NavHostController, name: String) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    var state by remember { mutableStateOf(0) }
    val titles = listOf("Tab 1", "Tab 2")
    var tabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Class Enrollment", "Profile")

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            Column {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(0xFF083C52),
                        titleContentColor = Color.White,
                    ),
                    title = {
                        Text(
                            "UNION",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.headlineMedium, // Adjust typography here
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Localized description",
                                tint = Color.White,
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { null }) {
                            Icon(
                                imageVector = Icons.Filled.MoreVert,
                                contentDescription = "Localized description",
                                tint = Color.White,
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior,
                )
//                -------------------------------------------------------------------------
                Column {
                    TabRow(selectedTabIndex = state) {
                        listOfNavItems.forEach{ navItem ->
                            Tab(
                                selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
//                                titles = Text(text = navItem.label),
//                                onClick = { state = index },
                                onClick = {
                                    navController.navigate(navItem.route){
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
//                                selected = (index == state)
                            )
                        }
                    }
//                    Text(
//                        modifier = Modifier.align(Alignment.CenterHorizontally),
//                        text = "Fancy tab ${state + 1} selected",
//                        style = MaterialTheme.typography.bodyLarge
//                    )
                    Text(text = "Welcome, $name!", modifier = Modifier.padding(16.dp))
                }
//                -------------------------------------------------------------------------
//                Column(modifier = Modifier.fillMaxWidth()) {
//                    TabRow(selectedTabIndex = tabIndex) {
//                        listOfNavItems.forEachIndexed { index, navItem ->
//                            Tab(text = { Text(navItem.label) },
//                                selected = tabIndex == index,
//                                onClick = { tabIndex = index }
//                            )
//                        }
//                    }
//                }
            }

        },
    ) { innerPadding ->
        ScrollContent(innerPadding,tabIndex, navController)
    }
}

@Composable
fun ScrollContent(
    innerPadding: PaddingValues,
    tabIndex: Int,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .verticalScroll(rememberScrollState())
    ) {
//        // TODO: Add content here
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Pagees.ProfilePage.name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            composable(route = Pagees.ProfilePage.name) {
                ProfilePage()
            }
            composable(route = Pagees.ClassEnrollmentPage.name) {
                ClassEnrollmentPage()
            }
        }
//        -------------------------------------------------------------------------
//        when (tabIndex) {
//            0 -> navController.navigate("classEnrollment")
//            1 -> navController.navigate("ProfilePage")
//        }
    }
}

@Composable
fun FancyTab(
    title: String,
    onClick: () -> Unit,
    selected: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .background(if (selected) Color(0xFF073042) else Color(0xFF083C52)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(vertical = 8.dp),
        )
    }
}
