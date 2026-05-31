/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if(lists.size == 0 ) return null 

        if(lists.size == 1) return lists[0]

        var head: ListNode? = null 

        for(i in lists.indices) {
            head = mergeTwoLists(head,lists[i])
        }

        return head
    }

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {

        var curr1 = l1 
        var curr2 = l2 
        var head: ListNode? = null 
        var curr = head

        while(curr1 != null || curr2 != null) {

            if(curr1== null) {

                val nextNode = curr2 

                if(head == null) {
                    head = nextNode
                    curr = head

                } else {
                    curr?.next = nextNode
                    curr = curr?.next
                }

                curr2 = curr2?.next
                continue
            }

            if(curr2 == null) {
                val nextNode = curr1
               if(head == null) {
                    head = nextNode
                    curr = head

                } else {
                    curr?.next = nextNode
                    curr = curr?.next
                }
                curr1 = curr1?.next
                continue
            }

            val newNode = if(curr1?.`val`!! < curr2?.`val`!!) {
                val node = curr1
                curr1 = curr1?.next
                node
            } else {
                val node = curr2
                curr2 = curr2?.next
                node
            }

            if(head == null) {
                head = newNode
                curr = newNode
            } else {
                curr?.next = newNode 
                curr = newNode
            }

        }

        return head
    }
}