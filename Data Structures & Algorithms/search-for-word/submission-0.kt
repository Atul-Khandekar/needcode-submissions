class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {

        val rows = board.size
        val cols = board[0].size
        val path = mutableSetOf<Pair<Int,Int>>()

        fun dfs(r: Int, c: Int, i: Int): Boolean {

            if(i==word.length) return true 

            if(r < 0 || c < 0 || r >= rows || c >= cols || word[i] != board[r][c] || path.contains(Pair(r,c))) {
                return false
            }

            path.add(Pair(r,c)) 

            val res = dfs(r+1,c,i+1) || dfs(r-1,c,i+1) || dfs(r,c+1,i+1) || dfs(r,c-1,i+1) 

            path.remove(Pair(r,c))

            return res

        }

        for( i in board.indices) {
            for( j in board[i].indices) {
                if(dfs(i,j,0)) return true
            }
        }

        return false
        
    }
}
