package climbingStairs;

/**
 * このクラスは、与えられた階段を登る方法の総数を計算する機能を提供します。
 * 階段を1段または2段ずつ登ることができる場合、n段の階段を登るための方法の数を計算します。
 */
public class Solution {

    /**
     * 与えられた階段の段数に対して、1回で1段または2段登ることができる場合に、
     * その階段を登る全ての方法の総数を計算します。
     * 
     * この問題はフィボナッチ数列と類似しており、f(n) = f(n-1) + f(n-2) という関係式で表されます。
     * n 段に到達するための方法は、1段前 (n-1) から1段登る方法と、2段前 (n-2) から2段登る方法の合計です。
     * 
     * @param n 階段の段数
     * @return n 段の階段を登るための全ての方法の総数
     */
    public int climbStairs(int n) {
        // ベースケース: nが1または2の場合、方法はそのままnに対応する
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        // 1つ前 (n-1) と2つ前 (n-2) のステップからの方法の数を保存
        int oneStepBefore = 2;
        int twoStepsBefore = 1;
        int allWays = 0;

        // 3段目からn段目までの全ての方法を計算
        for (int i = 3; i <= n; i++) {
            // 現在の段に到達する方法は、1段前と2段前の方法の合計
            allWays = oneStepBefore + twoStepsBefore;
            // ステップを進める
            twoStepsBefore = oneStepBefore;  // 2つ前を1つ前に更新
            oneStepBefore = allWays;         // 現在の段数を1つ前に更新
        }

        return allWays;
    }

    /**
     * エントリーポイントとして、このクラスの動作をテストします。
     * 例えば、5段の階段に対して登る方法の総数を計算し、結果を標準出力に表示します。
     * 
     * @param args コマンドライン引数。未使用。
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // テストケース: 階段の段数
        int stairs = 5;
        // 登る方法の総数を計算
        int result = solution.climbStairs(stairs);
        // 結果を表示
        System.out.println("Number of ways to climb " + stairs + " stairs: " + result);
    }
}
