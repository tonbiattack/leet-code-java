package lengthOfLastWord;

public class Solution {

    /**
     * 文字列の最後の単語の長さを返すメソッド
     * 
     * @param s 文字列
     * @return 最後の単語の長さ
     */
    public int lengthOfLastWord(String s) {
        // 文字列の末尾の空白を除去（前後の余分な空白を無視する）
        s = s.trim();

        // 最後の空白の位置を探す
        int lastSpaceIndex = s.lastIndexOf(' ');

        // 詳細な説明:
        // s.length():
        
        // 文字列全体の長さを取得します。この値は、文字列の最初から最後までの全ての文字数を表します。
        // lastSpaceIndex:
        
        // 文字列内で最後に空白が現れる位置（インデックス）を示します。これは、最後の単語が始まる前にある空白の位置です。
        // s.length() - lastSpaceIndex:
        
        // この式は、最後の空白の位置から文字列の終端までの文字数を計算します。つまり、空白の位置以降にある文字数を数えます。ただし、この計算には最後の空白自体も含まれてしまいます。
        // -1 の理由:
        
        // s.length() - lastSpaceIndex だと、空白自体もカウントに含まれてしまうので、実際に最後の単語の長さだけを取得するためには、この空白を除く必要があります。そのため、-1 して空白自体を除外しています。        
        // 最後の単語の長さを計算して返す
        // 文字列全体の長さ（s.length()）から最後の空白のインデックス（lastSpaceIndex）を引き、
        // さらに1を引くことで、最後の単語の長さを計算している。
        // - "s.length()" は文字列全体の長さを表し、
        // - "lastSpaceIndex" は最後に出現した空白文字の位置（インデックス）を指す。
        // そのため、"s.length() - lastSpaceIndex - 1" により、最後の単語の開始位置から
        // 文字列の終端までの文字数、つまり最後の単語の長さが得られる。
        return s.length() - lastSpaceIndex - 1;

    }

    /**
     * テスト用のメインメソッド。
     * いくつかの文字列に対して最後の単語の長さを計算し、結果を表示する。
     * 
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // テストケース1: 最後の単語が "World" の例
        String input = "Helddlo World";
        int result = solution.lengthOfLastWord(input);
        System.out.println("Length of the last word: " + result);  // 5

        // テストケース2: 最後の単語が "moon" の例
        input = "   fly me   to   the moon  ";
        result = solution.lengthOfLastWord(input);
        System.out.println("Length of the last word: " + result);  // 4

        // テストケース3: 最後の単語が "day" の例
        input = "Good day";
        result = solution.lengthOfLastWord(input);
        System.out.println("Length of the last word: " + result);  // 3
    }
}
