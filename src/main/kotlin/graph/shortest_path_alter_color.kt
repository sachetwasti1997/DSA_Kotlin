package graph

import java.util.LinkedList
import kotlin.collections.ArrayList

typealias AIA = Array<IntArray>
typealias IA = IntArray
typealias AL = ArrayList<Int>
typealias ALA = ArrayList<ArrayList<Int>>
typealias HMAI = HashMap<Int, ALA>

/**
 *
class Solution {
public:
vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& red_edges, vector<vector<int>>& blue_edges) {
// constructing adjacency matrix
vector<vector<pair<int,int>>> graph(n);
for(auto edge: red_edges)
graph[edge[0]].emplace_back(edge[1],0); //red edges are denoted by 0
for(auto edge: blue_edges)
graph[edge[0]].emplace_back(edge[1],1); // blue edges are denoted by 1
vector<int> dist(n,-1);

queue<vector<int>> q;
q.emplace(vector<int>{0,0,-1});

while(!q.empty()) {
auto front = q.front();
q.pop();
dist[front[0]] = dist[front[0]] != -1 ? dist[front[0]] : front[1];

for(auto &adj : graph[front[0]]) {
//Push the node to the queue only if the next edge color is different from the pervious edge color and also if we are visiting the edge
//for the first time.
if(front[2] != adj.second && adj.first!= -1) {
q.emplace(vector<int>{adj.first, front[1] + 1, adj.second});
//Update the value in the adjacency matrix to -1 to denote that the node has already been visited.
adj.first = -1;
}
}
}
return dist;
}

};
 */

fun shortestAlternatingPaths(n: Int, redEdges: AIA, blueEdges: AIA): IA {
    val gr = ArrayList<ArrayList<ArrayList<Int>>>()
    val vs = HashSet<String>();
    for (i in 0 until n) gr.add(ArrayList())
    for (i in redEdges) gr[i[0]].add(arrayListOf(i[1], -1))
    for (i in blueEdges) gr[i[0]].add(arrayListOf( i[1],1))
    val res = IntArray(n) {i -> -1}

    println(gr)

    val q = LinkedList<AL>()
    q.add(arrayListOf(0, 0, 0))
    while (!q.isEmpty()) {
        val tmp = q.poll()
        val col = tmp[2]
        res[tmp[0]] = if (res[tmp[0]] != -1) res[tmp[0]] else tmp[1]
        for (i in gr[tmp[0]]) {
            if (tmp[2] != i[1] && !vs.contains("${tmp[0]} ${i[0]}")) {
                q.add(arrayListOf(i[0], tmp[1]+1, i[1]))
                vs.add("${tmp[0]} ${i[0]}")
            }
        }
    }

    return res;
}

fun main(){
    /**
     * 5
    [[0,1],[1,2],[2,3],[3,4]]
    [[1,2],[2,3],[3,1]]
     */
    val r = arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4))
    val b = arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,1))
    shortestAlternatingPaths(5, r, b)
}