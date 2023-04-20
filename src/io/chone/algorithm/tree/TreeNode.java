package io.chone.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    void print(TreeNode node, String prefix) {
        if (node == null) return;

        System.out.println(prefix + " + " + node.val);
        print(node.left, prefix + " ");
        print(node.right, prefix + " ");
    }

    public void print() {
        TreePrinter.print(this);
    }


    public static TreeNode array2Tree(Integer[] arr, int i) {
        if (arr == null || i >= arr.length || arr[i] == null) {
            return null;
        }
        return new TreeNode(arr[i], array2Tree(arr, i * 2 + 1), array2Tree(arr, i * 2 + 2));
    }

    public static TreeNode array2Tree(Integer arr[]) {
        return array2Tree(arr, 0);
    }

    static TreeNode arrayToTree(Integer array[]) {
        return arrayToTree(array, 0);
    }

    static TreeNode arrayToTree(Integer array[], int index) {
        if (index >= array.length)
            return null;
        if (array[index] == null)
            return null;
        return new TreeNode(array[index], arrayToTree(array, index * 2 + 1), arrayToTree(array, index * 2 + 2));
    }

    public static class TreePrinter {
        /**
         * Print a tree
         *
         * @param root tree root node
         */
        public static void print(TreeNode root) {
            List<List<String>> lines = new ArrayList<List<String>>();

            List<TreeNode> level = new ArrayList<TreeNode>();
            List<TreeNode> next = new ArrayList<TreeNode>();

            level.add(root);
            int nn = 1;

            int widest = 0;

            while (nn != 0) {
                List<String> line = new ArrayList<String>();

                nn = 0;

                for (TreeNode n : level) {
                    if (n == null) {
                        line.add(null);

                        next.add(null);
                        next.add(null);
                    } else {
                        String aa = String.valueOf(n.val);
                        line.add(aa);
                        if (aa.length() > widest) widest = aa.length();

                        next.add(n.left);
                        next.add(n.right);

                        if (n.left != null) nn++;
                        if (n.right != null) nn++;
                    }
                }

                if (widest % 2 == 1) widest++;

                lines.add(line);

                List<TreeNode> tmp = level;
                level = next;
                next = tmp;
                next.clear();
            }

            int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
            for (int i = 0; i < lines.size(); i++) {
                List<String> line = lines.get(i);
                int hpw = (int) Math.floor(perpiece / 2f) - 1;

                if (i > 0) {
                    for (int j = 0; j < line.size(); j++) {

                        // split node
                        char c = ' ';
                        if (j % 2 == 1) {
                            if (line.get(j - 1) != null) {
                                c = (line.get(j) != null) ? '┴' : '┘';
                            } else {
                                if (j < line.size() && line.get(j) != null) c = '└';
                            }
                        }
                        System.out.print(c);

                        // lines and spaces
                        if (line.get(j) == null) {
                            for (int k = 0; k < perpiece - 1; k++) {
                                System.out.print(" ");
                            }
                        } else {

                            for (int k = 0; k < hpw; k++) {
                                System.out.print(j % 2 == 0 ? " " : "─");
                            }
                            System.out.print(j % 2 == 0 ? "┌" : "┐");
                            for (int k = 0; k < hpw; k++) {
                                System.out.print(j % 2 == 0 ? "─" : " ");
                            }
                        }
                    }
                    System.out.println();
                }

                // print line of numbers
                for (int j = 0; j < line.size(); j++) {

                    String f = line.get(j);
                    if (f == null) f = "";
                    int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                    int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                    // a number
                    for (int k = 0; k < gap1; k++) {
                        System.out.print(" ");
                    }
                    System.out.print(f);
                    for (int k = 0; k < gap2; k++) {
                        System.out.print(" ");
                    }
                }
                System.out.println();

                perpiece /= 2;
            }
        }
    }
}
