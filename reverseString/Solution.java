package reverseString;

public class Solution {
    // 配列の文字列をインプレースで反転させるメソッド
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            // 左右の文字をスワップ
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // テストケース 1: 配列の反転
        char[] test1 = { 'h', 'e', 'l', 'l', 'o' };
        solution.reverseString(test1);
        System.out.println("Reversed Test 1: " + new String(test1)); // 出力: "olleh"

        // テストケース 2: 1文字のみ
        char[] test2 = { 'a' };
        solution.reverseString(test2);
        System.out.println("Reversed Test 2: " + new String(test2)); // 出力: "a"

        // テストケース 3: 数字や記号を含む配列
        char[] test3 = { '1', '2', '3', '4', '5', '!', '@', '#' };
        solution.reverseString(test3);
        System.out.println("Reversed Test 3: " + new String(test3)); // 出力: "#@!54321"
    }
}
