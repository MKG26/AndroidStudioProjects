package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Card()
                }
            }
        }
    }
}






@Composable
fun Card( modifier: Modifier = Modifier) {

    val image = painterResource(R.drawable.android_logo)
    val call = painterResource(id = R.drawable.ic_call)
    val share = painterResource(id = R.drawable.ic_share)
    val mail = painterResource(id = R.drawable.ic_mail)

Surface(
    color = Color(0xFFCCF0D2)
){

    Column(
        modifier = Modifier
            .padding(bottom = 90.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = "android logo",
            modifier = Modifier
                .height(110.dp)
                .width(110.dp)
                .background(color = Color(0xFF030925))
        )

        Text(
            text = "Jennifer Doe",
            fontSize = 45.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .padding(top = 8.dp)
        )

        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 15.sp,
            color = Color(0xFF1F772D),
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier
            .padding(bottom = 40.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Row {
            androidx.compose.material3.Icon(
                painter = call,
                contentDescription = "call icon",
                tint = Color(0xFF1F772D)

            )
            Text(
                text = "+11 (123) 444 555 666",
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(start = 20.dp)
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 15.dp, end = 65.dp)
        ) {
            androidx.compose.material3.Icon(
                painter = share,
                contentDescription = "share",
                tint = Color(0xFF1F772D)

            )
            Text(
                text = "@AndroidDev",
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(start = 20.dp)
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 15.dp, end = 5.dp)
        ) {
            androidx.compose.material3.Icon(
                painter = mail,
                contentDescription = "mail",
                tint = Color(0xFF1F772D)

            )
            Text(
                text = "jen.doe@android.com",
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(start = 20.dp)
            )
        }

    }
}
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Card()
    }
}