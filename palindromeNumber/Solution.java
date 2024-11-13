package palindromeNumber;

/**
 * このクラスは整数が回文かどうかを判定する機能を提供します。
 */
public class Solution {

    /**
     * 整数が回文であるかどうかを判定します。
     * <p>
     * 回文数は、前から読んでも後ろから読んでも同じ数値になる数です。
     * このメソッドでは、まず負の数は回文でないと判断します。
     * 次に、整数を文字列に変換し、その文字列の両端から中央に向かって
     * 文字を比較していきます。一つでも一致しない文字があれば、
     * その数は回文ではないと判断されます。
     * </p>
     * 
     * @param x 判定する整数
     * @return 整数が回文であれば true、そうでなければ false を返します。
     */
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String str = Integer.toString(x);
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        // サンプルの入力データ
        int number = 121;

        // Solutionクラスのインスタンスを作成
        Solution solution = new Solution();

        // isPalindromeメソッドを呼び出し
        boolean result = solution.isPalindrome(number);

        // 結果を表示
        if (result) {
            System.out.println(number + " は回文です。");
        } else {
            System.out.println(number + " は回文ではありません。");
        }
    }
}
