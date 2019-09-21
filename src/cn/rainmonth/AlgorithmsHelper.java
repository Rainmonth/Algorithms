package cn.rainmonth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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

    public static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
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

    /**
     * 数组元素是否越界
     */
    public static boolean checkIndex(int[] array, int index) {
        return index >= 0 && index < array.length;
    }

    /**
     * @param size 数组的大小
     * @param min  元素最小值
     * @param max  元素最大值
     * @return
     */
    public static int[] getFixSizeRandomArray(int size, int min, int max) {
        Random rd = new Random();
        if (min > max) {
            // 交换max和min
            min = min ^ max;
            max = min ^ max;
            min = min ^ max;
        }
        int bound = max - min + 1;
        if (size > bound) {
            size = bound;
        }
        int[] array = new int[size];
        int count = 0;
        while (count < size) {
            int num = rd.nextInt(bound) + min;
            boolean isNotExist = true;
            for (int j = 0; j < count; j++) {
                if (array[j] == num) {
                    isNotExist = false;
                    break;
                }
            }
            if (isNotExist) {
                array[count] = num;
                count++;
            }
        }
        return array;
    }

    public static void getFixSizeRandomSet(int size, int min, int max, Set<Integer> set) {
        if (set == null) {
            return;
        }
        int bound = max - min + 1;
        if (bound < size) {
            return;
        }
        for (int i = 0; i < size; i++) {
            int num = (int) (Math.random() * (max - min)) + min;
            set.add(num);
        }
        int setSize = set.size();
        if (setSize < size) {
            getFixSizeRandomSet(size - setSize, min, max, set);
        }

    }

    /**
     * 存在问题
     * @param n
     * @param min
     * @param max
     * @param set
     */
    public static void randomSet(int n, int min, int max, Set<Integer> set) {
        if (n > (max - min + 1) || max < min) {
            return;
        }
        System.out.println("expect size:" + n);
        for (int i = 0; i < n; i++) {
            // 调用Math.random()方法
            int num = (int) (Math.random() * (max - min)) + min;
            set.add(num);// 将不同的数存入HashSet中
        }
        System.out.println(set.toString());
        int setSize = set.size();
        // 如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，直到达到指定大小
        if (setSize < n) {
            randomSet(n - setSize, min, max, set);// 递归
        }
    }

    /**
     * 获取指定size的值在min和max之间的数组
     *
     * @param size               数组的大小
     * @param min                元素最小值
     * @param max                元素最大值
     * @param canHaveSameElement 能否有重复元素
     * @return 要返回的数组
     */
    public static int[] getFixSizeRandomArray(int size, int min, int max, boolean canHaveSameElement) {
        int bound = max - min + 1;
        if (canHaveSameElement) {
            return getFixSizeRandomArrayMayHaveSameElement(min, max, size);
        } else {
            // 检查是否元素值的边界是否满足
            if (bound < size) {// 比如size = 10，但要求min>=1, max<=9
                // 不可能得到这样的数组，调整size的大小
                size = bound;
                return getFixSizeRandomArray(size, min, max, false);
            } else {
                return getFixSizeRandomArrayWithoutSameElement(min, max, size);
            }
        }
    }

    public static int[] getFixSizeRandomArrayMayHaveSameElement(int size, int min, int max) {
        Random random = new Random();
        int bound = max - min + 1;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bound) + min;
        }
        return array;
    }

    /**
     * 随机指定范围内N个不重复的数 （进阶方法）
     * 在初始化的无重复待选数组中随机产生一个数放入结果中，
     * 将待选数组被随机到的数，用待选数组(len-1)下标对应的数替换
     * 然后从len-2里随机产生下一个随机数，如此类推
     *
     * @param size 随机数个数
     * @param max  指定范围最大值
     * @param min  指定范围最小值
     * @return int[] 随机数结果集
     */
    public static int[] getFixSizeRandomArrayWithoutSameElement(int size, int min, int max) {
        int len = max - min + 1;

        if (max < min || size > len) {
            return null;
        }

        //初始化给定范围的待选数组
        int[] source = new int[len];
        for (int i = min; i < min + len; i++) {
            source[i - min] = i; // 此时source存储的是（0， 到 len -1)
        }
        // 这个时候每个值都不同
        System.out.println("待选数组:" + Arrays.toString(source));

        int[] result = new int[size];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            //待选数组0到(len-2)随机一个下标（关键点是保证出现过得数字不会再被渠道
            System.out.println("len:" + len);
            // index的范围（0， len -1)
            index = Math.abs(rd.nextInt() % len);
            // (保证index的值时越来越小的)
            len--;
            System.out.println("index:" + index);
            //将随机到的数放入结果集
            System.out.println("要放入结果数组位置" + (i + 1) + "的数:" + source[index]);
            result[i] = source[index];
            System.out.println("结果数组:" + Arrays.toString(result));
            // len-1 的值也是动态变化的
            //将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换（source中len-1位置的数肯定之前没出现过，用没出现过的数来替代已经出现过的
            source[index] = source[len];
            System.out.println("待选数组:" + Arrays.toString(source));
        }
        return result;
    }

    /**
     * 检查数组中是否有重复元素
     */
    public boolean hasRepeatElements(int[] array) {
        return false;
    }

    /**
     * 打印数组中重复元素的个数
     *
     * @param array
     */
    public void printArrayElementRepeatNum(int array) {

    }


}
