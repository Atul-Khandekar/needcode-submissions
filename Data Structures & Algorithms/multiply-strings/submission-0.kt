class Solution {
    fun multiply(num1: String, num2: String): String {

        if(num1 == "0" || num2 == "0") return "0"
        
        val result = IntArray(num1.length + num2.length) 

        for (i in num1.length - 1 downTo 0) {
            for (j in num2.length - 1 downTo 0) {
                val mul = num1[i].digitToInt() * num2[j].digitToInt()
                
                
                val p1 = i + j
                val p2 = i + j + 1
                
               
                val sum = mul + result[p2]
                
                result[p2] = sum % 10
                result[p1] += sum / 10
            }
        }

        val sb = StringBuilder()
        for (digit in result) {
            if (!(sb.isEmpty() && digit == 0)) {
                sb.append(digit)
            }
        }
        
        return sb.toString()
    }
}