package graph

class course_schedule_iv {
    fun checkIfPrerequisite(n: Int, prq: Array<IntArray>, qr: Array<IntArray>): List<Boolean> {
        val gr = Array(n){ali()}.apply{
            prq.forEach{
                this[it[0]].add(it[1])
            }
        }

        var visit = HashSet<Int>(n)
        fun dfs(node: Int, des: Int): Boolean {
            visit.add(node)
            var vs = false
            for (i in gr[node]) {
                if (!visit.contains(i)) {
                    if (i == des) return true
                    visit.add(i)
                    vs = vs || dfs(i, des)
                }
            }
            return vs
        }

        val res = ArrayList<Boolean>()
        qr.forEach{
            visit = HashSet(n)
            res.add(dfs(it[0], it[1]))
        }
        return res
    }
}