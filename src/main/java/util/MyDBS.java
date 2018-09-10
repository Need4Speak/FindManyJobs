package util;

/**
 * Created by chao on 2018/9/10.
 */
public class MyDBS {
    public static void traverse(String[] vertex, int[][] edge, int current, int n, boolean[] flag) {
        if (!flag[current]) {
            flag[current] = true;
            System.out.println("visit: " + vertex[current]);
            for (int i = 0; i < n; i++) {
                if (edge[current][i] != 0) {
                    traverse(vertex, edge, i, n, flag);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] edge = {{0, 1, 0, 1, 0}, {1, 0, 1, 0, 1}, {0, 1, 0, 1, 1}, {1, 0, 1, 0, 0},
                {0, 1, 1, 0, 0}};
        String[] vertex = {"V0", "V1", "V2", "V3", "V4"};
        int len = vertex.length;
        boolean[] flag = new boolean[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(edge[i][j] + " ");
            }
            System.out.println();
        }
        traverse(vertex, edge, 0, len, flag);
    }
}
