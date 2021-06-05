package fr.destouesse.gameoflife.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import fr.destouesse.gameoflife.R
import fr.destouesse.gameoflife.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {
    private val mainViewModel =  MainViewModel()

    private val buttonGameNext by lazy {
        findViewById<Button>(R.id.button_game)
    }

    private val buttonGameStart by lazy {
        findViewById<Button>(R.id.button)
    }

    private val textGameMap by lazy {
        findViewById<TextView>(R.id.text_game)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGameNext.setOnClickListener {
            mainViewModel.nextIteration()
        }

        buttonGameStart.setOnClickListener {
            mainViewModel.initGame()
        }

        val mapObserver = Observer<String> { newMap ->
            textGameMap.text = newMap
        }

        mainViewModel.initGame()
        mainViewModel.currentMap.observe(this, mapObserver)
    }

}