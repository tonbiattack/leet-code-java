package symmetricTree;

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

    // 対称性をチェックするためのヘルパーメソッド
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true; // 空の木は対称
        }

        // 左右の部分木を比較して対称性を確認
        return isMirror(root.left, root.right);
    }

    // 二つの部分木が対称かどうかを再帰的に確認するヘルパーメソッド
    private boolean isMirror(TreeNode left, TreeNode right) {
        // 両方の部分木がnullなら対称
        if (left == null && right == null) {
            return true;
        }

        // 一方だけがnullの場合は対称ではない
        if (left == null || right == null) {
            return false;
        }

        // 現在のノードの値が等しく、かつ左右の子ノードが鏡像である場合は対称
        return (left.val == right.val)
                && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // サンプルの対称な二分木を作成
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        // 対称性をチェック
        boolean result = solution.isSymmetric(root);
        System.out.println("Is the tree symmetric? " + result);
    }
}

