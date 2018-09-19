package exam.xunlei180912;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = (int) Math.sqrt(n);
        int result = 0;
        for (int i = 1; i <= s; ++i)
            for (int j = i + 1; j <= s; ++j) {
                int x = 2 * i * j;
                int y = j * j - i * i;
                int z = j * j + i * i;
                if (x > n || y > n || z > n)
                    continue;
                if (fun(i, j) == 1 && (j - i) % 2 == 1)
                    ++result;
            }

        System.out.println(result);

    }

    static int fun(int a, int b) {
        if ( b == 0)
            return a;
        else
            return fun(b, a % b);
    }
}
