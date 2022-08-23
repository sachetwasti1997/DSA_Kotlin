package graph

import java.util.Arrays

class MinCostCityConnect {
    fun minimumCost(n: Int, cns: Array<IntArray>): Int {
        val par = IntArray(n){i -> i}
        val rnk = IntArray(n)

        fun find(f: Int): Int {
            if (f != par[f])
                par[f] = find(par[f])
            return par[f]
        }

        fun Union(x: Int, y: Int): Boolean {
            val parx = find(x)
            val pary = find(y)
            if (parx == pary) return false
            if (rnk[parx] > rnk[pary]) par[pary] = parx
            else if (rnk[pary] > rnk[parx]) par[parx] = pary
            else {
                rnk[parx] += 1
                par[pary] = parx
            }
            return true
        }

        cns.sortBy{it[2]}
        var res = 0
        var conns = 0

        for (i in cns) {
            if (Union(i[0]-1, i[1]-1)) {
                res+=i[2]
                conns ++
            }
        }

        if (conns == n-1) return res
        return -1
    }
}

fun main() {
    val arr = arrayOf(intArrayOf(1,2,5), intArrayOf(1,3,6), intArrayOf(2,3,1))
    val M = MinCostCityConnect()
    M.minimumCost(3, arr)
}