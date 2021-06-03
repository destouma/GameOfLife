package fr.destouesse.gameoflife.model

interface OnGameRunnerListener {
    fun onMapChanged(_map: GameMap)
    fun onGameStarted()
    fun onGameFinished()
}