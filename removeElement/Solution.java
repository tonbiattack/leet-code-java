package removeElement;

public class Solution {

    /**
     * 与えられた配列から、指定された値 `val` を削除し、
     * 配列をインプレースで更新して新しい配列の長さを返す。
     * 
     * @param nums 削除対象の要素を含む整数配列
     * @param val  削除する要素の値
     * @return     新しい配列の長さ（`val` と異なる要素の数）
     */
    public int removeElement(int[] nums, int val) {
        int index = 0; // 有効な要素を置くための位置を示す変数

        // 配列を最初から最後まで走査
        for (int i = 0; i < nums.length; i++) {
            // 現在の要素が `val` と異なる場合
            if (nums[i] != val) {
                // `index` の位置にその要素を移動
                nums[index] = nums[i];
                index++; // 次の有効な位置を示すためにインクリメント
            }
        }

        // 結果として新しい配列の長さを返す
        return index;
    }

    /**
     * メインメソッド。`removeElement` メソッドの動作をテストし、結果を表示します。
     * 
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // テスト用配列と削除する値を定義
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        
        // `val` を削除し、新しい配列の長さを取得
        int newLength = solution.removeElement(nums, val);

        // 結果を出力
        System.out.println("New length: " + newLength);
        for (int i = 0; i < newLength; i++) {
            // 新しい配列の内容を出力（最初の `newLength` 個のみ）
            System.out.print(nums[i] + " ");
        }
    }
}
