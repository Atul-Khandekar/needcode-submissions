class CountSquares {

   val map = HashMap<List<Int>,Int>()

    fun add(point: IntArray) {
        
        map[point.toList()] = (map[point.toList()] ?: 0) + 1
    }

    fun count(point: IntArray): Int {
        var count = 0
        var hList = mutableListOf<List<Int>>()
        var vList = mutableListOf<List<Int>>()
        for( key in map.keys) {
            if(key[1] == point[1]) {
                hList.add(key)
                continue
            }

            if(key[0] == point[0]) {
                vList.add(key)
            }
        }

        
        for(hp in hList) {
            val hpCount = map[hp]!!
            for(vp in vList) {
                
                val dx = Math.abs(hp[0] - point[0])
                val dy = Math.abs(vp[1] - point[1])

                if(dx != dy || dx == 0) continue

                val vpCount = map[vp]!!
                val diag = listOf(hp[0],vp[1])
                if(map[diag] != null){ 
                    count += ( hpCount * vpCount * (map[diag]?:0))
                }
            }
        }

        return count
    }

}
