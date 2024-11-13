package convertSortedArrayToBinarySearchTree;

// TreeNodeクラスの定義
/**
 * 二分探索木 (Binary Search Tree, BST) のノードを表すクラス。
 * 各ノードは整数値を持ち、左の部分木と右の部分木への参照を保持します。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    /**
     * コンストラクタはノードに値を設定し、左右の部分木をnullに初期化します。
     * 
     * @param val ノードに設定する整数値
     */
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Solution {

    /**
     * ソートされた整数配列を高さバランスの取れた二分探索木 (BST) に変換するメソッド。
     * 
     * @param nums ソートされた整数配列
     * @return 配列から構築された二分探索木のルートノード
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null; // 空の配列が渡された場合はnullを返す
        }
        return helper(nums, 0, nums.length - 1); // ヘルパーメソッドを使用して再帰的にBSTを構築
    }

    /**
     * 再帰的に二分探索木を構築するヘルパーメソッド。
     * 与えられた配列の中央要素を使って現在のノードを作成し、左右の部分木を再帰的に構築します。
     * 
     * @param nums ソートされた整数配列
     * @param left 現在処理中の配列の左端のインデックス
     * @param right 現在処理中の配列の右端のインデックス
     * @return 現在の部分配列から構築されたBSTのルートノード
     */
    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null; // 終了条件: 範囲が無効な場合はnullを返す
        }

        // 中央の要素を取得し、それをルートノードとして選ぶ
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        // 左部分配列を再帰的に処理し、左部分木を構築
        node.left = helper(nums, left, mid - 1);

        // 右部分配列を再帰的に処理し、右部分木を構築
        node.right = helper(nums, mid + 1, right);

        return node; // ルートノードを返す
    }

    /**
     * テスト用のメインメソッド。ソートされた配列をBSTに変換し、プリオーダーで結果を出力します。
     * 
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-10, -3, 0, 5, 9};

        // ソートされた配列をBSTに変換
        TreeNode root = solution.sortedArrayToBST(nums);

        // プリオーダーで結果を出力して検証
        printPreOrder(root);
    }

    /**
     * 二分探索木をプリオーダーで出力するメソッド。
     * プリオーダーとは、ノードを「ルート → 左部分木 → 右部分木」の順で訪問する走査方法です。
     * 
     * @param node プリオーダーで訪問する二分探索木のルートノード
     */
    public static void printPreOrder(TreeNode node) {
        if (node == null) {
            return; // ベースケース: ノードがnullの場合は何も出力せず終了
        }
        // 現在のノードの値を出力
        System.out.print(node.val + " ");
        // 左部分木をプリオーダーで出力
        printPreOrder(node.left);
        // 右部分木をプリオーダーで出力
        printPreOrder(node.right);
    }
}
