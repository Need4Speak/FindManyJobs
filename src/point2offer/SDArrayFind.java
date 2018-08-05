package point2offer;

public class SDArrayFind {

    public static void main(String[] args) {
        int[][]  arr = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr2 = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        for (int indexRow = 0; indexRow < arr.length;indexRow++) {
            for (int indexColumn = 0; indexColumn < arr[0].length;indexColumn++) {
                System.out.print(arr[indexRow][indexColumn]);
            }
            System.out.println();
        }

        System.out.println(Find(7, arr2));


    }

    public static  boolean Find(int target, int[][] array) {
        int rowLength = array.length;
        int columnLength = array[0].length;

        int x = 0;
        int y = columnLength - 1;
        while(x < rowLength && y >= 0) {
            if (target == array[x][y]) {
                return true;
            } else if (target > array[x][y]) {
                for (int index = x; index < rowLength; index++) {
                    if (target == array[index][y]) {
                        return true;
                    } else if (target < array[index][y]) {
                        x = index;
                        break;
                    }
                }
                return false;
            } else if (target < array[x][y]) {
                for (int index = y; index >= 0; index--) {
                    if (target == array[x][index]) {
                        return true;
                    } else if (target > array[x][index]) {
                        y = index;
                        break;
                    }
                }
                return false;
            }
        }
     return false;
    }
}
