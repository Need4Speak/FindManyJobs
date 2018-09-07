package exam.wanmei180828;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int peoples = Integer.parseInt(in.nextLine());
		if (peoples < 2 || peoples > 1000) {
			System.out.println(0);
		}
		else {
			int[] x = new int[peoples];
			int[] y = new int[peoples];
			for (int i = 0; i < peoples; i++) {
				String input = in.nextLine();
				x[i] = Integer.parseInt(input.split(" ")[0]);
				y[i] = Integer.parseInt(input.split(" ")[1]);
			}
			int maxX = x[0];
			int maxY = y[0];
			int minX = x[0];
			int minY = y[0];
			for (int i = 1; i < peoples; i++) {
				if (x[i] > maxX) {
					maxX = x[i];
				} 
				if(x[i] < minX) {
					minX = x[i];
				}
				if (y[i] > maxY) {
					maxY = y[i];
				}
				if(y[i] < minY) {
					minY = y[i];
				}
			}
			int width = maxX - minX;
			int height = maxY - minY;
			if (width  > height) {
				System.out.println(width * width);
			} else {
				System.out.println(height * height);
			}
		}

	}
}
