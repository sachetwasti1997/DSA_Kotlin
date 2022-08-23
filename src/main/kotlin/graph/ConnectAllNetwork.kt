package graph

typealias ia = IntArray
class ConnectAllNetwork {
    fun makeConnected(n: Int, cns: Array<IntArray>): Int {
        val par = ia(n) {i -> i}
        val rnk = ia(n) {i -> 0}
        val st = HashSet<Int>()
        fun find(x: Int): Int {
            if (x != par[x]) {
                par[x] = find(par[x])
            }
            return par[x]
        }

        fun union(x: Int, y: Int): Boolean {
            val parx = find(x)
            val pary = find(y)
            if (parx == pary) return false
            else if (rnk[parx] > rnk[pary]) par[pary] = parx
            else if (rnk[pary] > rnk[parx]) par[parx] = pary
            else {
                rnk[parx] += 1
                par[pary] = parx
            }
            return true
        }

        var exCab = 0
        cns.forEach{
            if (!union(it[0], it[1])) exCab ++
        }

        for (i in 0 until n)
            st.add(find(i))
        if (exCab >= st.size-1) return st.size - 1
        return -1
    }
}