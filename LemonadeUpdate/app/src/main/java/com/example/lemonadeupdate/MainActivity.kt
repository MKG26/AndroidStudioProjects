package com.example.lemonadeupdate

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadeupdate.ui.theme.LemonadeUpdateTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeUpdateTheme {
                // A surface container using the 'background' color from the theme
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
fun LemonTextAndImage(
    onImageClick: () -> Unit,
    drawableResourceId: Int,
    contentDescriptionText: String,
    textUnderImage: String,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onImageClick,
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFC1ECC8))
            ) {
                Image(
                    painter = painterResource(id = drawableResourceId),
                    contentDescription = contentDescriptionText,
                    modifier = Modifier
                        .padding(all = 16.dp)
                )
            

        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = textUnderImage,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun LemonadeFinalApp(){
    var result by remember { mutableStateOf(1) }

    var squeezeCount by remember { mutableStateOf(4) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        when(result){
            
            1 -> {
                LemonTextAndImage(
                    onImageClick =  {
                                    result = 2
                                    squeezeCount = (2..4).random()
                    },
                    drawableResourceId = R.drawable.lemon_tree,
                    contentDescriptionText = "Lemon Tree",
                    textUnderImage = "Tap the lemon tree to select a lemon"
                )
            }

            2 -> {
                LemonTextAndImage(
                    onImageClick =  {
                                    squeezeCount--
                                    if(squeezeCount==0){
                                        result=3
                                    }

                    },
                    drawableResourceId = R.drawable.lemon_squeeze,
                    contentDescriptionText = "Lemon ",
                    textUnderImage = "Keep tapping the lemon to squeeze it"
                )
            }

            3 -> {
                LemonTextAndImage(
                    onImageClick =  {
                            result = 4
                        },


                    drawableResourceId = R.drawable.lemon_drink,
                    contentDescriptionText = "Lemonade ",
                    textUnderImage = "Tap the lemonade to drink it"
                )
            }

            4 -> {
                LemonTextAndImage(
                    onImageClick =  {
                        result = 1
                    },


                    drawableResourceId = R.drawable.lemon_restart,
                    contentDescriptionText = "Empty Glass",
                    textUnderImage = "Tap the empty glass to start again"
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {

    LemonadeFinalApp()

}