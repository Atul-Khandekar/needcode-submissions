/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

        var m = 0 
        var count = head 
        while(count != null) {
            m++
            count = count?.next
        }

        m = m - n + 1
        var prev: ListNode? = null 
        var curr = head 
        while(m!=0) {
            val nextNode = curr?.next
            m-- 
            if(m == 0) {
                if(prev == null ) {
                    return head?.next
                } else {
                    prev?.next = nextNode
                }
                break
            }
            prev = curr
            curr = nextNode
        }

        return head
    }
}
