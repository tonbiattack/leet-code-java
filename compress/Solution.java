package compress;

class Solution {
    /**
     * 文字配列をインプレースで圧縮するメソッド。
     * 同じ文字が連続する場合、その文字と連続回数を連結して保存し、圧縮後の配列の長さを返す。
     *
     * @param chars 圧縮対象の文字配列
     * @return 圧縮後の文字列の長さ
     */
    public int compress(char[] chars) {
        int ans = 0; // 圧縮された配列の次の書き込み位置を示すインデックス

        // 入力配列charsの全ての要素を一度だけ走査するためのポインタiを初期化し、ループを開始
        for (int i = 0; i < chars.length;) {
            final char letter = chars[i]; // 現在の文字を保持し、次の文字が異なるか確認するための基準とする
            int count = 0; // letterの連続出現回数をカウントするための変数

            // 入力配列charsの次の文字が現在の文字letterと同じである限り、連続回数をカウントしつつポインタiを進める
            while (i < chars.length && chars[i] == letter) {
                ++count; // 出現回数をインクリメント
                ++i; // 次の位置へ進める
            }

            // 圧縮された配列に現在の文字を保存
            chars[ans++] = letter;

            // 連続出現回数が1より大きい場合のみ、その回数を文字列として保存
            if (count > 1) {
                // countを文字列に変換し、例えば"10"などの各桁をchars配列に個別に追加
                for (final char c : String.valueOf(count).toCharArray()) {
                    chars[ans++] = c; // 変換された各文字を配列に保存
                }
            }
        }

        // 圧縮後の配列の長さを返す
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // テストケース1: ['a', 'a', 'b', 'b', 'c', 'c', 'c']
        char[] chars1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int newLength1 = solution.compress(chars1);
        System.out.println("New Length: " + newLength1); // 結果: 6
        System.out.print("Compressed chars: ");
        for (int i = 0; i < newLength1; i++) {
            System.out.print(chars1[i] + " "); // 結果: a 2 b 2 c 3
        }
        System.out.println();

        // テストケース2: ['a']
        char[] chars2 = {'a'};
        int newLength2 = solution.compress(chars2);
        System.out.println("New Length: " + newLength2); // 結果: 1
        System.out.print("Compressed chars: ");
        for (int i = 0; i < newLength2; i++) {
            System.out.print(chars2[i] + " "); // 結果: a
        }
        System.out.println();

        // テストケース3: ['a', 'a', 'a', 'b', 'b', 'a', 'a']
        char[] chars3 = {'a', 'a', 'a', 'b', 'b', 'a', 'a'};
        int newLength3 = solution.compress(chars3);
        System.out.println("New Length: " + newLength3); // 結果: 6
        System.out.print("Compressed chars: ");
        for (int i = 0; i < newLength3; i++) {
            System.out.print(chars3[i] + " "); // 結果: a 3 b 2 a 2
        }
        System.out.println();
    }
}
