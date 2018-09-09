package exam.toutiao180909;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by chao on 2018/8/11.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        int len = input.length();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i), 1);
            } else {
                map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (map.get(input.charAt(i)) > count) {
                count = map.get(input.charAt(i));
            }
        }
        System.out.println(count);
    }


}
