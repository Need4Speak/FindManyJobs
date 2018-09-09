package exam.toutiao180909;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(lengthOfLongestSubstring(input));
    }

    static int lengthOfLongestSubstring(String str) {
        int len = str.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        char c;
        for (int i = 0; i < len; i++) {
            c = str.charAt(i);
            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1;
            } else {
                map.put(c, i);
            }
            max = Math.max(max, i - start + 1);

        }
        return max;

    }
}
