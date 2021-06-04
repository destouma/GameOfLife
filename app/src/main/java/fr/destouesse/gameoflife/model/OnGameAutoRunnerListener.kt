package fr.destouesse.gameoflife.model

interface OnGameAutoRunnerListener {
    fun onGameStarted(_map: GameMap)
    fun onMapChanged(_map: GameMap)
    fun onGameFinished()

}