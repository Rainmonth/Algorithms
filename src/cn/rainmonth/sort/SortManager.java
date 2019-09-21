package cn.rainmonth.sort;

import cn.rainmonth.AlgorithmsHelper;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 排序算法管理类（这里默认生序排列）
 * - 冒泡排序（done)
 * - 快速排序
 * - 归并排序
 * - 插入排序
 * - 选择排序
 * - 希尔排序
 *
 * @author randy
 */
public class SortManager {
    /**
     * 排序思想：每轮将排序找到最大的值并放到对应位置
     * 从头依次比较相邻元素，如果发现前一个小于后面一个，则交换，直至最后（length-1)位置最大
     * 然后重新，从头依次比较相邻元素，如果发现前一个小于后面一个，则交换，直至最后（length-2)位置最大
     * 依次循环
     *
     * @param array 待排序的数组
     */
    public static void bubbleSort(int[] array) {

        System.out.println("冒泡前：" + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    AlgorithmsHelper.swap(array, j, j + 1);
                }
            }
            System.out.println("第" + (i + 1) + "轮冒泡后：" + Arrays.toString(array));
        }
    }

    /**
     * 优化版冒泡排序（避免了对有序部分的冒泡）
     *
     * @param array 待排序的数组
     */
    public static void bubbleSort1(int[] array) {
        System.out.println("冒泡前：" + Arrays.toString(array));
        // 可以避免对有序数组也进行遍历
        boolean isNotOrderArray = true; // 假设是无序的，
        for (int i = array.length; isNotOrderArray && i > 0; i--) {
            isNotOrderArray = false; // 假设当前要比较的部分是有序的
            for (int j = 1; j < i; j++) {
                if (array[j - 1] > array[j]) {
                    AlgorithmsHelper.swap(array, j - 1, j); // 发生过交换，说明不是有序的，假设不成立
                    isNotOrderArray = true;
                }
            }
            System.out.println("本轮冒泡后：" + Arrays.toString(array));
        }
    }

    /**
     * 排序思想：选择一个元素的值作为基准，将大于改值的元素放在右边，小于改值的元素放在左边
     * {5,4,6,8,3}
     *
     * @param array 待排序的数组
     */
    public static void quickSort(int[] array, int bgn, int end) {
        System.out.println("排序前：" + Arrays.toString(array));
        //数组arr空or仅有一个元素则退出（递归终止条件）
        if (bgn >= end - 1)
            return;

        int l = bgn;
        int r = end - 1;//4
        int standard = array[l];//5
        while (l < r) {
            while (l < r) {
                if (array[r] < standard) {
                    array[l++] = array[r];// {}
                    break;
                }
                --r;
            }
            //
            while (l < r) {
                if (array[l] >= standard) {
                    array[r--] = array[l];
                    break;
                }
                ++l;
            }
        }
        array[l] = standard;
        System.out.println("标准元素的位置：" + l);
        System.out.println(Arrays.toString(array));

        System.out.println("左边排序：");
        quickSort(array, bgn, l);
        System.out.println("右边排序：");
        quickSort(array, r + 1, end);
    }


    /*快排*/
    public static void quickSort1(int[] arr, int bgn, int end)  //arr must be the reference of real param
    {
        //数组arr空or仅有一个元素则退出（递归终止条件）
        if (bgn >= end - 1)
            return;

        int lindex = bgn;
        int rindex = end - 1;
        int std = arr[lindex];
        while (lindex < rindex) {
            while (lindex < rindex) {
                if (arr[rindex] < std) {
                    arr[lindex++] = arr[rindex];
                    break;
                }
                --rindex;
            }

            while (lindex < rindex) {
                if (arr[lindex] >= std) {
                    arr[rindex--] = arr[lindex];
                    break;
                }
                ++lindex;
            }
        }

        arr[lindex] = std;
        quickSort1(arr, bgn, lindex);
        quickSort1(arr, rindex + 1, end);
    }


    /**
     * 排序思想：
     *
     * @param array 待排序的数组
     */
    public void mergeSort(int[] array) {

    }

    /**
     * {5,2,1,8,7}
     * 排序思想：将数组分为两部分，并将其中一部分看做有序的，依次取另一部分的值与前一部分的值作比较
     *
     * @param array 待排序的数组
     */
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    AlgorithmsHelper.swap(array, i, j);
                    System.out.println("i=" + i + "->" + Arrays.toString(array));
                }
            }
        }
    }

    /**
     * 排序思想：每轮选出最小的值
     * 假定选择第一个是最小的，从第二个开始，取值和最小的比较，若比最小的小，则跟新索引，遍历完成后如果最小索引发生了改变，则交换值
     *
     * @param array 待排序的数组
     */
    public static void selectSort(int[] array) {
        int minIndex;
        for (int i = 0; i < array.length; i++) {
            // 默认第一个最小
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                // 从第二个开始，如果比最小的小，则跟新minIndex
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // minIndex 发生改变后，跟新对应位置的值
            if (minIndex != i) {
                AlgorithmsHelper.swap(array, i, minIndex);
            }
        }
    }

    /**
     * 排序思想：
     *
     * @param array 待排序的数组
     */
    public void shellSort(int[] array) {

    }
}
