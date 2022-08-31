package recursion

import java.lang.StringBuilder
import java.util.Stack

class decode{
  fun decodeString(s: String): String {
    val chrs = HashSet<String>().apply{
      for (i in 'a'..'z')this.add(i.toString())
    }
    val ints = HashSet<String>().apply{
      for (i in 1..300){
        this.add(i.toString())
      }
    }
    val stk = Stack<String>()
    var i = 0
    val sRes = StringBuilder()
    while (i < s.length) {
      if (s[i] == ']') {
        var tmp = ""
        val s1 = StringBuilder()
        while (tmp !in ints) {
          tmp = stk.pop()
          if (tmp in chrs) s1.append(tmp)
        }
        val t = s1.toString()
        s1.setLength(0)
        repeat (tmp.toInt()) {
          s1.append(t)
        }
        for (tm in s1.toString()) stk.add(tm.toString())
        if(!stk.contains("[")) {
          while (!stk.isEmpty()) sRes.append(stk.pop())
        }
        i++
      }
      else if (s[i].toString() in ints) {
        var nums = StringBuilder()
        while (s[i] != '[') {
          nums.append(s[i])
          i++
        }
        stk.add(nums.toString())
      } else {
        stk.add(s[i].toString())
        i++
      }
    }
    return sRes.toString()
  }
}

fun main () {
  val t = 21
  val c = '3'
    val s = "2[abc]3[cd]ef"
    val d = decode()
    println(d.decodeString(s))
}