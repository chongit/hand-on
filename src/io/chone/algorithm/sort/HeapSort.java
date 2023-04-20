package io.chone.algorithm.sort;


import static io.chone.algorithm.sort.SortUtil.swap;

/**
 * 堆排序、大顶堆
 * 堆的节点和数组存储的映射关系，从0开始：
 * 1. 节点i的父节点的位置是(i-1)/2
 * 2. 节点i的左子节点位置是i*2+1
 * 3. 节点i的右子节点位置是i*2+2
 */
public class HeapSort implements ArraySort {

    public static void main(String[] args) {
        SortUtil.testSort(new HeapSort());
    }

    @Override
    public void sort(int[] arr) {
        //1.建堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            //i是从最后一个节点的父节点，向前迭代
            //调整堆
            heapify(arr, i, arr.length);
        }

        //2. 循环摘除堆顶到数组末尾，然后调整剩余的堆
        for (int i = arr.length - 1; i >= 0; i--) {
            //交换i和堆顶： 即依次把堆顶摘除（到数组后面）
            swap(arr, i, 0);
            //调整新堆
            heapify(arr, 0, i);
        }
    }

    /**
     * 调整堆，使之保持堆的特性： 父节点大于子节点。
     *
     * @param arr 堆的数组
     * @param i   待维护节点的数组坐标
     * @param len 数组长度
     */
    private void heapify(int[] arr, int i, int len) {
        int leftSon = i * 2 + 1;
        int rightSon = i * 2 + 2;
        int largest = i;
        if (leftSon < len && arr[leftSon] > arr[largest]) {
            //先判断左孩子是否比父节点大
            largest = leftSon;
        }
        if (rightSon < len && arr[rightSon] > arr[largest]) {
            //再判断右孩子是否比父节点大
            largest = rightSon;
        }
        if (largest != i) {
            //发生了交换： 交换位置
            swap(arr, i, largest);
            //继续调整新的largest
            heapify(arr, largest, len);
        }
    }

}