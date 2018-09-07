package exam.neteasygame180810;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int total = 0;
		if (in.hasNextInt())
			total = in.nextInt();
		if (total > 0 && total <= 100) {
			int[] salaryArray = new int[total];
			for (int i = 0; i < total; i++) {
				if (in.hasNextInt())
					salaryArray[i] = in.nextInt();
			}
			for (int i = 0; i < total; i++) {
				System.out.println(cal(salaryArray[i]));
			}
		}

	}

	public static int cal(int salary) {
		int tax = 0;
		if (salary > 5000 && salary <= 1000000) {
			if (salary < 8000) {
				tax = (int) Math.round((salary - 5000) * 0.03);
			} else if (salary < 17000) {
				tax = (int) Math.round(90 + (salary - 8000) * 0.1);
			} else if (salary < 30000) {
				tax = (int) Math.round(990 + (salary - 17000) * 0.2);
			} else if (salary < 40000) {
				tax = (int) Math.round(3590 + (salary - 30000) * 0.25);
			} else if (salary < 60000) {
				tax = (int) Math.round(6090 + (salary - 40000) * 0.3);
			} else if (salary < 85000) {
				tax = (int) Math.round(12090 + (salary - 60000) * 0.3);
			} else if (salary >= 85000) {
				tax = (int) Math.round(20840 + (salary - 85000) * 0.45);
			}
		}
		return tax;

	}

}
