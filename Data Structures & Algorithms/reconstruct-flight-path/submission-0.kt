class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {

        val map = HashMap<String,PriorityQueue<String>>()

        for( (from,to) in tickets) {
            if(map[from]==null) {
                map[from] = PriorityQueue<String>()
            } 
            map[from]!!.add(to)
        }

        val result = mutableListOf<String>()
        fun dfs(airport: String) {
        val q = map[airport]

        while( q!=null && !(q.isEmpty())) {
            val next = q.poll()
            dfs(next)
        }
        result.add(0,airport)
       }

       dfs("JFK")
        
        return result
    }
}