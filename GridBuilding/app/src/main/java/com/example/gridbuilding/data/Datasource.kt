package com.example.gridbuilding.data

import com.example.gridbuilding.R
import com.example.gridbuilding.model.Grid

class Datasource() {
    fun loadGrids(): List<Grid> {
        return listOf<Grid>(
            Grid(R.string.grid1,R.drawable.architecture, R.string.number1) ,
            Grid(R.string.grid2,R.drawable.crafts, R.string.number2),
            Grid(R.string.grid3,R.drawable.business, R.string.number3),
            Grid(R.string.grid4,R.drawable.culinary, R.string.number4),
            Grid(R.string.grid5,R.drawable.design, R.string.number5),
            Grid(R.string.grid6,R.drawable.fashion, R.string.number6),
            Grid(R.string.grid7,R.drawable.film, R.string.number7),
            Grid(R.string.grid8,R.drawable.gaming, R.string.number8),
            Grid(R.string.grid9,R.drawable.drawing, R.string.number9),
            Grid(R.string.grid10,R.drawable.lifestyle, R.string.number10),
            Grid(R.string.grid11,R.drawable.music, R.string.number11),
            Grid(R.string.grid12,R.drawable.painting, R.string.number12),
            Grid(R.string.grid13,R.drawable.photography, R.string.number13),
            Grid(R.string.grid14,R.drawable.tech, R.string.number14),
        )
    }
}