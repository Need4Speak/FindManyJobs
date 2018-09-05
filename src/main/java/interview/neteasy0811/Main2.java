package interview.neteasy0811;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //1
        int heapCount = in.nextInt();
        //2
        int appleCount[] = new int[heapCount];
        for (int i = 0; i < heapCount; i++) {
            appleCount[i] = in.nextInt();
        }
        int[] count = new int[heapCount];
        count[0] = appleCount[0];
        for (int i = 1; i < heapCount; i++) {
            count[i] = count[i-1] + appleCount[i];
        }

        //3
        int enquire = in.nextInt();
        //4
        int[] positions = new int[enquire];
        for (int i = 0; i < enquire; i++) {
            positions[i] = in.nextInt();
        }


        for (int i = 0; i < enquire; i++) {
            boolean haveFind = false;
            int middle = 0;            //初始中间位置
            int low = 0;
            int high = heapCount;
            if (positions[i] < 0 || positions[i] > count[heapCount-1])
                break;
            while (low <= high) {
                middle = (low + high) / 2;
                if (positions[i] <= count[middle]) {
                    if (middle != 0 && positions[i] > count[middle - 1]) {
                        System.out.println(middle + 1);
                        haveFind = true;
                    } else if (middle == 0) {
                        System.out.println(middle + 1);
                        haveFind = true;
                    } else if (positions[i] <= count[middle - 1]) {
                        high = middle - 1;
                    }
                    if (haveFind)
                        break;
                } else {
                    low = middle + 1;
                }
            }
        }

    }

}
