package cn.rainmonth;

import cn.rainmonth.sort.SortManager;

import java.util.Arrays;

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

        AlgorithmsHelper.isShowLog = false;
        int[] arr = AlgorithmsHelper.getFixSizeRandomArrayWithoutSameElement(500, 1, 10000);
//        int[] arr = new int[]{90, 77, 10, 72, 58, 30, 62, 71, 51, 12};
        if (arr != null) {
            SortManager.quickSort(arr, 0, arr.length);
            System.out.println("排序后：" + Arrays.toString(arr));
        }
        int[] arr1 = AlgorithmsHelper.getFixSizeRandomArrayWithoutSameElement(10, 1, 100);
    }
}
