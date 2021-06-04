package fr.destouesse.gameoflife.model

class GameAutoRunner(_nbIterations: Int,
                     _size: GameCoordinate,
                     _initAliveCells: List<GameCoordinate>,
                     _listener: OnGameRunnerListener) {

    val nbIterations = _nbIterations
    val gameRunner = GameRunner(_size,_initAliveCells)
    val listener = _listener

    fun start(){
         listener.onGameStarted(gameRunner.start())
    }

    fun run(){
        for(iter in 0..(nbIterations-1)){
            listener.onMapChanged(gameRunner.next())
        }
        listener.onGameFinished(gameRunner.gameMap)
    }

}