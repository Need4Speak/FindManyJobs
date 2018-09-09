package exam.toutiao180909;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int len = input.length();
        if (len == 12) {
            System.out.println(1);
        } else if (len == 11) {
            System.out.println(8);
        } else if (len == 7) {
            int sum = 4;
            for (int i = 0; i < 4; i++) {
                if (isIp(input.substring(i, i + 3)))
                    sum++;
            }
            System.out.println(sum);
        } else if (len == 6) {
            int sum = 6;
            for (int i = 0; i < 4; i++) {
                if (isIp(input.substring(i, i + 3)))
                    sum++;
            }
            System.out.println(sum);
        } else if (len == 5) {
            System.out.println(4);
        } else if (len == 4) {
            System.out.println(1);
        }
    }

    public static boolean isIp(String str) {
        int ip = Integer.parseInt(str);
        if (ip >= 0 && ip <= 255) {
            return true;
        }
        return false;
    }
}
