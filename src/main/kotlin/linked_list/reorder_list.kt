package linked_list

fun reverse(hd: ListNode?): ListNode? {
  var pv: ListNode? = null
  var curr = hd
  var nx = hd?.next
  while (nx != null) {
    curr?.next = pv
    pv = curr
    curr = nx
    nx = nx.next
  }
  curr?.next = pv
  return curr
}
fun reorderList(head: ListNode?) {
  if (head?.next == null || head.next?.next == null) return
  var pv: ListNode? = null
  var slow = head
  var fast = head
  while (fast != null) {
    pv = slow
    slow = slow?.next
    fast = fast.next?.next
  }
  pv?.next = null
  slow = reverse(slow)
  var h1 = head.next
  var tl = head
  var flag = -1
  while (slow != null && h1 != null) {
    if (flag == -1) {
      tl?.next = slow
      slow = slow.next
    }else{
      tl?.next = h1
      h1 = h1.next
    }
    flag *= -1
    tl = tl?.next
  }
  if (slow != null) tl?.next = slow
  if (h1 != null) tl?.next = h1
}

fun mdl(hd: ListNode?) {
  var slow = hd
  var fast = hd
  while (fast != null) {
    slow = slow?.next
    fast = fast.next?.next
  }
  println(slow?.`val`)
}

fun main() {
  var l1:ListNode? = ListNode(1)
  val l2 = ListNode(2)
  val l3 = ListNode(3)
  val l4 = ListNode(4)
  val l5 = ListNode(5)
  l1?.next = l2;
  //l2.next = l3; l3.next = l4; l4.next = l5
  reorderList(l1)
  while (l1 != null) {
    print(l1.`val`)
    l1 = l1.next
  }
}