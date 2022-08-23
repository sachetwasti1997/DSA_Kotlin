package linked_list

class Reverse_k2 {
    fun reverse(hd: ListNode?, k:Int): Pair<ListNode?, ListNode?> {
        var pv: ListNode? = null
        var crr = hd
        var nxt = hd?.next
        var i = 0
        while (nxt != null && i < k-1) {
            crr?.next = pv
            pv = crr
            crr = nxt
            nxt = nxt.next
            i++
        }
        val tmp: ListNode? = crr?.next
        crr?.next = pv
        hd?.next = tmp
        return (crr to hd)
    }
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var hd = head
        var len = 0
        while (hd != null) {
            hd = hd.next
            len++
        }
        if (len == 1) return head
        hd = head
        var nhd: ListNode? = null
        var tl: ListNode? = null
        while (len >= k) {
            val (h, e) = reverse(hd, k)
            if (nhd == null) { nhd = h }
            tl?.next = h
            tl = e
            hd = e?.next
            len -= k
        }
        return nhd
    }
}

fun main() {
    val l1 = ListNode(1); val l2 = ListNode(2); val l3 = ListNode(3); val l4 = ListNode(4); val l5 = ListNode(5)
    l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5
    val r = Reverse_k2()
    val l = r.reverseKGroup(l1, 2)
}