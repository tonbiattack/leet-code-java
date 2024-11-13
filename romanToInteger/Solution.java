package romanToInteger;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * ローマ数字を整数に変換します。
     * <p>
     * ローマ数字の文字には I, V, X, L, C, D, M があります。各文字はそれぞれ
     * 1, 5, 10, 50, 100, 500, 1000 の値を表しています。
     * 一般的には、左から右に向かって大きい値が小さい値の前にあるときは加算します。
     * しかし、小さい値が大きい値の前にあると、その小さい値を引きます。
     * 例えば、IV = 4, IX = 9 などのような場合です。
     * 
     * @param s ローマ数字の文字列
     * @return 変換された整数値
     */
    public static int romanToInt(String s) {
        // ローマ数字の各文字と対応する整数値をマップに格納
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        // 最終的な整数値を格納する変数
        int result = 0;
        // 文字列を走査し、各文字に対応する整数値を結果に加算
        for (int i = 0; i < s.length(); i++) {
            int value = romanValues.get(s.charAt(i));
            // 現在の文字が次の文字より小さい場合は、結果から減算
            if (i < s.length() - 1 && value < romanValues.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                // それ以外の場合は結果に加算
                result += value;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // ローマ数字の文字列を定義
        String roman = "MCMXCIV";
        // ローマ数字を整数に変換し、結果を出力
        System.out.println("Integer value of Roman numeral " + roman + " is: " + romanToInt(roman));
    }
}
