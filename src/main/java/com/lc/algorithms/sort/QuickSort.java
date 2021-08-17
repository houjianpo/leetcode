package com.lc.algorithms.sort;

/**
 * @description: 快排
 * @author: 松针
 * @create: 2020-04-26 14:38
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{3, 13, 8, 30, 27, 6, 57, 93, 48, 66};
        sort1(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    /**
     * 快排
     * <p>
     * 通过一趟排序将要排序的数据分割成独立的两部分，
     * 其中一部分的所有数据都比另外一部分的所有数据都要小，
     * 然后再按此方法对这两部分数据分别进行快速排序，
     * 整个排序过程可以递归进行，以此达到整个数据变成有序序列。
     *
     * @param array 排序的数组
     * @param left  数组的前针
     * @param right 数组的后针
     */
    public static void sort1(int[] array, int left, int right) {
        // 终止条件
        if (left >= right) {
            return;
        }
        // 取参考值，默认取待排序数组的第一个元素
        int key = array[left];
        int i = left;
        int j = right;
        while (i < j) {
            if (array[j] >= key && i < j) {
                j--;
            }
            if (array[i] >= key && i<j) {
                i++;
            }
            if (i <j) {
                // 交换i和j对应的元素
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 快排
     * <p>
     * 通过一趟排序将要排序的数据分割成独立的两部分，
     * 其中一部分的所有数据都比另外一部分的所有数据都要小，
     * 然后再按此方法对这两部分数据分别进行快速排序，
     * 整个排序过程可以递归进行，以此达到整个数据变成有序序列。
     *
     * @param array 排序的数组
     * @param left  数组的前针
     * @param right 数组的后针
     */
    public static void sort(int[] array, int left, int right) {
        // 如果left=right，即数组中只剩一个元素时，直接返回
        if (left >= right) {
            return;
        }
        // 设置最左边的元素为基准值
        int key = array[left];
        // 数组中比key小的放在左边，比key大的放在右边
        int i = left;
        int j = right;
        while (i < j) {
            // j向左移动，直到碰到比key小的数
            while (array[j] >= key && i < j) {
                j--;
            }
            // i向右移动，直到碰到比key大的数
            while (array[i] <= key && i < j) {
                i++;
            }
            // i和j指向的元素交换
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[left] = array[i];
        array[i] = key;
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }
}
