package exam.baicizhan0911;

import java.util.Scanner;

public class Main1 {

    static boolean isPrime(int num) {
        boolean flag = true;
        if (num < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if (isPrime(num)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
