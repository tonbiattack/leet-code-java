package duplicateZeros;

class Solution {
    // 配列内のゼロを複製するメソッド
    public void duplicateZeros(int[] a) {
        int i = 0, sh = 0;
        for (i = 0; sh + i < a.length; ++i) {
            sh += a[i] == 0 ? 1 : 0;
        }
        for (i = i - 1; sh > 0; --i) {
            if (i + sh < a.length)
                a[i + sh] = a[i];
            if (a[i] == 0)
                a[i + --sh] = a[i];
        }
    }

    // メインメソッド: テスト用のサンプル実行コード
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = { 1, 0, 2, 3, 0, 4, 5, 0 }; // テスト用の整数配列
        solution.duplicateZeros(nums); // duplicateZerosメソッドを呼び出し、結果を出力

        // 結果の確認のために配列の内容を出力
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // 出力: 1 0 0 2 3 0 0 4
    }
}
