package fr.destouesse.gameoflife.model

interface OnGameRunnerListener {
    fun onMapChanged(_map: GameMap)
    fun onGameFinished(_map: GameMap)
    fun onGameStarted(_map: GameMap)

}