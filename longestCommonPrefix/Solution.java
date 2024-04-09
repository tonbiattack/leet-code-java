package longestCommonPrefix;

public class Solution {

    /**
     * longestCommonPrefixメソッドは、与えられた文字列配列の中で最長の共通接頭辞を見つける関数です。
     * 
     * @param strs 文字列配列。共通接頭辞を見つける対象の文字列群です。
     * @return strsの中での最長の共通接頭辞。見つからない場合は空文字列を返します。
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
     * mainメソッドは、このクラスの動作をテストするためのエントリーポイントです。
     * 与えられた文字列配列の中で最長の共通接頭辞を見つけ、その結果を標準出力に出力します。
     * 
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = { "flower", "flow", "flight" };
        String result = solution.longestCommonPrefix(strs);
        System.out.println("Longest common prefix: " + result);
    }
}