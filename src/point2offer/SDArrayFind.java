package point2offer;

public class SDArrayFind {

    public static void main(String[] args) {
        int[][]  arr = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr2 = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int[][]  arr3 = {{1,2},{4,5}};
        for (int indexRow = 0; indexRow < arr2.length;indexRow++) {
            for (int indexColumn = 0; indexColumn < arr2[0].length;indexColumn++) {
                System.out.print(arr2[indexRow][indexColumn]);
            }
            System.out.println();
        }

        System.out.println(Find(66, arr2));


    }

    public static  boolean Find(int target, int[][] array) {
    	if(array.length == 0 || array[0].length == 0)
    		return false;
        int rowLength = array.length;
        int columnLength = array[0].length;

        int x = 0;
        int y = columnLength - 1;
        
        int index;
        while(!(x == rowLength - 1 && y == 0)) {
            if (target == array[x][y]) {
                return true;
            } else if (target > array[x][y]) {
                for (index = x; index < rowLength; index++) {
                    if (target == array[index][y]) {
                        return true;
                    } else if (target < array[index][y]) {
                        x = index;
                        break;
                    }
                    
                    if(index == rowLength - 1 && target > array[index][y]) {
                    	//x = rowLength - 1;
                    	return false;
                    }
                }
                //return false;
            } else if (target < array[x][y]) {
                for (index = y; index >= 0; index--) {
                    if (target == array[x][index]) {
                        return true;
                    } else if (target > array[x][index]) {
                        y = index;
                        break;
                    }
                    
                    if(index == 0 && target < array[x][index]) {
                    	return false;
                    }
                }
                //return false;
            }
        }
     return false;
    }
}
