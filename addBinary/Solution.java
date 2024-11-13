package addBinary;

/**
 * このクラスは、2つのバイナリ文字列を足し合わせ、その結果をバイナリ文字列として返す機能を提供します。
 */
public class Solution {

    /**
     * 2つのバイナリ文字列を足し合わせ、その和をバイナリ文字列として返します。
     * <p>
     * 文字列 a と b はバイナリ表現（'0' と '1' のみを含む）で与えられ、最も右の桁から順に計算し、
     * キャリーを処理しながら結果を構築します。結果のバイナリ和を求めるためには、文字列の長さの差を調整し、
     * キャリーが残っている限り計算を続けます。
     * </p>
     * 
     * @param a 足し合わせる最初のバイナリ文字列
     * @param b 足し合わせる2つ目のバイナリ文字列
     * @return 足し合わせた結果のバイナリ文字列
     */
    public String addBinary(String a, String b) {
        // 結果を構築するためのStringBuilder
        StringBuilder result = new StringBuilder();
        
        // 文字列 a と b の末尾から計算するためのインデックス
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        // キャリーを管理する変数
        int carry = 0;

        // a, b のどちらかが残っているか、キャリーが残っている間は計算を続ける
        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;  // 現在のキャリー値を初期化
            
            // a の桁が残っている場合、その桁の値を sum に加える
            if (i >= 0) {
                sum += a.charAt(i) - '0';  // '0' を引くことで文字を整数に変換
                i--;
            }

            // b の桁が残っている場合、その桁の値を sum に加える
            if (j >= 0) {
                sum += b.charAt(j) - '0';  // '0' を引くことで文字を整数に変換
                j--;
            }

            // sum の 1 桁目（mod 2）を結果に追加
            result.append(sum % 2);
            
            // sum の 2 桁目（キャリー）を更新
            carry = sum / 2;
        }

        // 結果を逆順にして返す（StringBuilderで構築したので逆順）
        return result.reverse().toString();
    }

    /**
     * メインメソッドは、このクラスの動作をテストします。
     * 2つのバイナリ文字列を足し合わせ、結果をコンソールに出力します。
     * 
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // テストケース1: バイナリ文字列 "11" と "1" を足し合わせる
        String a = "11";
        String b = "1";
        String result = solution.addBinary(a, b);
        
        // 結果を出力 (期待結果: 100)
        System.out.println("Result: " + result);  // 出力: 100
        
        // テストケース2: バイナリ文字列 "1010" と "1011" を足し合わせる
        a = "1010";
        b = "1011";
        result = solution.addBinary(a, b);
        
        // 結果を出力 (期待結果: 10101)
        System.out.println("Result: " + result);  // 出力: 10101
    }
}
