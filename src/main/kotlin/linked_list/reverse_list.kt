package linked_list

fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null;
    var curr = head
    var next = head?.next
    while (next != null) {
        curr?.next = prev
        prev = curr
        curr = next
        next = next.next
    }
    curr?.next = prev
    return curr
}

fun main() {
    val l1 = ListNode(1)
    val l2 = ListNode(2)
    val l3 = ListNode(3)
    val l4 = ListNode(4)
    val l5 = ListNode(5)
    val l6 = ListNode(6)

    l1.next = l2
    l3.next = l4
    l4.next = l5
    l5.next = l6

    var t = reverseList(l1)

    while (t != null) {
        println(t.`val`)
        t = t.next;
    }
}