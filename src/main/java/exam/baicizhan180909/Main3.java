package exam.baicizhan180909;

import java.math.BigInteger;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num1 = in.nextLine();
        String num2 = in.nextLine();
        System.out.println(toTen(num1));
        System.out.println(toTen(num2));
        System.out.println(to26(20L));
    }

    static String to26(Long num) {
        BigInteger bigNum = BigInteger.valueOf(num);
        int j;
        String sb = "";
        do {
//            j = num%16;
            j = bigNum.divideAndRemainder(BigInteger.valueOf(16L))[1].intValue();
            switch (j) {
                case 10:
                    sb = "A" + sb;
                    break;
                case 11:
                    sb = "B" + sb;
                    break;
                case 12:
                    sb = "C" + sb;
                    break;
                case 13:
                    sb = "D" + sb;
                    break;
                case 14:
                    sb = "E" + sb;
                    break;
                case 15:
                    sb = "F" + sb;
                    break;
                default:
                    sb = j + sb;
                    break;
            }
            num = num / 16;
        } while (num != 0);
        return sb;
    }

    static long toTen(String num) {
        int len = num.length();
        long total = 0L;
        for (int i = 0; i < len; i++) {
            total += (num.charAt(i) - 'a') * Math.pow(10, len - i - 1);
        }
        return total;
    }
}
