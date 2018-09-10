package util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chao on 2018/9/10.
 */
public class MyBFS {

    public static void traverse(String[] vertex, int[][] edge, int current, int n, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(current);
        visited[current] = true;
        System.out.println(vertex[current]);
        while (!queue.isEmpty()) {
            int peek = queue.peek();
            boolean flag =false;
            for (int i = 0; i< n; i++) {
                if (edge[peek][i] != 0 && !visited[i]) {
                    System.out.println(vertex[i]);
                    visited[i] = true;
                    queue.offer(i);
                    flag = true;
                }
            }
            if (!flag) {
                queue.poll();
            }
        }
    }

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {

        int[][] edge = {{0, 1, 0, 1, 0}, {1, 0, 1, 0, 1}, {0, 1, 0, 1, 1}, {1, 0, 1, 0, 0},
                {0, 1, 1, 0, 0}};
        String[] vertex = {"V0", "V1", "V2", "V3", "V4"};
        int len = vertex.length;
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(edge[i][j] + " ");
            }
            System.out.println();
        }
        traverse(vertex, edge, 0, len, visited);
    }

}

