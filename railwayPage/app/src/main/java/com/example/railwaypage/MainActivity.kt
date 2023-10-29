package com.example.railwaypage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.railwaypage.data.Rail
import com.example.railwaypage.data.request
import com.example.railwaypage.ui.theme.RailwayPageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RailwayPageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RailApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RailTopAppBar(modifier: Modifier = Modifier)
{
    CenterAlignedTopAppBar(
        title = {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = modifier
                    .padding(top = 20.dp)
            ) {
                Text(
                    text = "Requests",
                    style = MaterialTheme.typography.displayLarge
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RailApp(){


    Scaffold(
        topBar = { RailTopAppBar() }
    ) {
        LazyColumn(
            modifier = Modifier,
            contentPadding = it


        ) {
            items(request) {
                RailItem(
                    rail = it,
                    modifier = Modifier
                        .padding(10.dp)

                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RailItem(
    rail: Rail,
    modifier: Modifier = Modifier
){




    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ) ,
        modifier = modifier

            . clip(MaterialTheme.shapes.medium),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.padding_medium))

        ) {
            RailInfo(
                head = rail.nameRes,
                stock = rail.avCoal,
                side = rail.neLo


                )


        }
    }

}


@Composable
fun RailInfo(
    @StringRes head: Int,
    @StringRes stock: Int,
    @StringRes side: Int,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = head),
            style = MaterialTheme.typography.displayMedium,
            modifier = modifier
                .padding(bottom = 10.dp)
        )

        Text(
            text = stringResource(id = stock),
            style = MaterialTheme.typography.bodyLarge,
            modifier = modifier
                .padding(bottom = 10.dp)
        )

        Text(
            text = stringResource(id = side),
            style = MaterialTheme.typography.bodyLarge,
            modifier = modifier
                .padding(bottom = 10.dp)
        )


    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RailwayPageTheme {

    }
}