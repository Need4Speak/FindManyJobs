package exam.toutiao180920;

import java.util.Scanner;

/**
 * Created by chao on 2018/9/20.
 */
public class Main4 {

    static int count(int n, int m, int k, int last) {
        if (n < 0 || m < 0 || k < 0)
            return 0;

        if (n == 1 && m == 0 && k == 0 && last == 0)
            return 1;
        else if (n == 0 && m == 1 && k == 0 && last == 1)
            return 1;
        else if (n == 0 && m == 0 && k == 1 && last == 2)
            return 1;

        if (last == 0)
            return count(n - 1, m, k, 1) + count(n - 1, m, k, 2);
        else if (last == 1)
            return count(n, m - 1, k, 0) + count(n, m - 1, k, 2);
        else if (last == 2)
            return count(n, m, k - 1, 0) + count(n, m, k - 1, 1);
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(count(n, m, k, 0) + count(n, m, k, 1) + count(n, m, k, 2));
    }
}
