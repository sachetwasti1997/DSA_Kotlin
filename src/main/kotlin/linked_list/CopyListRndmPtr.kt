package linked_list

class CopyListRndmPtr {
  fun copyRandomList(node: Node?): Node? {
    var h = node
    val mp = HashMap<Node, Node>()
    while (h != null) {
      mp[h] = Node(h.`val`)
      h = h.next
    }
    h = node
    while (h != null) {
      mp[h]?.next = mp[h.next]
      mp[h]?.random = mp[h.random]
      h = h.next
    }
    return mp[node]
  }

  fun copyRandomList2(node: Node?): Node? {
    if (node == null) return null
    var h = node
    while (h!=null) {
      val temp = Node(h.`val`)
      temp.next = h.next
      h.next = temp
      h = h.next?.next
    }
    h = node
    while (h!= null) {
      h.next?.random = h.random?.next
      h = h.next?.next
    }
    val nh = node.next
    h = node
    while (h != null) {
      val tmp = h.next
      h.next = h.next?.next
      h = tmp
    }
    return nh
  }
}