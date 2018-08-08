package dp;

/**
 * Created by chao on 2018/8/8.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String strA = "13542687";
        String strB = "148675";

        int aLen = strA.length();
        int bLen = strB.length();
        int[][] grid = new int[aLen + 1][bLen + 1];
        for (int i = 0; i <= aLen; i++) {
            for (int j = 0; j <= bLen; j++) {
                grid[i][j] = 0;
            }
        }

        StringBuilder subSeq = new StringBuilder();
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (strA.charAt(i-1) == strB.charAt(j-1)) {
                    grid[i][j] = grid[i - 1][j - 1] + 1;
                    subSeq.append(strA.charAt(i-1));
                } else {
                    grid[i][j] = grid[i-1][j] > grid[i][j-1]?grid[i-1][j]:grid[i][j-1];
                }
            }
        }

        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("LongestCommonSubSequence: " + subSeq);
    }
}
