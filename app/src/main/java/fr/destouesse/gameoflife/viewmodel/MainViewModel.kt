package fr.destouesse.gameoflife.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.destouesse.gameoflife.model.GameCoordinate
import fr.destouesse.gameoflife.model.GameRunner

class MainViewModel: ViewModel(){
    val currentMap: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private lateinit var gameRunner: GameRunner

    fun initGame(){
        val gameMapSize = GameCoordinate(20,20)
        val gameActiveInitCells = listOf(
            GameCoordinate( 9,9) ,
            GameCoordinate( 10,9),
            GameCoordinate( 11,9),
            GameCoordinate( 10,10),
            GameCoordinate( 10,8)
        )

        gameRunner = GameRunner( gameMapSize ,
            gameActiveInitCells)

        currentMap.value = gameRunner.start().toString()
    }

    fun nextIteration(){
        currentMap.value = gameRunner.next().toString()
    }

}