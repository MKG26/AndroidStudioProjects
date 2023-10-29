package com.example.wellness

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.WellnessTheme
import com.example.wellness.data.Well
import com.example.wellness.data.wellness

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WellnessTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WellnessApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WellTopAppBar(modifier: Modifier = Modifier)
{
    CenterAlignedTopAppBar(
        title = {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = modifier
                    .padding(top = 20.dp)
            ) {
                Text(
                    text = "30 Days Of Wellness",
                    style = MaterialTheme.typography.displayLarge
                )
            }
        }
    )
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WellnessApp(){


    Scaffold(
        topBar = { WellTopAppBar() }
    ) {
        LazyColumn(
            modifier = Modifier,
            contentPadding = it


            ) {
            items(wellness) {
                WellItem(
                    well = it,
                    modifier = Modifier
                        .padding(10.dp)

                    )
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WellItem(
    well: Well,
    modifier: Modifier = Modifier
){

    var expanded by remember {
            mutableStateOf(false)
    }

    
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ) ,
            modifier = modifier

                . clip(MaterialTheme.shapes.medium),
            onClick = {expanded = !expanded}
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(id = R.dimen.padding_medium))
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioNoBouncy,
                            stiffness = Spring.StiffnessLow ,

                            )
,
                    )
            ) {
                WellInfo(
                    head = well.nameRes,
                    image = well.imageRes,


                )

                if(expanded){
                    WellDes(des = well.descriptionRes)
                }
            }
        }

}

@Composable
fun WellDes(
    @StringRes des: Int,
    modifier: Modifier = Modifier
){
    Text(
        text = stringResource(id = des),
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier
            .padding(top = 15.dp)
    )
}






@Composable
fun WellInfo(
    @StringRes head: Int,
    @DrawableRes image: Int,
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

        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 400.dp, height = 300.dp)
                .clip(MaterialTheme.shapes.small)
        )


    }

}


@Preview(showBackground = true)
@Composable
fun WellnessPreview() {
    WellnessTheme {

    }
}