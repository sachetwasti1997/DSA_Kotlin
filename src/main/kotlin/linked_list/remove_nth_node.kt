package linked_list

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
  var hd = head
  var cnt = 0
  while (hd != null) {
    cnt++
    hd = hd.next
  }
  if (cnt == n) return head?.next
  var k = cnt - n - 1
  hd = head
  while (k > 0){
    hd = hd?.next
    k--
  }
  hd?.next = hd?.next?.next
  return head
}