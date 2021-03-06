package com.fqh.learn.other;

import java.util.Arrays;

/**
 * @author fqh
 * @email fanqinghui100@126.com
 * @date 2017/9/13 15:40
 */
public class Common {
    // 1.冒泡算法：冒泡算法就是依次比较数组中相邻的两个元素，如果左边比右边大则进行调换，以此类推，这样第一次排序就把
    //最大的元素放在最底下，时间复杂度为n*n。
    static class MaoPaoSort {

        public static void main(String[] args) {
            System.out.println("冒泡排序");
            int[] a = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9};
            sort(a);
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }

        }

        static void sort(int[] array) {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    }

    // 2.快速排序：快速排序就是选定一个基准值，把所有小于基准值的数排在左边，所有大于基准值的数排在右边，之后通过递归
    // 再次对左边以及右边进行排序，直到所有都排列正确，通常把数组第一个元素作为基准值。
    static class FastSort {

        public static void main(String[] args) {
            System.out.println("快速排序");
            int[] a = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9};
            int start = 0;
            int end = a.length - 1;
            sort(a, start, end);
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }

        }

        static void sort(int[] a, int low, int high) {
            int start = low;
            int end = high;
            int key = a[low];


            while (end > start) {
                //从后往前比较
                while (end > start && a[end] >= key) {  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                    end--;
                }
                if (a[end] <= key) {
                    int temp = a[end];
                    a[end] = a[start];
                    a[start] = temp;
                }
                //从前往后比较
                while (end > start && a[start] <= key) {//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                    start++;
                }
                if (a[start] >= key) {
                    int temp = a[start];
                    a[start] = a[end];
                    a[end] = temp;
                }
                //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
            }
            //递归
            if (start > low) sort(a, low, start - 1);//左边序列。第一个索引位置到关键值索引-1
            if (end < high) sort(a, end + 1, high);//右边序列。从关键值索引+1到最后一个
        }

    }

    //3.插入排序：插入排序就是将一个记录插入到已经排好序的有序表中
    static class InsertSortTest {
        static void insertSort(int[] array) {
            if (array == null || array.length < 2) {
                return;
            }

            for (int i = 1; i < array.length; i++) {
                int currentValue = array[i];  //首先将第二个元素和数组第一个进行比较
                int position = i;
                for (int j = i - 1; j >= 0; j--) {
                    if (array[j] > currentValue) {
                        array[j + 1] = array[j];
                        position -= 1;
                    } else {
                        break;
                    }
                }

                array[position] = currentValue;
            }
        }

        public static void main(String[] args) {
            System.out.println("插入排序");
            int[] array = {3, -1, 0, -8, 2, 1};
            System.out.println(Arrays.toString(array));
            insertSort(array);
            System.out.println(Arrays.toString(array));
        }
    }
}
