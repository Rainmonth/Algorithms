package cn.rainmonth;

import java.util.Arrays;

/**
 * 排序算法管理类（这里默认生序排列）
 * - 冒泡排序
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
     * 排序思想：
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
     * 排序思想：
     *
     * @param array 待排序的数组
     */
    public void quickSort(int[] array) {

    }

    /**
     * 排序思想：
     *
     * @param array 待排序的数组
     */
    public void mergeSort(int[] array) {

    }

    /**
     * 排序思想：
     *
     * @param array 待排序的数组
     */
    public void insertSort(int[] array) {

    }

    /**
     * 排序思想：
     *
     * @param array 待排序的数组
     */
    public void selectSort(int[] array) {

    }

    /**
     * 排序思想：
     *
     * @param array 待排序的数组
     */
    public void shellSort(int[] array) {

    }
}
