class Solution {
    fun foreignDictionary(words: Array<String>): String {

        val adj = HashMap<Char,MutableList<Char>>()
        for (word in words) {
            for (char in word) {
                adj.putIfAbsent(char, mutableListOf())
            }
        }

        for(i in 0 until words.size - 1) {
            val w1 = words[i]
            val w2 = words[i+1]

            val minLength = Math.min(w1.length, w2.length)

            if(w1.length > w2.length && w1.substring(0,minLength)== w2.substring(0,minLength)) {
                return ""
            }

            for(j in 0 until minLength) {
                if(w1[j]!=w2[j]) {
                    if(adj[w1[j]]==null) {
                        adj[w1[j]] = mutableListOf(w2[j])
                    } else {
                        adj[w1[j]]?.add(w2[j])
                    }

                    break
                }
            }
        }

        val visit = HashMap<Char,Boolean>()
        val res = mutableListOf<Char>()

        fun dfs(c: Char): Boolean {

            if(visit[c] != null) {
                return visit[c]!!
            }

            visit[c] = true

            for( n in adj[c]!!) {
                if(dfs(n)) {
                    return true
                }
            }

            visit[c] = false

            res.add(c)

            return false
        }

        for(key in adj.keys) {
            if(dfs(key)) {
                return ""
            }
        }

        return res.joinToString("").reversed()

    }
}
