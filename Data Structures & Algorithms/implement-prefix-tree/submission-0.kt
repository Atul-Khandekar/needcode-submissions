class PrefixTree {

 val root = TrieNode()

    fun insert(word: String) {
        var curr = root
        
        for(c in word) {
            if(curr.map[c]==null) {
                curr.map[c] = TrieNode()
            }
            curr = curr.map[c]!!
        }

        curr.endOfTheWord = true
    
    }

    fun search(word: String): Boolean {
        
        var curr = root 
        for(c in word) {
            if(curr.map[c]==null) {
                return false
            }
            curr = curr.map[c]!!
        }

        return curr.endOfTheWord
    }

    fun startsWith(prefix: String): Boolean {
        
        var curr = root 
        for( c in prefix) {
            if(curr.map[c]==null) {
                return false
            }
            curr = curr.map[c]!!
        }
        return true
    }

    class TrieNode() {
    val map = HashMap<Char, TrieNode>()
    var endOfTheWord = false
}

}
