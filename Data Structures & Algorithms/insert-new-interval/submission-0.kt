class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        
        var mInterval = newInterval.copyOf()
        val res = mutableListOf<IntArray>()
        for(interval in intervals) {

            if(mInterval.size == 0){
                res.add(interval)
                continue
            }
            //if there is overlap 
            if( (interval[0]<=mInterval[1] && interval[0] >= mInterval[0]) || 
                (mInterval[0]<=interval[1] && mInterval[0] >= interval[0])
              ){

                // merge the interval 
                mInterval[0] = minOf(interval[0],mInterval[0])
                mInterval[1] = maxOf(interval[1], mInterval[1])

              } else {
                
                if(interval[1] < mInterval[1]) {
                    res.add(interval)
                } else {
                    res.add(mInterval)
                    res.add(interval)
                    mInterval = intArrayOf()
                }

              } 

        }

        if(mInterval.size != 0) res.add(mInterval)

        return res.toTypedArray()
    }
}