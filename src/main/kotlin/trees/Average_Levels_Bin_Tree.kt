package trees

import java.util.*
import kotlin.collections.ArrayList

class Average_Levels_Bin_Tree {
  fun averageOfLevels(root: TreeNode?): DoubleArray {
    val q = LinkedList<TreeNode?>()
    root?.let{ q.add(it) }
    var sz = q.size
    val res = ArrayList<Double>()
    while (!q.isEmpty()) {
      var dbl = 0.0
      for (i in 0 until sz) {
        val tmp = q.poll()
        tmp?.let{
          dbl += it.`val`
          if (it.left != null) q.add(it.left)
          if (it.right != null) q.add(it.right)
        }
      }
      dbl /= sz
      sz = q.size
      res.add(dbl)
    }
    return res.toDoubleArray()
  }
}