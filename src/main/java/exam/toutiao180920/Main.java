package exam.toutiao180920;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        String[] str = new String[num];
        for (int i = 0; i < num;i++) {
            str[i] = scanner.nextLine();
        }
        str[0] = "abc";
        str[1] = "abd";
        str[2] = "abe";

        System.out.println(longestCommonPrefix(str));

    }


    static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = new String();
        for (int j = 0; j < strs[0].length(); ++j) {
            char c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; ++i) {
                if (j >= strs[i].length() || strs[i].charAt(j) != c) {
                    return res;
                }
            }
            res += Character.toString(c);
        }
        return res;
    }
}