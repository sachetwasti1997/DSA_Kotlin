package graph

class Min_ver_rch_all_nods {
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val ind = IntArray(n){0}
        for (i in edges) {
            ind[i[1]]++
        }
        val res = ArrayList<Int>(n)
        for (i in ind.indices) {
            if (ind[i] == 0) res.add(i)
        }
        return res
    }
}