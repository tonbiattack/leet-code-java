package searchInsertPosition;

public class Solution {

    /**
     * 与えられたソート済み配列に対して、指定されたターゲットの位置を検索するか、
     * ターゲットが存在しない場合は挿入されるべき位置を返します。
     * 
     * @param nums ソート済みの整数配列
     * @param target 検索または挿入するターゲット値
     * @return ターゲットのインデックス、または挿入位置
     */
    public int searchInsert(int[] nums, int target) {
        // 左端と右端を初期化
        int left = 0;
        int right = nums.length - 1;

        // 二分探索でターゲットの挿入位置を探す
        while (left <= right) {
            // 中央のインデックスを計算
            int mid = (left + right) / 2;

            // ターゲットが見つかった場合、そのインデックスを返す
            if (nums[mid] == target) {
                return mid;
            }
            // ターゲットが現在の中央より大きい場合、右側を探索
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            // ターゲットが現在の中央より小さい場合、左側を探索
            else {
                right = mid - 1;
            }
        }

        // ターゲットが見つからなかった場合、leftが挿入位置となる
        return left;
    }

    /**
     * メインメソッドは、サンプルデータを使ってメソッドの動作を確認します。
     * 
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 5, 6}; // ソート済み配列
        int target = 5;            // 検索するターゲット
        int result = solution.searchInsert(nums, target); // ターゲットの位置を取得
        System.out.println("Insert position: " + result); // 結果を出力（期待結果: 2）
    }
}
