package plusOne;

public class Solution {

    /**
     * 与えられた整数の配列を1増加させ、その結果を新しい配列として返します。
     * 各要素は1桁の数字を表しており、配列全体で大きな整数を表します。
     * 
     * @param digits 配列として表された整数
     * @return 1を加算した結果の整数を表す配列
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // 後ろの桁から順番に処理
        for (int i = n - 1; i >= 0; i--) {
            // 現在の桁が9未満の場合、その桁に1を足して終了
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // すぐに結果を返す
            }
            
            // もし現在の桁が9の場合、繰り上げをするためその桁を0に
            digits[i] = 0;
        }

        // すべての桁が9だった場合、新しい配列が必要
        int[] newNumber = new int[n + 1];
        // 先頭の桁に1をセットし、他はデフォルトで0
        newNumber[0] = 1;
        
        return newNumber;
    }

    /**
     * エントリーポイント。与えられた整数の配列に1を足し、結果を出力します。
     * 
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // テストケース： {9, 9, 9} に1を加える
        int[] digits = {9, 9, 9};
        int[] result = solution.plusOne(digits);
        
        // 結果を出力
        System.out.print("Result: ");
        for (int digit : result) {
            System.out.print(digit + " ");
        }
    }
}
