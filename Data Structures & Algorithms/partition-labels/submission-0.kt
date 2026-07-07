class Solution {
    fun partitionLabels(s: String): List<Int> {

        val lastIndex = HashMap<Char,Int>()

        for(i in 0 until s.length) {
            lastIndex[s[i]] = i 
        }

        var size = 0 
        var end = 0
        val res = mutableListOf<Int>()

        for(i in 0 until s.length){
            size++ 
            end = maxOf(end,lastIndex[s[i]]!!)
            
            if(i == end) {
                res.add(size)
                size = 0 
            }
        }

        return res
        
    }
}