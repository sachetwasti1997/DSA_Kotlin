package linked_list

class Linked_list_Cycle {
  fun hasCycle(head: ListNode?): Boolean {
    if (head?.next == null) return false
    var slow = head
    var fast = head
    while (fast != null) {
      slow = slow?.next
      fast = fast.next?.next
      if (slow == fast) return true
    }
    return false
  }
}

fun main() {
  val l1 = ListNode(1); val l2 = ListNode(2)
  l1.next = l2
  val s = Linked_list_Cycle()
  s.hasCycle(l1)
}