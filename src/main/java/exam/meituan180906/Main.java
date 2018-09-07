package exam.meituan180906;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int t = in.nextInt();
		if (k <= 0 || t < 0) {
			System.out.println(0);
		} else {
			int array[] = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = in.nextInt();
			}

			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			Set<Integer> set = new HashSet<Integer>();

			int count = 0;

			for (int i = 0; i < n && i < k; i++) {
				if (!map.containsKey(array[i])) {
					map.put(array[i], 1);
					if (map.get(array[i]) == t) {
						set.add(array[i]);
					}
				} else {
					int result = map.get(array[i]);
					map.put(array[i], ++result);
					if (result == t) {
						set.add(array[i]);
					}
				}
			}

			count += set.size();

			for (int i = 1; i < n - k + 1; i++) {
				map.put(array[i - 1], map.get(array[i - 1]) - 1);
				if (map.get(array[i - 1]) < t) {
					set.remove(array[i - 1]);
				}
				if (map.containsKey(array[i + k - 1])) {
					map.put(array[i + k - 1], map.get(array[i + k - 1]) + 1);
					if (map.get(array[i + k - 1]) >= t) {
						set.add(array[i]);
					}
				} else {
					map.put(array[i + k - 1], 1);
					if (map.get(array[i + k - 1]) == t) {
						set.add(array[i]);
					}
				}

				count += set.size();
			}

			System.out.println(count);

		}
	}

}
