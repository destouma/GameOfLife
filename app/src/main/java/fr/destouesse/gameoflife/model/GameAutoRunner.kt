package fr.destouesse.gameoflife.model

class GameAutoRunner(_nbIterations: Int,
                     _size: GameCoordinate,
                     _initAliveCells: List<GameCoordinate>,
                     _listenerAuto: OnGameAutoRunnerListener) {

    private val nbIterations = _nbIterations
    private val gameRunner = GameRunner(_size,_initAliveCells)
    private val listener = _listenerAuto

    fun start(){
         listener.onGameStarted(gameRunner.start())
    }

    fun run(){
        for(iter in 0..(nbIterations-1)){
            listener.onMapChanged(gameRunner.next())
        }
        listener.onGameFinished()
    }

}