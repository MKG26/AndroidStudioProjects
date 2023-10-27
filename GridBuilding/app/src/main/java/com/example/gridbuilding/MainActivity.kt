package com.example.gridbuilding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridbuilding.data.Datasource
import com.example.gridbuilding.model.Grid
import com.example.gridbuilding.ui.theme.GridBuildingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridBuildingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GridApp()
                }
            }
        }
    }
}

@Composable
fun GridApp(){
    GridList(gridList = Datasource().loadGrids())
}


@Composable
fun GridList(gridList: List<Grid>, modifier: Modifier= Modifier){

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ){
        items(gridList){    grid ->

            GridCard(
                grid = grid,
                modifier = Modifier

            )

        }
    }


}




@Composable
fun GridCard(grid: Grid, modifier: Modifier = Modifier) {
    Card(modifier = modifier

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                painter = painterResource(id = grid.imageResourceId),
                contentDescription = stringResource(id = grid.stringResourceId),
                modifier = Modifier
                    .size(width = 68.dp, height = 68.dp)
                    ,
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = modifier




            ) {
                Text(
                    text = stringResource(id = grid.stringResourceId),
                    modifier = Modifier
                        .padding(start = 16.dp,top = 16.dp,end = 16.dp, bottom = 8.dp)
                )

                Row(
                    modifier = modifier


                ) {
                    Icon(
                        modifier = Modifier
                            .padding(start = 16.dp),

                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,


                        
                    )
                    
                    Text(
                        modifier = Modifier
                            .padding(start = 8.dp),
                        text = stringResource(id = grid.numberResourceId))
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    GridBuildingTheme {
        GridCard(Grid(R.string.grid1,R.drawable.architecture,R.string.number1))
    }
}