package validParentheses;

import java.util.Stack;

/**
 * このクラスは、与えられた文字列の括弧が有効かどうかを判定する機能を提供します。
 * <p>
 * 対応する括弧の種類は、'(', ')', '{', '}', '[', ']' です。
 * 括弧の正しさは、開いた括弧が対応する閉じ括弧で閉じられていることを意味し、
 * 閉じる順番も正しい必要があります。
 * </p>
 */
public class Solution {

    /**
     * 括弧の組み合わせが有効かどうかを判定します。
     * <p>
     * 有効な括弧の条件は以下の通りです:
     * - 開き括弧に対して対応する閉じ括弧が順番に閉じられていること。
     * - 開き括弧と閉じ括弧が正しい順序でペアになっていること。
     * <p>
     * 本メソッドでは、スタックを用いて開き括弧に対応する閉じ括弧を追跡し、
     * 文字列を順に走査しながら対応する括弧の組み合わせが正しいかどうかを確認します。
     * 
     * @param s 判定対象の括弧列を含む文字列
     * @return 括弧列が有効であれば true、無効であれば false を返します
     */
    public boolean isValid(String s) {
        // スタックを使用して対応する括弧を追跡
        Stack<Character> stack = new Stack<>();

        // 文字列の各文字を順に確認
        for (char c : s.toCharArray()) {
            // 開き括弧が見つかった場合、対応する閉じ括弧をスタックに追加
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            // 閉じ括弧が見つかった場合、スタックが空でないか、
            // スタックの先頭の括弧が現在の閉じ括弧と一致するか確認
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        // 最終的にスタックが空であれば、すべての括弧が正しく閉じられている
        return stack.isEmpty();
    }

    /**
     * エントリーポイント。与えられた文字列の括弧列の有効性をテストします。
     * <p>
     * 例えば、"()[]{}" の場合は true、"(]" の場合は false が出力されます。
     * 
     * @param args コマンドライン引数。未使用。
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 括弧列のテストケース1: 正しい場合
        String s = "()[]{}";
        System.out.println(solution.isValid(s)); // true

        // 括弧列のテストケース2: 間違っている場合
        s = "(]";
        System.out.println(solution.isValid(s)); // false
    }
}
