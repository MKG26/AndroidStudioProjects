package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    finalApp()
                }
            }
        }
    }
}

@Composable
fun RowAndColumnLayout(
    drawableResourceId: Int,
    imageText: String,
    shootName: String,
    shootYear: String,
    goPrevious: () -> Unit,
    goNext: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxHeight(),


    ) {

        Spacer(modifier = Modifier.height(48.dp))

        Surface(
            modifier = Modifier
                .fillMaxHeight(0.59f)
                .fillMaxWidth(1f)
                .border(BorderStroke(3.dp, SolidColor(Color.White)))
                .shadow(15.dp)

            ,


            shape = RoundedCornerShape(10.dp),




        ) {
            Image(
                painter = painterResource(id = drawableResourceId ),
                contentDescription = "",
                modifier = Modifier
                    .padding(35.dp)

            )
        }

        Spacer(modifier = Modifier.height(88.dp))

        Column(
            modifier = Modifier
                .size(height = 100.dp, width = 300.dp)
                .background(color = Color(0xFFE9E7E7))
                .align(Alignment.CenterHorizontally)







        ) {
            Text(
                text = imageText,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp, start = 20.dp),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Light





            )

            Row {
                Text(
                    text = shootName,
                    modifier = Modifier
                        .padding(start = 20.dp),
                    fontWeight = FontWeight.Bold

                    )

                Text(
                    text = shootYear,
                    modifier = Modifier
                        .padding(start = 5.dp),
                    fontWeight = FontWeight.Light

                )
            }

        }

        Spacer(modifier = Modifier.height(80.dp))
        
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom

        ) {
            Button(
                modifier = Modifier
                    .width(110.dp)
                    .height(40.dp) ,
                onClick = goPrevious
            ) {
                Text(text = "Previous")

            }

            Button(
                modifier = Modifier
                    .width(110.dp)
                    .height(40.dp) ,
                onClick = goNext,
                colors = ButtonDefaults.buttonColors(Color(0xFFFF5722))
            ) {
                Text(
                    text = "Next",



                    )


            }
        }


    }
}



@Composable
fun finalApp(){
    
    var result by remember {mutableStateOf(1)}
    

        when(result){
            
            1 -> {
                RowAndColumnLayout(
                    drawableResourceId = R.drawable.download,
                    imageText = "Portrait Drawing",
                    shootName = "Kal Kaun",
                    goPrevious = { /*TODO*/ },
                    shootYear = "(2017)",
                    goNext = { result = 2 })
            }

            2 -> {
                RowAndColumnLayout(
                    drawableResourceId = R.drawable.ma,
                    imageText = "Johnny Depp",
                    shootName = "Kal Kaun",
                    goPrevious = { result = 1 },
                    shootYear = "(2018)",
                    goNext = { result = 3 })
            }

            3 -> {
                RowAndColumnLayout(
                    drawableResourceId = R.drawable.zayn,
                    imageText = "Zyan Malik",
                    shootName = "Kal Kaun",
                    goPrevious = { result = 2 },
                    shootYear = "(2019)",
                    goNext = { result = 1 })
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        finalApp()
    }
}