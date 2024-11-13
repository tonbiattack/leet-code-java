package sameTree;

// 二分木のノードを表すクラス
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    // 二つの木が同じかどうかを確認するメソッド
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // ベースケース: 両方のノードがnullの場合、同じ木と見なす
        if (p == null && q == null) {
            return true;
        }

        // どちらか一方のノードがnullの場合、異なる木
        if (p == null || q == null) {
            return false;
        }

        // ノードの値が異なる場合、異なる木
        if (p.val != q.val) {
            return false;
        }

        // 再帰的に左右の部分木を比較
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 木1: [1, 2, 3]
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);

        // 木2: [1, 2, 3]
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);

        // 木が同じかどうかを確認
        boolean result = solution.isSameTree(tree1, tree2);
        System.out.println("Are the two trees the same? " + result);
    }
}
