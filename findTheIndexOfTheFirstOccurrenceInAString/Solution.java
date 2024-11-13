package findTheIndexOfTheFirstOccurrenceInAString;

public class Solution {

    /**
     * `haystack` の中で最初に `needle` が現れる位置を返します。
     * `needle` が `haystack` に存在しない場合は -1 を返します。
     * 
     * @param haystack 検索対象の文字列
     * @param needle 検索する部分文字列
     * @return `needle` が最初に現れるインデックス、存在しない場合は -1
     */
    public int strStr(String haystack, String needle) {
        // `needle` が空文字列の場合は 0 を返す
        if (needle.isEmpty()) {
            return 0;
        }

        // `haystack` の長さが `needle` より短い場合は -1 を返す
        if (haystack.length() < needle.length()) {
            return -1;
        }

        // `haystack` 内で `needle` を探索
        // 探索範囲は `haystack.length() - needle.length()` まで
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // `haystack` の部分文字列が `needle` と一致するか確認
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; // 一致した位置を返す
            }
        }

        // `needle` が見つからなかった場合は -1 を返す
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // テストケース1: "hello" の中で "ll" を探す
        String haystack = "hello";
        String needle = "ll";
        int result = solution.strStr(haystack, needle);
        System.out.println("The index of the first occurrence: " + result); // 期待される出力: 2

        // テストケース2: "aaaaa" の中で "bba" を探す
        haystack = "aaaaa";
        needle = "bba";
        result = solution.strStr(haystack, needle);
        System.out.println("The index of the first occurrence: " + result); // 期待される出力: -1

        // テストケース3: `needle` が空文字列の場合
        haystack = "abc";
        needle = "";
        result = solution.strStr(haystack, needle);
        System.out.println("The index of the first occurrence: " + result); // 期待される出力: 0
    }
}
