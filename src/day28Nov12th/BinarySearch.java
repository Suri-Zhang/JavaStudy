package day28Nov12th;

/**
 * @author Rex Joush
 * @time 2022.11.12
 */
public class BinarySearch {

    // [1] [2] [3] [4] [5] [6] [7] [8] [9] [10]

    //

    // [1,2] [3,4] [5,6] [7,8] [9,10]

    public static void main(String[] args) {
        // 700000000
        // 1 int, 32 bit = 4B
        // 10 40B
        // 1000 000 000 000 4PB
        // 10 GB
        // 1 G
        // 12T
        // 32 GB, 128 GB
        // 256 GB,
        // 256 TB, 200000
        // 5TB, xx.txt
        int[] nums = new int[]{90, 65, 7, 305, 120, 110, 8};

        System.out.println(new BinarySearch().countX("abxc"));
    }


    int mystery(int[] array, int s, int e) {
        if (s == e) {
            return array[s];
        }
        int rest = mystery(array, s + 1, e);
        if (array[s] > rest) {
            return array[s];
        }
        return rest;
    }
    /*
        90 65 7 305 120 110 8
        [65 7 8] 90 [305 120 110]
        [7 8] 65 90 [120 110] 305
        7 8 65 90 110 120 305
     */
    /*
    bubble sort, select sort, quick sort, merge sort, hill sort, count sort, 桶排序,
    quick sort
        90 65 7 305 120 110 8

        8 65 7 305 120 110 90
        8 65 7 [90] 120 110 305
        7 65 8 [90] 120 110 305
        7 8 65 [90] 120 110 305
        7 8 65 [90] 110 120 305
     */

    // countX(xsakjdkad); x == 'x' ? 1 : 0 + count(str.substring(1))

    /*
    merge sort
        merge, divide
        230 65 7 305 120 110 8

        [230 65 7 305] [120 110 8]

        [230 65] | [7 305] | [120 110] [8]

        [230] [65] | [7] [305] | [120] [110] | [8]
        65 230 | 7 305 | 110 120 | 8
        7 65 230 305 | 8 110 120
        7 8 65 110 120 230 305
     */
    int countX(String str) {
        if (str.length() == 0) {
            return 0;
        }
        return (str.charAt(0) == 'x' ? 1 : 0) + countX(str.substring(1));
    }

}
