package other;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] levelStr = null;
        String[] commissionStr = null;
        String[] workerStr = null;

        if (input.hasNext()) {
            levelStr = input.next().split(",");
            commissionStr = input.next().split(",");
            workerStr = input.next().split(",");
        }

        input.close();
        if (levelStr != null && commissionStr != null && workerStr != null) {

            int levelLength = levelStr.length;
            int commissionLength = commissionStr.length;
            int workerLength = workerStr.length;

            int[] level = new int[levelLength];
            int[] commission = new int[commissionLength];
            int[] worker = new int[workerLength];

            for (int index = 0; index < levelLength; index++) {
                level[index] = Integer.parseInt(levelStr[index]);
            }
            for (int index = 0; index < commissionLength; index++) {
                commission[index] = Integer.parseInt(commissionStr[index]);
            }
            for (int index = 0; index < workerLength; index++) {
                worker[index] = Integer.parseInt(workerStr[index]);
            }

            int sum = assignTask(level, commission, worker);
            System.out.println(sum);
        } else {
            System.out.println(0);
        }

    }

    /**
     * @param level      任务难度
     * @param commission 佣金
     * @param worker     小弟能力
     * @return 最大佣金
     */
    public static int assignTask(int[] level, int[] commission, int[] worker) {
        int[] levelCopy = Arrays.copyOf(level, level.length);
        int[] commissionCopy = Arrays.copyOf(commission, commission.length);
        int[] workerCopy = Arrays.copyOf(worker, worker.length);

        int commissionLength = commissionCopy.length;

        // commission 与 level 按从commission从低到高排序
        int flag;
        // 冒泡排序
        int tmp = 0;
        for (int indexI = 0; indexI < commissionLength - 1; indexI++) {
            flag = 1;
            for (int indexJ = commissionLength - 1; indexJ > indexI; indexJ--) {
                if (commissionCopy[indexJ] < commissionCopy[indexJ - 1]) {

                    tmp = commissionCopy[indexJ];
                    commissionCopy[indexJ] = commissionCopy[indexJ - 1];
                    commissionCopy[indexJ - 1] = tmp;

                    tmp = levelCopy[indexJ];
                    levelCopy[indexJ] = levelCopy[indexJ - 1];
                    levelCopy[indexJ - 1] = tmp;

                    flag = 0;
                }
            }
            if (1 == flag)
                break;
        }

        // 对worker的能力从低到高排序，并统计佣金
        Arrays.sort(workerCopy);
        int sum = 0;
        int indexJ = workerCopy.length - 1;
        for (int indexI = commissionLength - 1; indexI >= 0; indexI--) {
            while (indexJ >= 0 && workerCopy[indexJ] >= levelCopy[indexI]) {
                sum += commissionCopy[indexI];
                indexJ--;
            }
        }
        // 如果sum 小于 0
        if (sum < 0)
            return 0;
        return sum;
    }

}
