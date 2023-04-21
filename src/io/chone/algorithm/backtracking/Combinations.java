package io.chone.algorithm.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/combinations/
 */
public class Combinations {

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * <p>
     * 你可以按 任何顺序 返回答案。
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new LinkedList<>();
        backtracking(1, n, k, new LinkedList<>(), list);
        return list;
    }

    private void backtracking(int from, int n, int k, LinkedList<Integer> node, List<List<Integer>> res) {
        if (node.size() == k) {
            //收集结果
            //node会被反复使用，这里要用新的list
            res.add(new ArrayList<>(node));
            return;
        }
        for (int i = from; i <= n; i++) {
            node.add(i);
            System.out.println("递归之前 => " + node);
            backtracking(i + 1, n, k, node, res);
            node.removeLast();
            System.out.println("递归之后 => " + node);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4,2));
    }
}
