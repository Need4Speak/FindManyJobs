package point2offer;

/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray_6 {
    private static MinNumberInRotateArray_6 obj = new MinNumberInRotateArray_6();

    public int minNumberInRotateArray(int[] array) {
        int length = array.length;
        if (0 == length) {
            return 0;
        } else if (1 == length) {
            return array[0];
        } else {
            int low = 0;
            int high = length - 1;
            int mid;
            while (low < high) {
                mid = (low + high) / 2;
                while (mid < high && array[mid] == array[mid + 1]) {
                    ++mid;
                }
                if (array[mid] < array[mid + 1]) {
                    if (array[mid] > array[0]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                } else if (array[mid] > array[mid + 1]) {
                    return array[mid + 1];
                }
            }
            return array[0];
        }
    }

    public static void main(String[] args) {
        int array[] = {6501, 6828, 6963, 7036, 7422, 7674, 8146, 8468, 8704, 8717, 9170, 9359, 9719, 9895, 9896,
                9913, 9962,
                154, 293, 334, 492, 1323, 1479, 1539, 1727, 1870, 1943, 2383, 2392, 2996, 3282, 3812, 3903, 4465,
                4605, 4665, 4772, 4828, 5142, 5437, 5448, 5668, 5706, 5725, 6300, 6335};
        System.out.println(obj.minNumberInRotateArray(array));
        System.out.println(array.length);
        System.out.println(array[(array.length - 1) / 2]);
    }
}
