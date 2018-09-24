package exam.toutiao180920;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();

        String[] words = scanner.nextLine().split(" ");
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.next().charAt(0);
            }
        }
        for (int i = 0; i < k; i++) {
            if (exist(matrix, m, n, words[i]))
                System.out.println(words[i]);
        }
    }


    static boolean exist(char[][] matrix, int m, int n, String word) {
        if (matrix == null || matrix.length == 0)
            return false;
        boolean[] flag = new boolean[m * n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (search(matrix, word, i, j, flag, 0))
                    return true;
            }
        return false;
    }

    static boolean search(char[][] matrix, String word, int i, int j, boolean[] flag, int index) {
        if (index == word.length())
            return true;
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != word.charAt(index) || flag[i * matrix[0].length + j])
            return false;

        flag[i * matrix[0].length + j] = true;
        if (search(matrix, word, i + 1, j, flag, index + 1) || search(matrix, word, i - 1, j, flag, index + 1)
                || search(matrix, word, i, j - 1, flag, index + 1) || search(matrix, word, i, j + 1, flag, index + 1))
            return true;

        flag[i * matrix[0].length + j] = false;
        return false;

    }
}