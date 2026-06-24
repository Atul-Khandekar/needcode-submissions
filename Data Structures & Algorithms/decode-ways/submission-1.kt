class Solution {
    fun numDecodings(s: String): Int {

        if(s[0] == '0') return 0

        val n = s.length 

        val dp = IntArray(n+1)

        dp[0] = 1 
        dp[1] = 1
        
        for(i in 2..n) {
            val one = s[i-1] - '0'
            if(one in 1..9) dp[i] += dp[i-1]

            val two = (s[i-2]-'0')*10 + one 
            if(two in 10..26) dp[i] += dp[i-2]
        }

        return dp[n]
        
    }
}