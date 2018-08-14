package interview.neteasygame180810;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main2 {
	private final static String correctSymbol = "!@#$%^&*()_-=+[]{},.<>/?";

	public static String[] readInput() {
		String[] input = null;
		try {
			// read file content from file
			StringBuffer sb = new StringBuffer("");

			FileReader reader = new FileReader("resource/passwordin.txt");
			BufferedReader br = new BufferedReader(reader);

			String str = null;
			int count = -1;
			int lines = 0;
			while ((str = br.readLine()) != null) {
				if (count == -1) {
					lines = Integer.parseInt(str);
					input = new String[lines];
					++count;
				} else if (count > lines) {
					break;
				} else {
					input[count++] = str;
				}
			}

			br.close();
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return input;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String[] input = readInput();
		int total = input.length;

		if (total >= 1 && total <= 1000) {
			FileWriter writer = new FileWriter("resource/passwordoutnew.txt");
            BufferedWriter bw = new BufferedWriter(writer);
            int count = 1;
			for (String str : input) {
				if(isCorrect(str)) {
					bw.write( "yes\n");
				} else {
					bw.write( "no\n");
				}
				if(count == 551)
					System.out.println(str);
				++count;
			}
 
            bw.close();
            writer.close();
		}
	}

	public static boolean isCorrect(String str) {
		int strLen = 0;
		boolean isCorrect = true;
		boolean haveDigit = false;
		boolean haveLowerChar = false;
		boolean haveUpperChar = false;
		boolean haveSymbol = false;
		strLen = str.length();
		if (strLen < 8 || strLen > 16) {
			isCorrect = false;
		} else if (str.indexOf("password") != -1 || str.indexOf("admin") != -1 || str.indexOf("qwerty") != -1
				|| str.indexOf("iloveyou") != -1 || str.indexOf("112233") != -1 || str.indexOf("hello") != -1) {
			isCorrect = false;

		} else {

			for (int j = 0; j < strLen; j++) {
				if (str.charAt(j) >= '0' && str.charAt(j) <= '9') {
					haveDigit = true;
					if (j < strLen - 2 && str.charAt(j) - str.charAt(j + 1) == str.charAt(j + 1) - str.charAt(j + 2)) {
						isCorrect = false;
						break;
					}
				} else if ((str.charAt(j) >= 'a' && str.charAt(j) <= 'z')
						|| (str.charAt(j) >= 'A' && str.charAt(j) <= 'Z')) {
					if (str.charAt(j) >= 'a' && str.charAt(j) <= 'z')
						haveLowerChar = true;
					else
						haveUpperChar = true;
					if (j < strLen - 2 && str.charAt(j) - str.charAt(j + 1) == -1
							&& str.charAt(j + 1) - str.charAt(j + 2) == -1) {
						isCorrect = false;
						break;
					}
				} else if (correctSymbol.indexOf(str.charAt(j)) != -1) {
					haveSymbol = true;
				} else {
					isCorrect = false;
					break;
				}

			}

		}
		if (!(haveDigit && haveLowerChar && haveUpperChar && haveSymbol))
			isCorrect = false;
		return isCorrect;
	}

}
