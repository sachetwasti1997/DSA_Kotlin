package graph

class equality_equations {
  fun equationsPossible(eqn: Array<String>): Boolean {
    val gr = HashMap<Char, ArrayList<Char>>()
    val colr = HashMap<Char, Int>()
    eqn.forEach{
      if (gr[it[0]] == null) gr[it[0]] = ArrayList()
      if (gr[it[3]] == null) gr[it[3]] = ArrayList()
      colr[it[0]] = -1; colr[it[3]] = -1
      if (it[1] == '=')
      {
        gr[it[0]]?.add(it[3])
        gr[it[3]]?.add(it[0])
      }
    }
    val visit = HashSet<Char>()
    fun color(nd: Char, col: Int) {
      visit.add(nd)
      colr[nd] = col
      for (i in gr[nd].orEmpty()) {
        if (!visit.contains(i)) color(i, col)
      }
    }
    var k = 0
    for (i in gr) {
      if (colr[i.key] == -1) color(i.key, k++)
    }
    eqn.forEach{
      if (it[1] == '=') {
        if (colr[it[0]] != colr[it[3]]) return false
      }
      else{
        if (colr[it[0]] == colr[it[3]]) return false
      }
    }
    return true
  }
}