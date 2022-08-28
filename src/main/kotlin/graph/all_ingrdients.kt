import kotlin.math.pow

typealias str = String
typealias als = ArrayList<str>

    fun findAllRecipes(rcp: Array<String>, igdn: List<List<String>>, spls: Array<String>): List<String> {
        val ingdn = HashSet<str>().apply { spls.forEach {lst -> this.add(lst) } }
        val gr = HashMap<str, als>(rcp.size).apply {
            var i = 0
            rcp.forEach {
                this[it] = als(igdn[i++])
            }
        }

        print(gr)

        fun find (pro:str): Boolean {
            for (i in gr[pro].orEmpty()) {
                if(ingdn.contains(i)) continue
                if(!ingdn.contains(i)||!find(i)) return false
            }
            ingdn.add(pro)
            return true
        }
        val MOD = 10.00.pow(9).toInt()
        val res = als()
        for (i in rcp) {
            if (find(i)) res.add(i)
        }
        return res

    }

fun main() {

}
