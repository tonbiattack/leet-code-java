package pascalsTriangleII;

import java.util.*;

public class Solution {
    public List<Integer> getRow(int k) {
        // パスカルの三角形のk行目を格納するための配列を用意
        // k+1 のサイズを用意する理由は、0行目から始めるため
        Integer[] arr = new Integer[k + 1];

        // 配列全体を0で初期化します。
        // 配列の全要素を0で埋めることで、初期値として必要な部分以外を0にリセットします。
        Arrays.fill(arr, 0);

        // 最初の要素は必ず1で始まるため、設定します。
        // パスカルの三角形のどの行も最初の値は1であるため、この設定が必要です。
        arr[0] = 1;

        // 行番号 i を 1 から k まで順に処理していきます。
        // i は現在計算中の行を表します。
        for (int i = 1; i <= k; i++) {
            // 現在の行の要素を右から左に計算します。
            // 右から計算する理由は、左から計算すると値が上書きされ、正しい結果が得られなくなるからです。
            for (int j = i; j > 0; j--) {
                // パスカルの三角形の特性に基づき、現在の要素 arr[j] を更新します。
                // arr[j] = arr[j] + arr[j - 1] は、上の行で左上と真上の値を足して現在の位置に反映させます。
                arr[j] = arr[j] + arr[j - 1];
            }
        }

        // 配列をリストに変換して返します。
        // パスカルの三角形の行をリスト形式で返すために、Arrays.asList を使って配列をリストに変換します。
        return Arrays.asList(arr);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 例として3行目のパスカルの三角形の行を取得し、出力します。
        // 結果は [1, 3, 3, 1] になります。
        System.out.println(solution.getRow(3));
    }
}
