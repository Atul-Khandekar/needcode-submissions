class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {

        if(hand.size % groupSize != 0) return false

        val map = HashMap<Int,Int>()
        val q = PriorityQueue<Int>()

        for(num in hand) {
            map[num] = (map[num]?:0) + 1 
        }

        q.addAll(map.keys.toList())

        while(!q.isEmpty()) {
            var start = q.peek()

            for( i in start until  start + groupSize) {
                if(map[i] == null ) {
                    return false
                } else {
                    map[i] = (map[i] ?:0) - 1

                    if(map[i] == 0) {
                        val top = q.poll()
                        if(i != top) {
                            return false
                        }
                    }
                }
            }
        }

        return true
        
    }
}