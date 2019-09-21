package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] unsortedArray = {1005, 999, 1, 5, 4, 6, 9, 12, 100, 99};
        System.out.println("排序前：" + Arrays.toString(unsortedArray));
        AlgorithmsHelper.swap(unsortedArray, 1, 2);
        System.out.println("交换后：" + Arrays.toString(unsortedArray));
        //
        Arrays.sort(unsortedArray);
        System.out.println("排序后：" + Arrays.toString(unsortedArray));

        System.out.println("index is:" + Arrays.binarySearch(unsortedArray, 12));

        int[] arr1 = {1005, 999, 1, 5, 4, 6, 9, 12, 100, 99};
        SortManager.bubbleSort(arr1);
    }
}
