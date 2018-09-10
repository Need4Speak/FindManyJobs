package point2offer;

import java.util.Stack;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class PathInGraph {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char[][] ma = new char[rows][cols];
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                ma[row][col] = matrix[count++];
                System.out.print(ma[row][col] + " ");


            }
            System.out.println();
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (ma[row][col] == str[0]) {
                    Stack<Character> stack = new Stack<>();
                    boolean[][] visited = new boolean[rows][cols];
                    stack.push(ma[row][col]);
                    visited[row][col] = true;

                    while (!stack.empty()) {
                        if (row - 1 > 0 && !visited[row - 1][col] && true)
                            System.out.println();
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = {'b', 'c', 'c', 'e', 'd'};
        int rows = 3;
        int cols = 4;
        PathInGraph obj = new PathInGraph();
        obj.hasPath(matrix, rows, cols, str);
    }
}
