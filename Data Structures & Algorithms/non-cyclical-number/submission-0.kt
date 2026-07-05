class Solution {
    fun isHappy(n: Int): Boolean {
        
        var slow= n
        var fast = getnext(n)

        while(fast!=1 && slow !=fast){
            slow = getnext(slow)
            fast = getnext(getnext(fast))
        }

        return fast == 1

    }

    fun getnext(i: Int):Int{
            var totalSum = 0 
            var num = i
            while(num> 0){
                var d = num% 10
                totalSum += d*d
                num = num/10
            }

            return totalSum
        }
}