package exam.baicizhan0911;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 寻找和为定值的多个数
 * 题目：对任意一个数组寻找m个数，使其和等于sum，要求将其中所有的可能组合列出来。
 */
public class Main2 {

    static void findSubSum(int[] array, int start, int n, int[] num, int index, int m, int tmpSum, int sum)
    {
    /*a为给定数组
      n为数组长度
      num为存储的数组
      index为当前寻找到的数的下标
      m为指定需要找几个数
      tmpSum为当前和
      sum为指定和
    */
        int j;

        if (index>m || tmpSum>sum)
        {
            return;
        }

        if (tmpSum==sum && index==m)
        {
            for (j=0; j<m; j++)
            {
                System.out.print(num[j]);
            }
            System.out.println();
            return;
        }

        if (n < 1)
        {
            return;
        }
        num[index] = array[start];
        tmpSum += array[start];
        findSubSum(array, start, n-1, num, index+1, m, tmpSum, sum);
        tmpSum -= array[start];
        findSubSum(array, start, n-1, num, index, m, tmpSum, sum);
    }
    int main()
    {
        int a[] = {1, 3, 4, 7, 11, 13, 2, 8};
        int b[] = {0};
        findSubSum(a, 0,8, b, 0, 4, 0, 15);
        return 0;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i< n;i++) {
            list.add(in.nextInt());
        }
        int a[] = {1, 3, 4, 7, 11, 13, 2, 8};
        int b[] = {0};
        findSubSum(a, 0,8, b, 0, 4, 0, 15);
    }
}
