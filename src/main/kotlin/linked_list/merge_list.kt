package linked_list

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
//  var l1 = list1
//  var l2 = list2
//  val hd = ListNode(0)
//  var t2 = hd
//  while (true) {
//    if (l1 == null && l2 == null) break
//    if (l1 == null) {
//      t2.next = l2
//      break
//    }
//    if (l2 == null) {
//      t2.next = l1
//      break
//    }
//    if (l1.`val` >= l2.`val`) {
//      t2.next = l2
//      l2 = l2.next
//    }else {
//      t2.next = l1
//      l1 = l1.next
//    }
//    t2 = t2.next
//  }
//  return hd.next
  var r1 = l1
  var r2 = l2
  val ll = ListNode(0)
  var rr = ll
  while(true){
    if(r1==null && r2==null){
      break
    }
    if(r1==null){
      rr.next = r2
      break
    }
    if(r2==null){
      rr.next = r1
      break
    }
    if(r1.`val`<=r2.`val`){
      rr.next = r1
      r1 = r1.next
    }
    else{
      rr.next = r2
      r2 = r2.next
    }
    rr.next?.let{ rr = it }
  }
  return ll.next
}

fun main() {
  val l1 = ListNode(1); val l2 = ListNode(2); val l3 = ListNode(3)
  val l4 = ListNode(1); val l5 = ListNode(3); val l6 = ListNode(4)
  l1.next = l2; l2.next = l3
  l4.next = l5; l5.next = l6
  var res = mergeTwoLists(null, null)
  while (res != null) {
    print("${res.`val`} ")
    res = res.next
  };
}