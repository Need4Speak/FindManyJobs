package interview.neteasy0811;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1
        String[] firstLine = scanner.nextLine().trim().split(" ");
        int classTime = Integer.parseInt(firstLine[0]);
        int wake = Integer.parseInt(firstLine[1]);
        //2
        int[] grades = new int[classTime];
        String[] secondLine = scanner.nextLine().trim().split(" ");
        for (int i = 0; i < classTime; i++) {
            grades[i] = Integer.parseInt(secondLine[i]);
        }
        //3
        int[] wakeTime = new int[classTime];
        String[] thirdLine = scanner.nextLine().trim().split(" ");
        for (int i = 0; i < classTime; i++) {
            wakeTime[i] = Integer.parseInt(thirdLine[i]);
        }

        int gridSum = 0;
        for (int i = 0; i < classTime; i++) {
            if (wakeTime[i] == 1) {
                gridSum += grades[i];
            }
        }

        int maxGrid = 0;
        int temp;
        for (int i = 0; i < classTime; i++) {
            if (wakeTime[i] == 0) {
                temp = gridSum;
                for (int j = i; j < i + wake && j < classTime; j++) {
                    if (wakeTime[j] == 0)
                        temp += grades[j];
                }
                if (maxGrid < temp)
                    maxGrid = temp;
            }
        }
        System.out.println(maxGrid);
    }
}