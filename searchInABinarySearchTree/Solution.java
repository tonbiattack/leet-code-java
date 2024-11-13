package searchInABinarySearchTree;

import model.TreeNode;

public class Solution {

    /**
     * 指定された値を持つノードを検索するメソッド
     * @param root ルートノード
     * @param val 探索する値
     * @return 探索値を持つノード（見つからない場合はnull）
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null; // ツリーが空の場合、nullを返す
        if (root.val == val) {
            return root; // 探索値が見つかった場合、そのノードを返す
        } else {
            // 探索値が小さければ左部分木、大きければ右部分木を探索
            return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
        }
    }

    /**
     * 二分探索木に新しいノードを挿入するヘルパーメソッド
     * @param root ルートノード
     * @param val 挿入する値
     * @return 新しいノードが挿入された後のツリーのルート
     */
    public TreeNode insertBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertBST(root.left, val);
        } else if (val > root.val) {
            root.right = insertBST(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 二分探索木を作成
        TreeNode root = null;
        root = solution.insertBST(root, 4);
        solution.insertBST(root, 2);
        solution.insertBST(root, 7);
        solution.insertBST(root, 1);
        solution.insertBST(root, 3);

        // テストケース1：値が存在する場合（3を検索）
        int searchVal1 = 3;
        TreeNode result1 = solution.searchBST(root, searchVal1);
        System.out.println("Search Result for " + searchVal1 + ": " + (result1 != null ? result1.val : "Not found"));

        // テストケース2：値が存在する場合（7を検索）
        int searchVal2 = 7;
        TreeNode result2 = solution.searchBST(root, searchVal2);
        System.out.println("Search Result for " + searchVal2 + ": " + (result2 != null ? result2.val : "Not found"));

        // テストケース3：値が存在しない場合（5を検索）
        int searchVal3 = 5;
        TreeNode result3 = solution.searchBST(root, searchVal3);
        System.out.println("Search Result for " + searchVal3 + ": " + (result3 != null ? result3.val : "Not found"));
    }
}
