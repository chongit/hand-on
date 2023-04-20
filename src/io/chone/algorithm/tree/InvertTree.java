package io.chone.algorithm.tree;

public class InvertTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.array2Tree(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        root.print();
        new InvertTree().invertTree(root);
        root.print();
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        //swap
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

    public void invertTreeInner(TreeNode node) {
        if (node == null) {
            return;
        }
        invertTreeInner(node.left);
        invertTreeInner(node.right);
        //swap
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}
