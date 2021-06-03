package fr.destouesse.gameoflife.model

class GameMap(_size: GameCoordinate) {
    var size = _size
    var mapCells = Array(_size.x){Array(_size.y){GameCell()} }

    override
    fun toString():String{
        var builder = StringBuilder()
        builder.append("\n")
        for (yCell in 0..(size.y-1)){
            for (xCell in 0..(size.x-1)){
                if(mapCells[xCell][yCell].isAlive){
                    builder.append("*")
                }else{
                    builder.append("-")
                }
            }
            builder.append("\n")
        }

        return builder.toString()
    }
}