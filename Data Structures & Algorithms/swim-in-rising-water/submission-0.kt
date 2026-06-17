class Solution {
    fun swimInWater(grid: Array<IntArray>): Int {
        
        val n = grid.size
        val visited = Array(n){BooleanArray(n)} 

        var height = 0 
        var q = PriorityQueue<Triple<Int,Int,Int>>(compareBy { it.first }) 

        var r = 0 
        var c = 0 
        q.add(Triple(grid[0][0],r,c)) 

        while( !(q.isEmpty())) {

            val (h,r,c) = q.poll()
    
            if(visited[r][c]) continue 
            visited[r][c] = true

            
            height = Math.max(height,h)

            if(r == n - 1 && c == n - 1) {
                return height
            }

            if(r+1 < n && !visited[r+1][c]) {
                q.add(Triple(grid[r+1][c],r+1,c))
            }

             if(r-1 >= 0 && !visited[r-1][c]) {
                q.add(Triple(grid[r-1][c],r-1,c))
            }

             if(c+1 < n && !visited[r][c+1]) {
                q.add(Triple(grid[r][c+1],r,c+1))
            }

             if(c-1 >=0 && !visited[r][c-1]) {
                q.add(Triple(grid[r][c-1],r,c-1))
            }
        }
        
        return height

    }
}