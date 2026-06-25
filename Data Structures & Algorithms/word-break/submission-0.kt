class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {

        val set = wordDict.toHashSet()
        val n = s.length 
        val maxLen = set.maxOf{it.length}

        val dp = BooleanArray(n+1)

        dp[0] = true

        for(i in 1..n) {

            for(j in maxOf(0,i-maxLen) until i) {
                if(dp[j] && s.substring(j,i) in set) {
                    dp[i] = true
                    break
                }
            }
        }

        return dp[n]
        
    }
}