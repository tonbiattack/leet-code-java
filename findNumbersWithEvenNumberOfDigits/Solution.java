package findNumbersWithEvenNumberOfDigits;

// Solutionクラスの定義
class Solution {
    // findNumbersメソッド: 偶数桁の数字の個数を返すメソッド
    public int findNumbers(int[] nums) {
        int count = 0; // 偶数桁の数をカウントするための変数
        int n = nums.length; // 配列の長さを変数nに格納

        // 配列の各要素を走査する
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]); // 負の数でも桁数を正確に計算するために絶対値を取得
            int digit = (int) Math.log10(num) + 1; // 数値numの桁数を計算
            // Math.log10(num): numの10を底とした対数を求め、数の桁数の基準となる値を取得
            // +1: 対数計算で得られた値に1を加えることで、10進数表記での桁数を正確に取得
            // (int): 対数の計算結果は小数になるため、キャストして整数に変換
            // 例: numが7896の場合、log10(7896) ≈ 3.897 であり、これに1を足して4桁と判定

            // 桁数が偶数の場合、カウントをインクリメント
            if (digit % 2 == 0) {
                count++;
            }
        }

        return count; // 偶数桁の数字の個数を返す
    }

    // メインメソッド: テスト用のサンプル実行コード
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = { 12, 345, 2, 6, 7896 }; // テスト用の整数配列
        System.out.println(solution.findNumbers(nums)); // findNumbersメソッドを呼び出し、結果を出力
    }
}
