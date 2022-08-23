package linked_list

class Reverse_k_groups {
    fun reverse(hd: ListNode?): ListNode? {
        var pv: ListNode? = null
        var crr = hd
        var nxt = hd?.next
        while (nxt != null) {
            crr?.next = pv
            pv = crr
            crr = nxt
            nxt = nxt.next
        }
        crr?.next = pv
        return crr
    }
    fun reverseKGroup2(head: ListNode?, k: Int): ListNode? {
        val mp = HashMap<Int, ListNode?>()
        var hd = head
        var i = 0
        var j = 0
        while (hd != null) {
            val rm = hd
            mp[i] = ListNode(-1)
            var tl = mp[i]
            while (j < k && hd!=null) {
                tl?.next = hd
                tl = tl?.next
                hd = hd.next
                j++
            }
            if (j < k) {
                hd = rm
                mp.remove(i)
                break
            }
            j = 0
            tl?.next = null
            i++
        }
        val nhd = ListNode(-1)
        var tl = nhd
        for (m in mp) {
            tl.next = reverse(m.value?.next)
            while (tl.next != null) tl.next?.let{tl = it}
        }
        tl.next = hd
        return nhd.next
    }
}

fun main() {
    val l1 = ListNode(1); val l2 = ListNode(2); val l3 = ListNode(3); val l4 = ListNode(4); val l5 = ListNode(5)
    l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5
    val r = Reverse_k_groups()
    val l = r.reverseKGroup2(l1, 2)
}