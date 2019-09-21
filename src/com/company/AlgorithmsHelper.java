package com.company;

public class AlgorithmsHelper {
    public static int getMaxValue(int[] array) {
        if (!checkArray(array)) {
            return -1;
        }
        int max = 0;
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static void swap(int[] array, int a, int b) {
        if (!checkArray(array) || !checkIndex(array, a) || !checkIndex(array, b)) {
            return;
        }
        array[a] = array[a] ^ array[b]; // 操作之后a = a + b
        array[b] = array[a] ^ array[b]; // 操作之后b = a + b - a;
        array[a] = array[a] ^ array[b]; // 操作之后a = a + b - b;

        // 等价于
        // a = a + b; b = a - b; a = a - b;
    }

    public static boolean checkArray(int[] array) {
        if (array == null) {
            System.out.println("数组为空，请检查");
            return false;
        }
        if (array.length == 0) {
            System.out.println("数组长度为0，请检查");
            return false;
        }

        return true;
    }

    public static boolean checkIndex(int[] array, int index) {
        return index >= 0 && index < array.length;
    }
}
