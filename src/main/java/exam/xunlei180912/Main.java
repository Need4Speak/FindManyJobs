package exam.xunlei180912;

import java.util.Scanner;

/**
 * 有红黑两种颜色的方块积木，红色代表正数A，黑色代表负数B。选出17块积木排成一排，使得任意相邻7块积木之和都小于0。
 * 如何挑选才能使17块积木之和最大，最大值是多少？
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int index = 0;
        for (int i = 6; i >= 0; i--) {
            if ((i * a + (7 - i) * b) < 0) {
                index = i;
                break;
            }
        }
        int result = (b * (7 - index) + a * index) * 2;
        if (index >= 3)
            result += 3 * a;
        else
            result += index * a + (3 - index) * b;

        System.out.println(result);

    }

}
