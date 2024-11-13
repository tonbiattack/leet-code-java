package isSubsequence;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0; // sとtのインデックスを初期化

        // tの文字列を走査しながら、sの文字を順番に確認する
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // sの現在の文字が一致した場合、次の文字へ進む
            }
            j++; // tの文字は常に進む
        }

        // s全体を確認できていれば、部分シーケンスと判断
        return i == s.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // テストケース1: s = "abc", t = "ahbgdc" -> true
        String s1 = "abc";
        String t1 = "ahbgdc";
        boolean result1 = solution.isSubsequence(s1, t1);
        System.out.println("Is \"" + s1 + "\" a subsequence of \"" + t1 + "\": " + result1); // 結果: true

        // テストケース2: s = "axc", t = "ahbgdc" -> false
        String s2 = "axc";
        String t2 = "ahbgdc";
        boolean result2 = solution.isSubsequence(s2, t2);
        System.out.println("Is \"" + s2 + "\" a subsequence of \"" + t2 + "\": " + result2); // 結果: false

        // テストケース3: s = "", t = "ahbgdc" -> true
        String s3 = "";
        String t3 = "ahbgdc";
        boolean result3 = solution.isSubsequence(s3, t3);
        System.out.println("Is \"" + s3 + "\" a subsequence of \"" + t3 + "\": " + result3); // 結果: true

        // テストケース4: s = "ace", t = "abcde" -> true
        String s4 = "ace";
        String t4 = "abcde";
        boolean result4 = solution.isSubsequence(s4, t4);
        System.out.println("Is \"" + s4 + "\" a subsequence of \"" + t4 + "\": " + result4); // 結果: true

        // テストケース5: s = "aec", t = "abcde" -> false
        String s5 = "aec";
        String t5 = "abcde";
        boolean result5 = solution.isSubsequence(s5, t5);
        System.out.println("Is \"" + s5 + "\" a subsequence of \"" + t5 + "\": " + result5); // 結果: false
    }
}
