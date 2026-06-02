class Twitter() {

    val map = HashMap<Int,MutableSet<Int>>()
    var left = Node(Tweet(-1,-1))
    var right = Node(Tweet(-1,-1))

    init {
        left?.next = right
        right?.prev = left
    }

    fun addTweet(tweet: Tweet) {
        val newNode = Node(tweet)
        val lastNode = right?.prev 
        lastNode?.next = newNode
        newNode?.prev = lastNode
        newNode?.next = right
        right?.prev = newNode
    }
    

    fun postTweet(userId: Int, tweetId: Int) {
        val tweet = Tweet(userId,tweetId)
        addTweet(tweet)
    }

    fun getNewsFeed(userId: Int): List<Int> {
        var curr = right?.prev
        val list = mutableListOf<Int>()
        var count = 0 

        while(curr!= null && curr?.tweet?.userId != -1 ) {
            if((map[userId]?.contains(curr?.tweet?.userId!!) == true )|| (curr?.tweet?.userId!! == userId)){
                count++
                list.add(curr?.tweet?.tweetId!!) 
            }
            curr = curr?.prev
            if(count == 10) return list.toList()
        }

        return list.toList()
    }

    fun follow(followerId: Int, followeeId: Int) {
        if(map[followerId]== null) {
            map[followerId] = mutableSetOf(followeeId)
        } else {
            map[followerId]?.add(followeeId)
        }
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        map[followerId]?.remove(followeeId)
    }

}

class Node(var tweet: Tweet) {
    var next: Node? = null 
    var prev: Node? = null
}

data class Tweet(val userId: Int, val tweetId: Int)

/**
 * Your Twitter object will be instantiated and called as such:
 * var obj = Twitter()
 * obj.postTweet(userId,tweetId)
 * var param_2 = obj.getNewsFeed(userId)
 * obj.follow(followerId,followeeId)
 * obj.unfollow(followerId,followeeId)
 */