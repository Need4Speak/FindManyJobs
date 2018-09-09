package exam.baicizhan180909;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        try {
            int num = Integer.parseInt(input);
            System.out.println(reverse(num));
        } catch (NumberFormatException e) {
            System.out.println(0);
        }
    }

    public static int reverse(int num) {
        StringBuilder result = new StringBuilder();
        int res;
        if (num > 0) {
            try {
                res = Integer.parseInt(result.append(num).reverse().toString());
            } catch (NumberFormatException exp) {
                return 0;
            }
            return res;
        } else {
            num = -num;
            try {
                res = Integer.parseInt(result.append(num).reverse().toString());
            } catch (NumberFormatException exp) {
                return 0;
            }
            return -res;
        }
    }
}
