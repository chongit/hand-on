package io.chone.algorithm.tree;

public class IsBalancedTree {


    /**
     * 左右子树高度差绝对值不大于1，【同时左右子树也是平衡的】
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left, 1) - height(root.right, 1)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node, int height) {
        if (node == null) return height;
        int LH = height(node.left, height + 1);
        int RH = height(node.right, height + 1);
        return Math.max(LH, RH);
    }


    public static void main(String[] args) {

        TreeNode root;

        IsBalancedTree isBalancedTree = new IsBalancedTree();
        //[3,9,20,null,null,15,7]
        //root = array2Tree(new Integer[]{3,9,20,null,null,15,7});
        //root.print();
        //[1,2,2,3,null,null,3,4,null,null,4]
        root = TreeNode.array2Tree(new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4});
        root.print();
        System.out.println(isBalancedTree.isBalanced(root));
    }
}
