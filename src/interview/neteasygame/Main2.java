package interview.neteasygame;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String correctSymbol = "!@#$%^&*()_-=+[]{},.<>/?";
		int total = 0;
		if (in.hasNextInt())
			total = in.nextInt();
		String[] passwordArray = new String[total];
		if (in.hasNextLine())
			in.nextLine();
		if(total == 0)
			System.out.println("no");
		if (total >= 1 && total <= 1000) {
			for (int i = 0; i < total; i++) {
				if (in.hasNextLine())
					passwordArray[i] = in.nextLine();
			}
			int strLen = 0;
			boolean isCorrect = true;
			for (int i = 0; i < total; i++) {
				isCorrect = true;
				boolean haveDigit = false;
				boolean haveLowerChar = false;
				boolean haveUpperChar = false;
				boolean haveSymbol = false;
				strLen = passwordArray[i].length();
				if (strLen < 8 || strLen > 16) {
					isCorrect = false;
				} else if (passwordArray[i].indexOf("password") != -1 || passwordArray[i].indexOf("admin") != -1
						|| passwordArray[i].indexOf("qwerty") != -1 || passwordArray[i].indexOf("iloveyou") != -1
						|| passwordArray[i].indexOf("112233") != -1 || passwordArray[i].indexOf("hello") != -1) {
					isCorrect = false;

				} else {

					for (int j = 0; j < strLen; j++) {
						if (passwordArray[i].charAt(j) >= '0' && passwordArray[i].charAt(j) <= '9') {
							haveDigit = true;
							if (j < strLen - 2 && passwordArray[i].charAt(j)
									- passwordArray[i].charAt(j + 1) == passwordArray[i].charAt(j + 1)
											- passwordArray[i].charAt(j + 2)) {
								isCorrect = false;
								break;
							}
						} else if ((passwordArray[i].charAt(j) >= 'a' && passwordArray[i].charAt(j) <= 'z')
								|| (passwordArray[i].charAt(j) >= 'A' && passwordArray[i].charAt(j) <= 'Z')) {
							if (passwordArray[i].charAt(j) >= 'a' && passwordArray[i].charAt(j) <= 'z')
								haveLowerChar = true;
							else
								haveUpperChar = true;
							if (j < strLen - 2 && passwordArray[i].charAt(j) - passwordArray[i].charAt(j + 1) == -1
									&& passwordArray[i].charAt(j + 1) - passwordArray[i].charAt(j + 2) == -1) {
								isCorrect = false;
								break;
							}
						} else if (correctSymbol.indexOf(passwordArray[i].charAt(j)) != -1) {
							haveSymbol = true;
						} else {
							isCorrect = false;
							break;
						}

					}

				}
				if (!(haveDigit && haveLowerChar && haveUpperChar && haveSymbol))
					isCorrect = false;
				if (isCorrect)
					System.out.println("yes");
				else
					System.out.println("no");
			}
		}
	}

}
