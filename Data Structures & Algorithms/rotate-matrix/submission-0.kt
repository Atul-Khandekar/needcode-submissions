class Solution {
    fun rotate(matrix: Array<IntArray>) {

        for(i in matrix.indices) {
            for(j in i + 1 until matrix.size) {
               var temp = matrix[i][j]
               matrix[i][j] = matrix[j][i]
               matrix[j][i] = temp
            }
        }

        for (i in 0 until matrix.size) {
            var left = 0
            var right = matrix.size - 1
            while (left < right) {
                val temp = matrix[i][left]
                matrix[i][left] = matrix[i][right]
                matrix[i][right] = temp
                left++
                right--
            }
    }
       
    }
}
