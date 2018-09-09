package util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chao on 2018/9/9.
 */
public class BreadthFirstSearchMatrix {
    private boolean[] flag;

    public BreadthFirstSearchMatrix() {
    }

    /**
     * 广度优先搜索
     *
     * @param vertex 顶点
     * @param edge   边
     * @param number 顶点数
     */
    void BFS_Map(String[] vertex, int[][] edge, int number) {
        flag = new boolean[number];
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < number; i++) {
            if (flag[i] == false) {
                flag[i] = true;
                System.out.print(vertex[i] + " ");
                queue.add(i);
                while (!queue.isEmpty()) {
                    int k = queue.poll();
                    for (int j = 0; j < number; j++) {
                        if (edge[k][j] == 1 && flag[j] == false) {
                            flag[j] = true;
                            System.out.print(vertex[j] + " ");
                            queue.add(j);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearchMatrix bfs = new BreadthFirstSearchMatrix();

        int number = 9;
        String[] vertex = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        int[][] edge = {
                {0, 1, 0, 0, 0, 1, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 0, 1, 1, 1},
                {0, 0, 0, 1, 0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 1, 0, 1, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 0, 0}
        };
        bfs.BFS_Map(vertex, edge, number);
        System.out.println();

        int number2 = 4;
        String[] vertex2 = {"0", "1", "2", "3"};
        int[][] edge2 = {
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
        };

        bfs.BFS_Map(vertex2, edge2, number2);
    }
}
