package fr.destouesse.gameoflife.model

class GameRunner ( _size: GameCoordinate,
                  _nbIterations: Int,
                  _initAliveCells: List<GameCoordinate>)  {

    var size = _size
    var gameMap = GameMap(_size)
    var nbIterations = _nbIterations
    var initAliveCells = _initAliveCells

    fun start():GameMap{
        initAliveCells.forEach { activeCell ->
            gameMap.mapCells[activeCell.x][activeCell.y].isAlive = true
        }
        return gameMap;
    }

    fun next():GameMap{
        var iterMap = gameMap
        gameMap = createNewMap(iterMap)
        return gameMap
    }

    fun createNewMap(initMap: GameMap) : GameMap{
        var nextGameMap = GameMap(gameMap.size)
        for (yCell in 0..(size.y-1)){
            for (xCell in 0..(size.x-1)){
                nextGameMap.mapCells[xCell][yCell].isAlive = nextStatus(xCell,yCell,initMap)
            }
        }
        return nextGameMap

    }

    fun nextStatus(_x: Int, _y: Int, _gameMap: GameMap): Boolean {
        var nbAliveArround = 0

        if(isInRange(_x-1,_y-1)){
            if(_gameMap.mapCells[_x-1][_y-1].isAlive) nbAliveArround++
        }
        if(isInRange(_x,_y-1)){
            if(_gameMap.mapCells[_x][_y-1].isAlive) nbAliveArround++
        }
        if(isInRange(_x+1,_y-1)){
            if(_gameMap.mapCells[_x+1][_y-1].isAlive) nbAliveArround++
        }
        if(isInRange(_x+1,_y)){
            if(_gameMap.mapCells[_x+1][_y].isAlive) nbAliveArround++
        }
        if(isInRange(_x+1,_y+1)){
            if(_gameMap.mapCells[_x+1][_y+1].isAlive) nbAliveArround++
        }
        if(isInRange(_x,_y+1)){
            if(_gameMap.mapCells[_x][_y+1].isAlive)nbAliveArround++
        }
        if(isInRange(_x-1,_y+1)){
            if(_gameMap.mapCells[_x-1][_y+1].isAlive)nbAliveArround++
        }
        if(isInRange(_x-1,_y)){
            if(_gameMap.mapCells[_x-1][_y].isAlive)nbAliveArround++
        }

        return (nbAliveArround == 3) || ((nbAliveArround == 2) && _gameMap.mapCells[_x][_y].isAlive)
    }

    fun isInRange(_x: Int, _y: Int): Boolean {
        return ( (_x > 0) &&
                (_x < size.x) &&
                (_y > 0) &&
                (_y < size.y) )
    }

}