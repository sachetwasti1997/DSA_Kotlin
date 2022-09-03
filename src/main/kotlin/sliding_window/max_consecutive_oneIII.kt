class Longest_Ones{
    fun longestOnes(nums: IntArray, k: Int): Int {
        val map = HashMap<Int, Int>()
        var zeroCnt = 0
        var start = 0
        var max_len = 0
        for (i in nums.indices) {
          if (nums[i] == 0) zeroCnt++
          while (zeroCnt > k) {
            if (nums[start] == 0) zeroCnt --
            start ++
          } 
          max_len = max_len.coerceAtLeast(i - start + 1)
        }  
        return max_len    
      }
}

fun main() {
    val s = Longest_Ones()
    print(s.longestOnes(intArrayOf(1,1,1,0,0,0,1,1,1,1,0), 2))
}