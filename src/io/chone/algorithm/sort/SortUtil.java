package io.chone.algorithm.sort;

import java.io.*;
import java.util.Arrays;

public class SortUtil {
    /**
     * 检查数组顺序
     *
     * @param arr
     * @return
     */
    public static boolean checkOk(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return false;
            }
        }
        return true;
    }

    public static void testSort(ArraySort arraySort) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(SortUtil.class.getClassLoader().getResource("io/chone/algorithm/sort/numbers.txt").getFile()));) {
            String line;
            while ((line = br.readLine()) != null) {
                int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                arraySort.sort(arr);
                if (!checkOk(arr)) {
                    System.err.println("Test fail on:" + line + ", result:" + Arrays.toString(arr));
                } else {
                    System.out.println("Passed: " + line + ",result:" + Arrays.toString(arr));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        testSort(new ArraySort() {
            @Override
            public void sort(int[] sourceArr) {
                Arrays.sort(sourceArr);
            }
        });
    }
}
