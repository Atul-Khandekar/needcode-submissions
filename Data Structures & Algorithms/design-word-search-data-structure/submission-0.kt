class WordDictionary {

    val root = TrieNode()

    fun addWord(word: String) {
        var curr = root 

        for(c in word) {
            if(curr.map[c] == null) {
                curr.map[c] = TrieNode()
            }
            curr = curr.map[c]!!
        }
        curr.isEndOfTheWord = true
    }

    fun search(word: String): Boolean {

        fun dfs(i: Int, root: TrieNode): Boolean {

            var curr = root 

            for( j in i until word.length) {
                val c = word[j]

                if(c == '.') {
                    for( value in curr.map.values) {
                        if(dfs(j+1,value)) return true
                    }
                    return false

                } else {
                    if(curr.map[c] == null) {
                        return false
                    }
                    curr = curr.map[c]!!
                }
            }

            return curr.isEndOfTheWord
        }

        return dfs(0,root)
    }

    

    class TrieNode() {
        var map = HashMap<Char,TrieNode>()
        var isEndOfTheWord = false
    }
}
