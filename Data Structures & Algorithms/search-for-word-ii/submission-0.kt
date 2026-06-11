class Solution {

    val root = Trie()

    class Trie() {
        var map = HashMap<Char,Trie>()
        var end = false
    }

    fun addWord(word: String) {
        var curr = root 
        for( c in word) {
            if(curr.map[c]==null) {
                curr.map[c] = Trie()
            }
            curr = curr.map[c]!!
        }
        curr.end = true
    }

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {

        val vis = MutableList(board.size){MutableList(board[0].size){0}}

        for( word in words) {
            addWord(word)
        }

        val res = mutableSetOf<String>()
        val sub = mutableListOf<Char>()
        val rows = board.size
        val cols = board[0].size

        fun dfs(i: Int, j: Int, root: Trie) {

            if(i<0 || j <0 || i >= rows || j >= cols || root?.map[board[i][j]] == null || vis[i][j]==1) {
                return 
            }

            vis[i][j] = 1
            sub.add(board[i][j])

            if(root?.map[board[i][j]]?.end == true) {
                val new = sub.joinToString("")
                res.add(new)
            }

           

            dfs(i+1,j,root?.map[board[i][j]]!!)
            dfs(i-1,j,root?.map[board[i][j]]!!)
            dfs(i,j+1,root?.map[board[i][j]]!!)
            dfs(i,j-1,root?.map[board[i][j]]!!)

            vis[i][j] = 0
            sub.removeAt(sub.size - 1)
        }

        for(i in board.indices) {
            for( j in board[i].indices) {
                dfs(i,j,root)
            }
        }

        return res.toList()
        
    }

    
}