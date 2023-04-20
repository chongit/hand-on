package io.chone.algorithm.tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Traversals {
    public static void main(String[] args) {
//        TreeNode root = TreeNode.arrayToTree(new Integer[]{1, null, 2, 3});
//        root.print();
//        System.out.println(new Traversals().preorderTraversal(root));
        TreeNode root = TreeNode.array2Tree(new Integer[]{1, 2, 3, 4, null, null, 5});
        root.print();
        System.out.println(new Traversals().levelOrder(root));
    }

    /**
     * 前序遍历： root,left,right
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        if (node.left != null) {
            preorder(node.left, res);
        }
        if (node.right != null) {
            preorder(node.right, res);
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        res.add(Arrays.asList(root.val));
        while (!q.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int count = q.size();
            //每次一次外部循环代表一层，这里定住数量，因为后续queue会持续变化
            for (int i = 0; i < count; i++) {
                TreeNode node = q.pop();
                if (node.left != null) {
                    list.add(node.left.val);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    list.add(node.right.val);
                    q.offer(node.right);
                }
            }
            if (!list.isEmpty()) {
                res.add(list);
            }
        }
        return res;
    }
}
