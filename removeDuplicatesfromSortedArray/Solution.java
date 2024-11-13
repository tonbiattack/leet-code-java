package removeDuplicatesfromSortedArray;

public class Solution {
    /**
     * ソート済みの配列から重複する要素を削除し、ユニークな要素のみを持つ配列の長さを返します。
     * 操作はインプレースで行われ、追加のメモリは定数量しか使用しません。
     * 
     * @param nums 昇順にソートされた整数配列
     * @return 重複が削除された後の配列の長さ
     */
    public int removeDuplicates(int[] nums) {
        // 配列が空の場合、長さは0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 最初の要素は常にユニークなので、そのままにする
        int uniqueIndex = 1; // 次のユニークな要素を置く場所を指す

        // 配列を2番目の要素から走査
        for (int i = 1; i < nums.length; i++) {
            // 現在の要素が前の要素と異なる場合、ユニークな要素と見なす
            if (nums[i] != nums[i - 1]) {
                nums[uniqueIndex] = nums[i]; // ユニークな要素を次の位置に配置
                uniqueIndex++; // 次のユニークな要素の位置を進める
            }
        }

        // 重複が削除された後の新しい配列の長さを返す
        return uniqueIndex;
    }

    /**
     * エントリーポイント。ソート済み配列から重複を削除し、新しい長さと内容を表示します。
     * 
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // テストケース1: ソート済みの整数配列
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        // 重複を削除して新しい長さを取得
        int newLength = solution.removeDuplicates(nums);

        // 結果を表示
        System.out.println("New length: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " "); // 新しい長さの範囲内でユニークな要素を表示
        }
    }
}
