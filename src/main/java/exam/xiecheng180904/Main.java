package exam.xiecheng180904;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cacheSize = Integer.parseInt(in.nextLine());

		List<Integer> queue = new LinkedList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		Cache<Integer, Integer> cache = new Cache<Integer, Integer>(cacheSize * 2);
		List<Integer> list = new ArrayList<Integer>();

		do {
			String string = in.nextLine();
			if (string.equals("")) {
				break;
			}
			String[] opt = string.split(" ");
			if (opt[0].equals("p")) {
				if (cache.containsKey(Integer.parseInt(opt[1]))) {
					cache.replace(Integer.parseInt(opt[1]), Integer.parseInt(opt[2]));
				} else {
					cache.put(Integer.parseInt(opt[1]), Integer.parseInt(opt[2]));
				}
			} else {
				Integer get = cache.get(Integer.parseInt(opt[1]));
				if (get == 102) {
					list.add(-1);
				} else if (get != null) {
					list.add(get);
				} else {
					list.add(-1);
				}
			}
		} while (true);

		for (Integer res : list) {
			System.out.println(res);
		}
	}
}

class Cache<K, V> extends LinkedHashMap<K, V> {
	private int cacheSize;

	public Cache(int cacheSize) {
		super(16, 0.75f, true);
		this.cacheSize = cacheSize;
	}

	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() >= cacheSize;
	}
}