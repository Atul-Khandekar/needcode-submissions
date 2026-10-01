class Solution {
    fun countSubstrings(s: String): Int {
        
        var count = 0 
        val n = s.length

        fun expand(left: Int,right: Int) {

            var l = left
            var r = right 
            
            while(l >= 0 && r < n && s[l] == s[r]) {
                count++
                l--
                r++
            }
        }

        for(i in s.indices) {
            expand(i,i)
            expand(i,i+1)
        }

        return count
    }
}