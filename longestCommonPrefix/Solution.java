package longestCommonPrefix;

/**
 * このクラスは、与えられた文字列配列の中で最長の共通接頭辞（prefix）を見つける機能を提供します。
 * 文字列群の中で最も長い共通の接頭辞がある場合、それを返します。もし共通の接頭辞が存在しない場合は、空文字列を返します。
 */
public class Solution {

    /**
     * 与えられた文字列配列の中で最長の共通接頭辞を見つけます。
     * <p>
     * アルゴリズムの概要:
     * 最初の文字列を仮の共通接頭辞として設定し、残りの文字列と比較しながら、共通接頭辞が現れる部分を短縮していきます。
     * 各文字列において、現在の接頭辞が見つからない場合は、接頭辞の長さを1文字ずつ短縮して比較します。
     * 途中で共通接頭辞が空になった場合は、それ以上共通部分が存在しないため、空文字列を返します。
     * 
     * @param strs 共通接頭辞を探す対象となる文字列配列。
     *             配列がnullまたは空の場合は空文字列を返します。
     * @return 最長の共通接頭辞。共通接頭辞が見つからない場合は空文字列を返します。
     * 
     * @throws NullPointerException 引数がnullの場合に発生します。
     */
    public String longestCommonPrefix(String[] strs) {
        // 引数がnullまたは空の場合は、空文字列を返す
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 最初の文字列を共通接頭辞として設定
        String prefix = strs[0];
        // 各文字列と比較して共通接頭辞を見つける
        for (int i = 1; i < strs.length; i++) {
            // 共通接頭辞が現れるまで接頭辞を短くする
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                // 接頭辞が空になったら、それ以上共通接頭辞はないので空文字列を返す
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        // 共通接頭辞を返す
        return prefix;
    }

    /**
     * エントリーポイントとして、このクラスの動作をテストするためのメインメソッドです。
     * <p>
     * 例えば、配列 { "flower", "flow", "flight" } が与えられた場合、"fl" が最長の共通接頭辞として出力されます。
     * 
     * @param args コマンドライン引数。未使用。
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        // テスト用の文字列配列
        String[] strs = { "flower", "flow", "flight" };
        // 最長の共通接頭辞を計算
        String result = solution.longestCommonPrefix(strs);
        // 結果を表示
        System.out.println("Longest common prefix: " + result);
    }
}
