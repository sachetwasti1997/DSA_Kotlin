package recursion

class letter_combination_num {
    fun letterCombinations(digits: String): List<String> {
        val mp = mapOf('2' to listOf('a', 'b', 'c'), '3' to listOf('d','e','f'), '4' to listOf('g','h','i'),
            '5' to listOf('j','k','l'), '6' to listOf('m','n','o'), '7' to listOf('p','q','r','s'),
            '8' to listOf('t','u','v'), '9' to listOf('w','x','y','z'))
        var s = StringBuilder()
        val n = digits.length
        val res = ArrayList<String>()
        fun dfs(indx: Int) {
            if (s.length == n) {
                res.add(s.toString())
                return
            }
            for (i in mp[digits[indx]].orEmpty()) {
                s.append(i)
                dfs(indx+1)
                s.deleteAt(s.length-1)
            }
        }
        dfs(0)
        return res
    }
}

fun main() {
    val l = letter_combination_num()
    print(l.letterCombinations("2"))
}