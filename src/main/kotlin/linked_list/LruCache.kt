package linked_list
class LRUCache(capacity: Int) {
  class Node(var key: Int, var value: Int, var next: Node?=null, var prev: Node?= null)
  val mp: HashMap<Int, Node>
  val cp: Int
  var sz = 0
  var hd: Node? = null
  var tl: Node? = null
  init {
    mp = HashMap(capacity)
    cp = capacity
  }

  fun get(key: Int): Int {
    var tmp = -1
    mp[key]?.let{
      tmp = it.value
      if (it != hd) mvTp(it)
    }
    return tmp
  }

  fun mvTp(nd: Node?) {
    val prv = nd?.prev
    val nxt = nd?.next
    prv?.next = nxt
    nxt?.prev = prv
    if (nd == tl) tl = tl?.prev
    nd?.prev = null
    nd?.next = null
    insTp(nd)
  }

  fun insTp(nd: Node?) {
    nd?.next = hd
    hd?.prev = nd
    hd=nd
    if (tl == null) tl = hd
  }

  fun put(key: Int, value: Int) {
    val tmp = Node(key, value)
    if (mp[key] != null) {
      mp[key]?.value = value
      if (mp[key] != hd) mvTp(mp[key])
    }else {
      mp[key] = tmp
      insTp(tmp)
      sz++
    }
    if (sz > cp) {
      tl?.let{mp.remove(it.key)}
      tl = tl?.prev
      tl?.next = null
      sz--
      if (tl == null) tl = hd
    }
  }

}

fun main() {
  val l = LRUCache(2)

}