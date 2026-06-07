class Solution {
    fun letterCombinations(digits: String): List<String> {

        if(digits.isEmpty()) return emptyList<String>()

        val map: Map<String,String> = mapOf(
            "2" to "abc",
            "3" to "def",
            "4" to "ghi",
            "5" to "jkl",
            "6" to "mno",
            "7" to "pqrs",
            "8" to "tuv",
            "9" to "wxyz"
        )

        val res = mutableListOf<String>()
        val sub = StringBuilder("")

        fun dfs(i:Int) {
            if(i >= digits.length) {
                val new = sub.toString()
                res.add(new)
                return
            }

            val str  = map[digits[i].toString()]!!
            for(j in str.indices) {
                sub.append(str[j])
                dfs(i+1)
                sub.deleteAt(sub.length - 1)
            }
        }

        dfs(0)
        return res.toList()
    }
}
