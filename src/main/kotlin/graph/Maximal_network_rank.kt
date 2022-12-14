package graph
typealias hsi = HashSet<Int>
class Maximal_network_rank {
    fun maximalNetworkRank(n: Int, rds: Array<IntArray>): Int {
        val gr = HashMap<Int, hsi>(n)
        for (i in 0 until n) gr[i] = hsi()
        rds.forEach{
            gr[it[0]]?.add(it[1])
            gr[it[1]]?.add(it[0])
        }
        var res = Int.MIN_VALUE
        for (i in 0 until n-1) {
            for (j in i+1 until n) {
                var t = 0
                gr[i]?.let{
                    t+=it.size
                }
                gr[j]?.let{
                    t+=it.size
                }
                if (gr[i]?.contains(j) == true) {
                    res = res.coerceAtLeast(t - 1)
                }else {
                    res = res.coerceAtLeast(t)
                }
            }
        }
        return res
    }
}