package slidingWindow.longestSubarray;

public class Solution {
    // 最長の連続する1のサブアレイの長さを返すメソッド
    public int longestSubarray(int[] A) {
        int i = 0; // スライディングウィンドウの開始位置
        int k = 1; // 削除可能な0の数（この問題では1つだけ削除可能）
        int res = 0; // 最長の連続する1の長さを格納する変数
        
        // スライディングウィンドウの終了位置としてjを初期化
        for (int j = 0; j < A.length; ++j) {
            // A[j]が0であれば、削除可能な0の数を1つ減らす
            if (A[j] == 0) {
                k--;
            }
            
            // 削除可能な0がなくなった場合（kが負になった場合）
            // ウィンドウの開始位置iを右に移動し、条件を満たすよう調整
            while (k < 0) {
                // A[i]が0の場合、削除可能な0を増やして元に戻す
                if (A[i] == 0) {
                    k++;
                }
                // ウィンドウの開始位置を右に移動
                i++;
            }
            
            // 現在のウィンドウの長さ (j - i) と res の最大値を取得
            // resは最長の連続する1の長さを保持する
            res = Math.max(res, j - i);
        }
        
        // 結果を返す
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // // 入力例3
        // int[] A3 = { 1, 1, 0, 1 };
        // // 削除可能な0を1つ取り除いた場合の最長の連続する1の長さを出力
        // System.out.println("最大連続する1の長さ（例3）: " + solution.longestSubarray(A3)); // 出力: 3
        
        // 入力例1
        int[] A1 = { 0,1,1,1,0,1,1,0,1};
        // // 削除可能な0を2つ取り除いた場合の最長の連続する1の長さを出力
        System.out.println("最大連続する1の長さ（例1）: " + solution.longestSubarray(A1)); // 出力: 5

        // // 入力例2
        // int[] A2 = { 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0 };
        // // 削除可能な0を3つ取り除いた場合の最長の連続する1の長さを出力
        // System.out.println("最大連続する1の長さ（例2）: " + solution.longestOnes(A2, K2)); // 出力: 6
    }
}
