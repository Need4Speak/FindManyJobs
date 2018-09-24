package exam.toutiao180920;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by chao on 2018/9/20.
 */
public class Main5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        BigInteger start = new BigInteger(input[0]);
        BigInteger end = new BigInteger(input[1]);
        for (BigInteger i = start; i.compareTo(end) <= 0; i = i.add(new BigInteger("1"))) {
            if (getLuck(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    static boolean getLuck(BigInteger num) {
        String str = num.toString();
        int len = str.length();
        
        if (len <= 1)
            return false;
        int start = 0;
        int end = len - 1;
        char a;
        char b;
        Set<Character> set = new HashSet<>();
        while (start < end) {
            a = str.charAt(start);
            b = str.charAt(end);
            if (a == b) {
                return false;
            }
            start++;
            end--;
        }
//        if (start == end && len >= 3 ) {
//            if (str.charAt(start) == str.charAt(start - 1) || str.charAt(start) == str.charAt(start + 1))
//                return false;
//        }
        return true;
    }
}
