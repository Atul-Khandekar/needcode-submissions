/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {

        val dummy: ListNode? = ListNode(0)
        dummy?.next = head 

        var groupPrev = dummy 

        while(true) {

            var kth = getKth(groupPrev, k)
            if(kth==null) break

            var groupNext = kth?.next 

            var prev = kth?.next 
            var curr = groupPrev?.next 

            while(curr != groupNext) {
                val nextNode = curr?.next 
                curr?.next = prev
                prev = curr
                curr = nextNode
            }

            var temp = groupPrev?.next 
            groupPrev?.next = kth
            groupPrev = temp
        }
        return dummy?.next
    }

    fun getKth(c: ListNode?, k:Int): ListNode? {
        var count = k 
        var curr = c
        while(curr!=null && count>0) {
            curr = curr?.next 
            count--
        }

        return curr
    }
}
