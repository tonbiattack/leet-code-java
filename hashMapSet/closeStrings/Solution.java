package hashMapSet.closeStrings;

import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        // 各アルファベットの出現回数を格納する配列
        int[] freq1 = new int[26]; // word1の頻度を格納
        int[] freq2 = new int[26]; // word2の頻度を格納

        // word1の文字ごとの出現回数をfreq1に記録
        for (char ch : word1.toCharArray()) {
            freq1[ch - 'a']++; // 'a' からのオフセットを利用してインデックスを決定
        }

        // word2の文字ごとの出現回数をfreq2に記録
        for (char ch : word2.toCharArray()) {
            freq2[ch - 'a']++; // 'a' からのオフセットを利用してインデックスを決定
        }

        // 使用されている文字の種類が異なる場合はfalseを返す
        for (int i = 0; i < 26; i++) {
            // 片方の文字列にはあるがもう片方にはない文字がある場合はclose stringsでない
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false; // 使用されている文字が異なるのでfalseを返す
            }
        }

        // 各文字の出現頻度の配列をソート
        Arrays.sort(freq1); // word1の頻度配列をソート
        Arrays.sort(freq2); // word2の頻度配列をソート

        // ソート後の配列が一致するか確認
        for (int i = 0; i < 26; i++) {
            // 各インデックスの出現頻度が異なる場合はfalseを返す
            if (freq1[i] != freq2[i]) {
                return false; // 頻度が異なるのでfalseを返す
            }
        }

        // すべての条件を満たした場合、close stringsとみなしてtrueを返す
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // テストケース1
        String word1 = "abc";
        String word2 = "bca";
        System.out.println("Test Case 1: " + solution.closeStrings(word1, word2)); // 期待される出力: true

        // テストケース2
        word1 = "aabbcc";
        word2 = "bbccaa";
        System.out.println("Test Case 2: " + solution.closeStrings(word1, word2)); // 期待される出力: true

        // テストケース3
        word1 = "abc";
        word2 = "def";
        System.out.println("Test Case 3: " + solution.closeStrings(word1, word2)); // 期待される出力: false

        // テストケース4
        word1 = "aabbcc";
        word2 = "abc";
        System.out.println("Test Case 4: " + solution.closeStrings(word1, word2)); // 期待される出力: false
    }
}
