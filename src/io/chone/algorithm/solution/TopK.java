package io.chone.algorithm.solution;

import java.util.Arrays;
import java.util.Random;

import static io.chone.algorithm.sort.SortUtil.swap;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 */
public class TopK {

    public static void main(String[] args) {
        System.out.println(getLargestK(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public static int getLargestK(int arr[], int k) {
        int target = arr.length -k;
        int left = 0;
        int right = arr.length - 1;
        while (true) {
            int mid = partition(arr, left, right);
            System.out.println(Arrays.toString(arr));
            if (mid < target) {
                left = mid + 1;
            } else if (mid > target) {
                right = mid - 1;
            } else {
                return arr[mid];
            }
        }

    }

    private final static java.util.Random random = new Random(System.currentTimeMillis());
    static int partition(int[] arr, int low, int high) {
        int randomIndex = low + random.nextInt(high - low + 1);
        //默认选择区间第一个作为pivot
        int pivot = arr[randomIndex];
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
