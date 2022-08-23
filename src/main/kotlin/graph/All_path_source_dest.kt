package graph

typealias HsI = HashSet<Int>
typealias HmIA = HashMap<Int, ArrayList<Int>>

class All_path_source_dest {
    fun leadsToDestination(n: Int, eg: Array<IntArray>, s: Int, d: Int): Boolean {
        if (n == 1 && eg.size == 0) return true
        val v = HsI(n)
        val bv = HsI(n)
        val gr = HmIA(n)
        for (i in 0 until n)gr[i] = ArrayList()
        for (i in eg) gr[i[0]]?.add(i[1]);
        if (gr[s]?.isEmpty() == true) return false
        var res = true

        fun cycle(node: Int): Boolean {
            v.add(node)
            bv.add(node)
            for (i in gr[node].orEmpty()) {
                if (!v.contains(i) && gr[i]?.isEmpty() == true) res = res && (i == d)
                if (!v.contains(i) && cycle(i)) {
                    return true
                }
                if (bv.contains(i)) return true
            }
            bv.remove(node)
            return false
        }

        val c = cycle(s)
        return if(!c) res else false
    }
}

fun main() {
    /**
     *
    2
    [[0,1],[0,2],[1,3],[2,3]]
    0
    1
     */
    val edg = arrayOf(intArrayOf(0,1),intArrayOf(0,2),intArrayOf(1,3),intArrayOf(2,3))
    val nodes = hashMapOf<Int, ArrayList<Int>>().apply{
        for (i in 0 until 4)this[i] = ArrayList()
    }
    edg.forEach{
        nodes[it[0]]?.add(it[1])
    }
    print(nodes)
//  a.leadsToDestination(2, edg, 0, 1)
}