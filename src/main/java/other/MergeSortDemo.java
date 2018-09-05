package other;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MergeSortDemo {

    public static void sort(int[] array, int start, int end, int[] temp) {
        if (start < end) {
            int mid = (start + end) /2;
            sort(array, start, mid, temp);
            sort(array, mid + 1, end, temp);
            merge(array, start, mid, end, temp);
        }

    }

    public static void merge(int[] array, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int tempIndex = start;

        while (left <= mid && right <= end) {
            if (array[left] < array[right]) {
                temp[tempIndex++] = array[left++];
            } else {
                temp[tempIndex++] = array[right++];
            }
        }

        while (left <= mid)
            temp[tempIndex++] = array[left++];

        while (right <= end)
            temp[tempIndex++] = array[right++];

        for (int index = start; index <= end; index++) {
            array[index] = temp[index];
        }
    }

    public static void main(String[] args) {

        HashMap hashMap = new HashMap();
        int[] array = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[array.length];
        for (int a : array) {
            System.out.print(a + " ");
        }

        System.out.println();

        int end = array.length - 1;
        sort(array, 0, end, temp);

        for (int a : array) {
            System.out.print(a + " ");
        }
    }
}
