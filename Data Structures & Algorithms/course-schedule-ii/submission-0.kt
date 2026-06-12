class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        
        val prereq = Array(numCourses){ mutableListOf<Int>() }

        for(i in prerequisites.indices) {
            val arr = prerequisites[i]
            prereq[arr[0]].add(arr[1])
        }

        val output = mutableListOf<Int>()

        val visit = mutableSetOf<Int>()
        val cycle = mutableSetOf<Int>()


        fun dfs(course: Int):  Boolean {
            
            if(cycle.contains(course)) return false 

            if(visit.contains(course)) return true

            cycle.add(course)

            for(c in prereq[course]) {
                if(dfs(c)==false) return false
            }

            cycle.remove(course)
            visit.add(course)
            output.add(course)

            return true
        }

        for( c in 0 until numCourses) {
            if(dfs(c)==false) return intArrayOf()
        }

        return output.toIntArray()
    }
}