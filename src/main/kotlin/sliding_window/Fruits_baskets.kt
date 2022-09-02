package sliding_window

class Fruits_baskets {
  fun totalFruit(fruits: IntArray): Int {
    var bask = HashMap<Int, Int>()
    var left = 0
    var right = 0
    var total = 0
    while (left < fruits.size && right < fruits.size) {
      if (fruits[right] !in bask && bask.size < 2) {
        bask[fruits[right]] = 1
        right ++
      }
      else if (fruits[right] in bask && bask.size <= 2) {
        bask[fruits[right]]?.let{
          bask[fruits[right]] = it + 1
        }
        right ++
      }else if (fruits[right] !in bask && bask.size == 2) {
        left++
        right = left
        bask = HashMap()
      }
      var curr = 0
      for ((k, v) in bask) {
        curr += v
      }
      total = total.coerceAtLeast(curr)
    }
    return total
  }
}

fun main() {
  val c = Fruits_baskets()
  println(c.totalFruit(intArrayOf(0,1,2,2)))
}