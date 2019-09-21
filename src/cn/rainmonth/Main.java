package cn.rainmonth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
//        int[] unsortedArray = {1005, 999, 1, 5, 4, 6, 9, 12, 100, 99};
//        System.out.println("排序前：" + Arrays.toString(unsortedArray));
//        AlgorithmsHelper.swap(unsortedArray, 1, 2);
//        System.out.println("交换后：" + Arrays.toString(unsortedArray));
//        //
//        Arrays.sort(unsortedArray);
//        System.out.println("排序后：" + Arrays.toString(unsortedArray));
//
//        System.out.println("index is:" + Arrays.binarySearch(unsortedArray, 12));
//
//        int[] arr1 = {1005, 999, 1, 5, 4, 6, 9, 12, 100, 99};
//        SortManager.bubbleSort1(arr1);

//        int[] result = AlgorithmsHelper.getFixSizeRandomArray(10, 1, 100);
//        System.out.println(Arrays.toString(result));
//        int[] result1 = AlgorithmsHelper.randomArray(1, 10, 10);

//        System.out.println(Arrays.toString(result1));

        Set<Integer> set = new HashSet<>();
        AlgorithmsHelper.randomSet(10, 1, 10, set);
        for (int j : set) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.println("set size:" + set.size());
        System.out.println(set.toString());
    }
}
