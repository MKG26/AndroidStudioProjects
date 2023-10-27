package com.example.superhero

import SuperHeroTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superhero.data.Hero
import com.example.superhero.data.heroes


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroTheme{
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()

                ) {
                    HeroApp()
                }
            }
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroTopAppBar(modifier: Modifier= Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(top= 20.dp)

            ) {
                    Text(
                        text = "Superheroes",
                        style = MaterialTheme.typography.displayLarge
                    )
            }
        },
        modifier = modifier
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroApp(){

    Scaffold(
        topBar ={
            HeroTopAppBar()
        }
    ) {


        LazyColumn(
            modifier = Modifier
                .padding(top = 10.dp),
            contentPadding = it
        ) {
            items(heroes) {
                HeroItems(
                    hero = it,

                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        }
    }
}


@Composable
fun HeroItems(
    hero: Hero,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium)),

        ) {
            HeroInfo(
                name = hero.nameRes , 
                heroInfo = hero.descriptionRes,
                modifier = Modifier
                    .padding(end = 16.dp)
            )
            
                
            Spacer(modifier = Modifier.weight(1f))
            
            HeroIcon(
                heroIcon = hero.imageRes,




            )
        }
    }
}



@Composable
fun HeroIcon(
    modifier: Modifier = Modifier,
    @DrawableRes heroIcon: Int,
){
    Image(
        painter = painterResource(id = heroIcon) ,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(dimensionResource(id = R.dimen.image_size))
            .clip(MaterialTheme.shapes.small)


    )

}



@Composable
fun HeroInfo(
    @StringRes name: Int,
    @StringRes heroInfo: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier

    ) {
        Text(
            text = stringResource(id = name),
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier

        )

        Text(
            text = stringResource(id = heroInfo),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Justify

        )
    }

}





@Preview(showBackground = true)
@Composable
fun HeroesPreview() {

}