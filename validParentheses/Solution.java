package validParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        // スタックを使用して対応する括弧を追跡
        Stack<Character> stack = new Stack<>();

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()[]{}";
        System.out.println(solution.isValid(s)); // true

        s = "(]";
        System.out.println(solution.isValid(s)); // false
    }
}
