package com.example.cupcake.test

import androidx.navigation.NavController
import androidx.navigation.NavHostController
import org.junit.Assert.assertEquals

fun NavController.assertCurrentRouteName(expectedRouteName: String){
    assertEquals(expectedRouteName, currentBackStackEntry?.destination?.route)

}