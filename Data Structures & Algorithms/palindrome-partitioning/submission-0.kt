class Solution {
    fun partition(s: String): List<List<String>> {
        val res = mutableListOf<List<String>>()
        val sub = mutableListOf<String>()

        fun isPalindrome(str: String): Boolean {
            val new = str.reversed()
            return new==str
        }

        fun dfs(i:Int) {
            if(i>=s.length) {
                val new = sub.toList()
                res.add(new)
                return
            }

            for(j in i until s.length) {
                if(isPalindrome(s.substring(i,j+1))) {
                    sub.add(s.substring(i,j+1))
                    dfs(j+1)
                    sub.removeLast()
                }
            }
        }

        dfs(0)

        return res.toList()
    }
}
