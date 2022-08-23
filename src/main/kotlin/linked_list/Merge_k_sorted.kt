package linked_list

import java.util.*

class Merge_k_sorted {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        val pq = PriorityQueue<Pair<Int, ListNode>>(lists.size){a,b-> a.first-b.first}
        for (i in lists) i?.let{ pq.add((it.`val` to it)) }
        val head = ListNode(-1)
        var tl = head
        while (!pq.isEmpty()) {
            val tmp = pq.poll()
            tl.next = ListNode(tmp.first)
            tl.next?.let{ tl = it }
            tmp.second.next?.let{ pq.add((it.`val` to it)) }
        }
        return head.next
    }
}

fun main() {
    val m = Merge_k_sorted()
    val l1: ListNode? = ListNode(1); val l2 = ListNode(4); val l3 = ListNode(4)
    val l4: ListNode? = ListNode(1); val l5 = ListNode(3); val l6 = ListNode(5)
    val l7: ListNode? = ListNode(2); val l8 = ListNode(6)
    l1?.next = l2; l2.next = l3
    l4?.next = l5; l5.next = l6
    l7?.next = l8
    val l = arrayOf(l1, l4, l7)
    val lt = m.mergeKLists(l)
}