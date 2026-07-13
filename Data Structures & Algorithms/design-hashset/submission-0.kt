class MyHashSet() {
    private val numBuckets = 769
    private val buckets = Array(numBuckets) { LinkedList<Int>() }

    private fun hash(key: Int): Int {
        return key % numBuckets
    }

    fun add(key: Int) {
        val bucket = buckets[hash(key)]
        if (!bucket.contains(key)) {
            bucket.add(key)
        }
    }

    fun remove(key: Int) {
        val bucket = buckets[hash(key)]
        bucket.remove(key as Int)
    }

    fun contains(key: Int): Boolean {
        return buckets[hash(key)].contains(key)
    }
}
