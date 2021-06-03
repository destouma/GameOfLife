package fr.destouesse.gameoflife.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import fr.destouesse.gameoflife.R
import fr.destouesse.gameoflife.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private val mainViewModel =  MainViewModel()

    private val buttonGame by lazy {
        findViewById<Button>(R.id.button_game)
    }

    private val textGameMap by lazy {
        findViewById<TextView>(R.id.text_game)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGame.setOnClickListener(){
            mainViewModel.nextIteration()
        }
        mainViewModel.initGame()

        val mapObserver = Observer<String> { newMap ->
            textGameMap.text = newMap
        }
        mainViewModel.currentMap.observe(this, mapObserver)
    }

}