package io.chone.algorithm.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/3sum/
 * <p>
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum {
    public static void main(String[] args) {
//        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new ThreeSum().threeSum(new int[]{0, 0, 0}));
    }

    /**
     * 这是个组合问题基础上条件筛选，穷举所有组合复杂度是O(n^3),
     * 减少搜索范围:
     * 1)排序 ，排序之后负数再左边，正数在右边
     * 2) 两个指针left,right,分别代表负数和非负数的两个数组(),从左右两侧开始，lef停止条件是<0，right停止条件是>=0
     * 2.1. 两数相加为正，则需要从left后开始搜索，使用cur表示临时指针，停止条件是nums[cur]<=-delta。
     * 2.2. 两数相加为负，则需要从right后开始向左侧搜索，使用cur表示指针，停止条件是nums[cur]<=-delta
     * <p>
     * 排序复杂度 o(logn) +
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        //int i = 0, j = nums.length - 1;
        List<List<Integer>> res = new LinkedList<>();
        //相当于分成了正负两个数组，然后左元素选择
        //负数向右，越来越小
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            for (int j = nums.length - 1; i >= 0 && nums[j] >= 0; j--) {
                int delta = nums[i] + nums[j];
                if (delta < 0) {
                    int cur = j - 1;
                    while (nums[cur] > -delta) {
                        if (nums[cur] == -delta) {
                            //found
                            res.add(Arrays.asList(nums[i], nums[cur], nums[j]));
                            break;
                        }
                        cur++;
                    }
                }
                if (delta >= 0) {
                    int cur = i + 1;
                    //右移范围只需要到比-delta大
                    while (cur < nums.length && nums[cur] <= 0 && nums[cur] >= -delta) {
                        if (nums[cur] == -delta) {
                            //found
                            res.add(Arrays.asList(nums[i], nums[cur], nums[j]));
                            break;
                        }
                        cur++;
                    }
                }
            }
        }
        return res;
    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
//        int i = 0, j = 2;
//        List<List<Integer>> res = new LinkedList<>();
//        while (j < nums.length) {
//            if (nums[i] + nums[i + 1] + nums[j] == 0) {
//                res.add(Arrays.asList(nums[i], nums[i + 1], nums[j]));
//            }
//            i++;
//            j++;
//        }
//        return res;
//    }
}
