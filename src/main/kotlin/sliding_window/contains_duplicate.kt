package sliding_window

class contains_duplicate {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val cntnr = HashMap<Int, Int>(nums.size)
        for (i in nums.indices) {
            if (nums[i] in cntnr) print("${nums[i]} is there")
            cntnr[nums[i]]?.let {
                if (i - it > k) cntnr.remove(it)
                else return true
            }
            cntnr[nums[i]] = i
        }
        return false
    }
}

fun main() {
    val c = contains_duplicate()
    c.containsNearbyDuplicate(intArrayOf(1,2,3,1,2,3), 2)
}