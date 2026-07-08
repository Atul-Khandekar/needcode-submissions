class Solution {
    fun checkValidString(s: String): Boolean {
        
        if(s.length == 1) return s[0] == '*'

        var leftMin = 0 
        var leftMax = 0

        for( c in s){
            if(c == '(') {
                leftMin ++ 
                leftMax ++ 
            } else if(c == ')'){
                leftMin -- 
                leftMax --
            } else{
              leftMin -- 
              leftMax ++  
            } 

            if(leftMax< 0) return false 
            if(leftMin< 0) leftMin = 0 
        }

        return leftMin == 0
    }
}