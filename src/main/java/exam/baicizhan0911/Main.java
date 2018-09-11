package exam.baicizhan0911;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * 求多个集合求并集
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Map<Integer, Integer> map = new TreeMap<>();
        String str;
        for (int i = 0; i < n; i++) {
            str = in.nextLine();
            String[] nums = str.split(" ");
            for (int j = 1; j < nums.length; j++) {
                int num = Integer.parseInt(nums[j]);
                if (map.containsKey(num)) {
                    map.replace(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
        }

        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            for (int i = 0; i < map.get(key);i++)
                System.out.print(key + " ");
        }


    }
}
