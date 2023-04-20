package io.chone.algorithm.sort;

import java.util.Arrays;

import static io.chone.algorithm.sort.SortUtil.swap;
import static io.chone.algorithm.sort.SortUtil.testSort;

/**
 * 快速排序
 */
public class QuickSort implements ArraySort {
    @Override
    public void sort(int[] arr) {
        partSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
//        new QuickSort().sort(new int[]{6, 3, 4, 5, 1, 2, 0});
        testSort(new QuickSort());
    }

    protected void partSort(int[] arr, int low, int high) {
        if (high - low < 1) {
            return;
        }
        System.out.println(Arrays.toString(arr));
        int mid = partition(arr, low, high);
        partSort(arr, low, mid - 1);
        partSort(arr, mid + 1, high);
    }

    static int partition(int[] arr, int low, int high) {
        //默认选择区间第一个作为pivot
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i != j) {
            //连续移动j
            while (j > i && arr[j] > pivot) {
                j--;
            }
            //连续移动i
            while (i < j && arr[i] < pivot) {
                i++;
            }
            //交换i和j：小于pivot的给i（左边）
            swap(arr, j, i);
        }
        //新位置设置pivot
        arr[i] = pivot;
        return i;
    }
}
