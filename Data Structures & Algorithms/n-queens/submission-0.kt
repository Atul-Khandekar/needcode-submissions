class Solution {
    fun solveNQueens(n: Int): List<List<String>> {

        val cols = mutableSetOf<Int>()
        val posDiag = mutableSetOf<Int>()
        val negDiag = mutableSetOf<Int>()

        val res = mutableListOf<List<String>>()
        val board = MutableList(n){CharArray(n){'.'}}

        fun backtrack(r: Int) {

            if(r == n) {
                val new = board.map{ String(it)}
                res.add(new)
                return
            }

            for( c in 0 until n) {
                if( cols.contains(c) || posDiag.contains(r+c) || negDiag.contains(r-c)) {
                    continue
                }

                cols.add(c)
                posDiag.add(r+c)
                negDiag.add(r-c)
                board[r][c] = 'Q'

                backtrack(r+1)

                cols.remove(c)
                posDiag.remove(r+c)
                negDiag.remove(r-c)
                board[r][c] = '.'
            }
        }

        backtrack(0)
        return res.toList()        
    }
}