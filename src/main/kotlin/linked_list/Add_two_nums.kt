package linked_list

class Add_two_nums {
  fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var carry = 0
    val newhd = ListNode(0)
    var hd = newhd
    var lst1 = l1
    var lst2 = l2
    while (lst1 != null || lst2 != null) {
      val x = lst1?.`val` ?: 0
      val y = lst2?.`val` ?: 0
      val total = x+y+carry
      carry = total/10
      hd.next = ListNode(total%10)
      hd.next?.let{ hd = it }
      lst1 = lst1?.next
      lst2 = lst2?.next
    }
    if (carry != 0) hd.next = ListNode(carry)
    return newhd.next
  }
}

fun main() {
  var l1 = ListNode(2); val l2 = ListNode(4); val l3 = ListNode(3)
  val l4 = ListNode(5); val l5 = ListNode(6); val l6 = ListNode(4)
  l1.next = l2; l2.next = l3
  l4.next = l5; l5.next = l6
  val s = Add_two_nums()
  var lr = s.addTwoNumbers(l1, l4)
}