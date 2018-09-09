package util;
// 邻接表存储图，深度优先遍历
import java.util.*;

public class DeepFirstSearchList {
    private int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    DeepFirstSearchList(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // 添加 V 到 w的 路径
    void addEdge(int v, int w) {
        adj[v].add(w);  // Add w to v's list.
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v) {
        // visited 元素默认为 false，标志 i 节点没有被访问过
        boolean visited[] = new boolean[V];
        // 递归打印被访问的节点
        DFSUtil(v, visited);
    }

    public static void main(String args[]) {
        DeepFirstSearchList g = new DeepFirstSearchList(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2)");

        g.DFS(0);
    }
}
