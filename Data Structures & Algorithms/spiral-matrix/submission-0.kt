class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        
        val m = matrix.size 
        val n = matrix[0].size 
        val list = mutableListOf<Int>()

        var top = 0 
        var left = 0 
        var right = n - 1
        var bottom = m - 1

        while( left <= right && top <= bottom) {
            for(i in left .. right) list.add(matrix[top][i])

            top++ 

            for(i in top .. bottom) list.add(matrix[i][right])
            right--

            if(top<= bottom) {
                for(i in right downTo left) {
                    list.add(matrix[bottom][i])
                }
                bottom--
            }

            if(left <= right) {
                for(i in bottom downTo top) {
                    list.add(matrix[i][left])
                }
                left++
            }
        }

        return list
    }
}