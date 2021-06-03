package fr.destouesse.gameoflife.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.destouesse.gameoflife.model.GameCoordinate
import fr.destouesse.gameoflife.model.GameMap
import fr.destouesse.gameoflife.model.GameRunner
import fr.destouesse.gameoflife.model.OnGameRunnerListener

class MainViewModel: ViewModel(){
    private val TAG = "MainViewModel"
    val currentMap: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    lateinit var gameRunner: GameRunner

    fun initGame(){
        var gameMapSize = GameCoordinate(10,10)
        var gameActiveInitCells = listOf<GameCoordinate>(
            GameCoordinate( 4,4) ,
            GameCoordinate( 5,3),
            GameCoordinate( 6,4),
            GameCoordinate( 6,5)
        )

        gameRunner = GameRunner( gameMapSize ,
            200,
            gameActiveInitCells)

        var map = gameRunner.start()
        currentMap.value = map.toString()
    }

    fun nextIteration(){
        var map = gameRunner.next()
        currentMap.value = map.toString()
    }

}