class Solution {
    fun longestPalindrome(s: String): String {
        
        var maxLen = 0 
        var res = ""
        
        for(i in s.indices) { 

            var l = i
            var r = i
            while( l >= 0 && r <  s.length && s[l] == s[r] ) {
                if(r-l+1 > maxLen) {
                    res = s.substring(l,r+1)
                    maxLen = r-l+1
                }
                l-- 
                r++
            }

            //for the evan
            l = i 
            r = i+1 
            while( l >= 0 && r <  s.length && s[l] == s[r] ) {

                if(r-l+1 > maxLen) {
                    res = s.substring(l,r+1)
                    maxLen = r-l+1
                }
                
                l-- 
                r++
            }
        }

        return res
    }
}