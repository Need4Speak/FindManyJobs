package exam.didi180918;


import java.util.*;


class StringEditDistance {
    public static int getDistance(String strA, String strB) {
        int distance = -1;
        if (null == strA || null == strB || strA.isEmpty() || strB.isEmpty()) {
            return distance;
        }
        if (strA.equals(strB)) {
            return 0;
        }
        System.out.println("第一个字符串：" + strA);
        System.out.println("第二个字符串：" + strB);
        int lengthA = strA.length();
        int lengthB = strB.length();
        int length = Math.max(lengthA, lengthB);
        int array[][] = new int[length + 1][length + 1];
        for (int i = 0; i <= length; i++) {
            array[i][0] = i;
        }
        for (int j = 0; j <= length; j++) {
            array[0][j] = j;
        }
        for (int i = 1; i <= lengthA; i++) {
            for (int j = 1; j <= lengthB; j++) {
                array[i][j] = min(array[i - 1][j] + 1, array[i][j - 1] + 1, array[i - 1][j - 1] + (strA.charAt(i - 1) == strB.charAt(j - 1) ? 0 : 1));
            }
        }
        System.out.println("状态转移表格：");
        for (int i = 0; i <= lengthA; i++) {
            for (int j = 0; j <= lengthB; j++) {
                System.out.print(array[i][j] + "    ");
            }
            System.out.println();
        }
        return array[lengthA][lengthB];
    }

    public static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}