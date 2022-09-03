package sliding_window

import java.lang.StringBuilder
import java.util.*

class Decode_String {
  fun decodeString(s: String): String {
    val stk = Stack<String>()
    var i = 0
    val res = StringBuilder()
    while (i < s.length) {
      val str = StringBuilder()
      val nms = StringBuilder()
      while (s[i] in '0'..'9') {
        nms.append(s[i])
        i++
      }
      if (nms.isNotEmpty()) stk.add(nms.toString())
      if (s[i] == ']') {
        var tmp = "]"
        while (tmp != "[") {
          tmp = stk.pop()
          if (tmp != "[")str.append(tmp)
        }
        val k = stk.pop()
        val nt = k.toInt()
        var tmp_str = str.toString()
        str.setLength(0)
        repeat (nt) {
          str.append(tmp_str)
        }
        tmp_str = str.toString()
        for (t in tmp_str) {
          stk.add(t.toString())
        }
      }
      else {
        stk.add(s[i].toString())
      }
      i++
    }
    while (!stk.isEmpty()) res.append(stk.pop())
    return res.toString()
  }
}

fun main () {
  val D = Decode_String()
  D.decodeString("2[abc]3[cd]ef")

}