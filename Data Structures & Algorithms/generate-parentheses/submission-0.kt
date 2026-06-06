class Solution {
    fun generateParenthesis(n: Int): List<String> {

        val res = mutableListOf<String>()
        val sub = StringBuilder("")

        fun backtrack(o: Int, c: Int) {

            if(o==n && c==n) {
                val new = sub.toString()
                res.add(new)
                return
            }

            if(o<n) {
                sub.append("(")
                backtrack(o+1,c)
                sub.deleteAt(sub.length-1)
            }

            if(c < o) {
                sub.append(")")
                backtrack(o,c+1)
               sub.deleteAt(sub.length-1)
            }
        }

        backtrack(0,0)

        return res.toList()

    }
}
