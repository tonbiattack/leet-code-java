package binaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

// 二分木のノードの定義
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

    // 中順走査（再帰的アプローチ）
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    // ヘルパーメソッド：再帰的に中順走査を行う
    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return; // ベースケース：ノードがnullの場合は何もしない
        }

        // 左部分木を再帰的に走査
        inorderHelper(node.left, result);

        // 根ノードの値をリストに追加
        result.add(node.val);

        // 右部分木を再帰的に走査
        inorderHelper(node.right, result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // サンプルの二分木を作成: [1, null, 2, 3]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        // 中順走査の結果を取得
        List<Integer> result = solution.inorderTraversal(root);

        // 結果を表示
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}

