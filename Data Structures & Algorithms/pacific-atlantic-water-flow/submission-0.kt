class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {

        val atlanticSet = HashSet<Pair<Int,Int>>()
        val pacificSet = HashSet<Pair<Int,Int>>()

        val m = heights.size
        val n = heights[0].size

        val vis = Array(m){IntArray(n){0}}
        val vis_pacific = Array(m){IntArray(n){0}}

        for(i in 0..<n) {
            //pacific edge cells 
            pacificSet.add(Pair(0,i))
            vis_pacific[0][i]=1

            // atlantic edge cells
            atlanticSet.add(Pair(m-1,i))
            vis[m-1][i]=1
        }

        for(i in 0..<m) {
             //pacific edge cells 
            pacificSet.add(Pair(i,0))
            vis_pacific[i][0]=1


            // atlantic edge cells
            atlanticSet.add(Pair(i,n-1))
            vis[i][n-1]=1
        }

        val atlanticQueue = ArrayDeque<Pair<Int,Int>>(atlanticSet)
        val pacificQueue = ArrayDeque<Pair<Int,Int>>(pacificSet)


        while(!atlanticQueue.isEmpty()) {
            val (row,col) = atlanticQueue.poll()
            val currentHeight = heights[row][col]
            travelFromAtlanticOceanCell(row,col-1,currentHeight,heights,vis,atlanticSet,atlanticQueue)
            travelFromAtlanticOceanCell(row,col+1,currentHeight,heights,vis,atlanticSet,atlanticQueue)
            travelFromAtlanticOceanCell(row-1,col,currentHeight,heights,vis,atlanticSet,atlanticQueue)
            travelFromAtlanticOceanCell(row+1,col,currentHeight,heights,vis,atlanticSet,atlanticQueue)
        }

        while(!pacificQueue.isEmpty()) {
            val (row,col) = pacificQueue.poll()
            val currentHeight = heights[row][col]
            travelFromPacificOceanCell(row,col-1,currentHeight,heights,vis_pacific,pacificSet,pacificQueue)
            travelFromPacificOceanCell(row,col+1,currentHeight,heights,vis_pacific,pacificSet,pacificQueue)
            travelFromPacificOceanCell(row-1,col,currentHeight,heights,vis_pacific,pacificSet,pacificQueue)
            travelFromPacificOceanCell(row+1,col,currentHeight,heights,vis_pacific,pacificSet,pacificQueue)
        }
        val result = mutableListOf<List<Int>>()

        for(s in atlanticSet) {
            if(pacificSet.contains(s)) {
                result.add(listOf(s.first, s.second))
            }
        }

        return result 

    }

          fun travelFromAtlanticOceanCell(row:Int,col:Int, currentHeight:Int,heights:Array<IntArray>,vis: Array<IntArray>,atlanticSet: HashSet<Pair<Int,Int>>, queue: ArrayDeque<Pair<Int,Int>>) {

            if(row>=0 && row<heights.size && col>=0 && col<heights[0].size && heights[row][col]>=currentHeight && vis[row][col]==0) {
                val p = Pair(row,col)
                atlanticSet.add(p)
                queue.add(p)
                vis[row][col] =1
            }

        }

                  fun travelFromPacificOceanCell(row:Int,col:Int, currentHeight:Int,heights:Array<IntArray>,vis: Array<IntArray>,pacificSet: HashSet<Pair<Int,Int>>, queue: ArrayDeque<Pair<Int,Int>>) {

            if(row>=0 && row<heights.size && col>=0 && col<heights[0].size && heights[row][col]>=currentHeight && vis[row][col]==0) {
                val p = Pair(row,col)
                pacificSet.add(p)
                queue.add(p)
                vis[row][col] =1
            }

        }


        
}