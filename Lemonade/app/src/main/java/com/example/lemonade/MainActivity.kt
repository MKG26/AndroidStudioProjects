package com.example.lemonade

import android.annotation.SuppressLint
import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                            Text(text = "Lemonade")
                            },

                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Yellow)


                        )


                    }




                ) {
                        LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonTextAndImage() {

    var result by remember { mutableStateOf(1) }

    var squeezeCount by remember { mutableStateOf(4) }











        Surface(
            modifier = Modifier
                .wrapContentSize(Alignment.Center)

            ) {
            when (result) {

                1 -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Button(
                            onClick = {
                                result = 2
                                squeezeCount = (2..4).random()
                            },

                            shape = RoundedCornerShape(30.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFFC1ECC8)),

                            ) {
                            Image(
                                painter = painterResource(id = R.drawable.lemon_tree),
                                contentDescription = "Lemon Tree",
                                modifier = Modifier
                                    .padding(dimensionResource(androidx.core.R.dimen.compat_control_corner_material))


                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Tap the lemon tree to select a lemon",
                            fontSize = 18.sp
                        )
                    }

                }

                2 -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Button(
                            onClick = {
                                squeezeCount--
                                if (squeezeCount == 0) {
                                    result = 3
                                }
                            },
                            shape = RoundedCornerShape(30.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFFC1ECC8))
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.lemon_squeeze),
                                contentDescription = "Squeeze lemon",
                                modifier = Modifier
                                    .padding(dimensionResource(androidx.core.R.dimen.compat_control_corner_material))


                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Keep tapping the lemon to squeeze it",
                            fontSize = 18.sp
                        )
                    }

                }

                3 -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Button(
                            onClick = {
                                result = 4

                            },
                            shape = RoundedCornerShape(30.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFFC1ECC8))
                        )
                        {
                            Image(
                                painter = painterResource(id = R.drawable.lemon_drink),
                                contentDescription = "Drink lemonade",
                                modifier = Modifier
                                    .padding(dimensionResource(androidx.core.R.dimen.compat_control_corner_material))

                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Tap the lemonade to drink it",
                            fontSize = 18.sp
                        )
                    }

                }

                4 -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Button(
                            onClick = {
                                result = 1
                            },
                            shape = RoundedCornerShape(30.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFFC1ECC8))
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.lemon_restart),
                                contentDescription = "Empty glass",
                                modifier = Modifier
                                    .padding(dimensionResource(androidx.core.R.dimen.compat_control_corner_material))

                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Tap the empty glass to start again",
                            fontSize = 18.sp
                        )
                    }
                }
            }


        }
    }




@Preview(showSystemUi = true)
@Composable
fun LemonadeApp() {

        LemonTextAndImage()

}