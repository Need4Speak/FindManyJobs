package exam.xiecheng180904;

import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long input = in.nextLong();
        String result = Long.toBinaryString(input);
        int count = 0;
        for(int i = 0; i < result.length(); i++) {
        	if(result.charAt(i) == '1') {
        		count++;
        	}
        }
        System.out.println(count);
    }
}
