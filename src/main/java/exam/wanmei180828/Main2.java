package exam.wanmei180828;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String firstLine = in.nextLine();
		int flowers = Integer.parseInt(firstLine.split(" ")[0]);
		int lookCounts = Integer.parseInt(firstLine.split(" ")[1]);
		// a[i]表示第i次，小明看的花的种类;
		String[] a = in.nextLine().split(" ");
		int problem = Integer.parseInt(in.nextLine());
		if (0 == flowers || 0 == lookCounts || 0 == problem) {
			System.out.println(0);
		} else {
			//String[] area = new String[problem];
			List<String> area = new ArrayList<String>();
			for (int i = 0; i < problem; i++) {
				area.add(in.nextLine());
			}
			Set<Integer> set = new HashSet<Integer>();
			for (int i = 0; i < problem; i++) {
				int start = Integer.parseInt(area.get(i).split(" ")[0]);
				int end = Integer.parseInt(area.get(i).split(" ")[1]);
				set.clear();
				for (int j = start - 1; j < end; j++) {
					set.add(Integer.parseInt(a[j]));
				}
				System.out.println(set.size());
			}
		}
	}
}
