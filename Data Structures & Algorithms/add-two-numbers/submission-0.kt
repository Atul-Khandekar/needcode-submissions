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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        
        var first = l1 
        var second = l2
        var ans: ListNode? = null
        var curr = ans
        var carry = 0
        while(first != null || second != null)  {

                val sum = (first?.`val`?:0) + (second?.`val`?:0) + carry 
                
                val num = sum%10
                carry = sum/10 
                if(ans == null) {
                    ans = ListNode(num)
                    curr = ans
                } else {
                    val newNode = ListNode(num)
                    curr?.next = newNode
                    curr = curr?.next
                }

            first = first?.next 
            second = second?.next
        }

        if(carry!=0) {
            curr?.next = ListNode(carry)
        }

        return ans
    }
}