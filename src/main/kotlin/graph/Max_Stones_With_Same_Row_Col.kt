package graph

class Max_Stones_With_Same_Row_Col {
    fun removeStones(stones: Array<IntArray>): Int {
        val visit = HashSet<IntArray>()
        fun dfs(arr: IntArray) {
            visit.add(arr)
            for (i in stones) {
                if (i[0] == arr[0] || i[1] == arr[1])
                    if (!visit.contains(i)) dfs(i)
            }
        }
        var res = 0
        for (i in stones) {
            if (!visit.contains(i)) {
                dfs(i)
                res++
            }
        }
        var s = "ab";
//    s.length
//    for (i in s.indices)
        return stones.size - res
    }
}
fun secondsToRemoveOccurrences(str: String): Int {
    var i = 1
    var res = 0
    val s = str.toCharArray()
    while (true) {
        var t = 0
        while (i < s.size) {
            if (s[i-1] == '0' && s[i] == '1') {
                s[i-1] = '1'
                s[i] = '0'
                res ++
                t++
                i++
            }else i+=2
        }
        if (t == 0) break
    }
    return res
}

fun main() {
    val s = "0110101"
    secondsToRemoveOccurrences(s)
}