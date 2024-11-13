package findMaxAverage;

public class Solution {
    // このメソッドは、指定された配列内で長さkの連続したサブアレイの最大平均を見つけるためのものです。
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0; // 初期のサブアレイの合計を格納するための変数
        
        // 最初のk個の要素の合計を計算します。
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        
        long max = sum; // maxには現在の最大合計を保存します（初期は最初のk個の合計）

        // 配列全体をk個の要素ずつずらしながら、最大のサブアレイの合計を見つけます。
        for (int i = k; i < nums.length; i++) {
            // 新しい要素を加え、最も古い要素を引くことでウィンドウをシフト
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum); // 最大のサブアレイの合計を更新
        }

        // 平均を求めるために、maxをdouble型に変換してkで割ります。
        return max / 1.0 / k;
    }

    // テストの呼び出し箇所
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 12, -5, -6, 50, 3}; // テスト用の配列
        int k = 4; // kの値
        double result = solution.findMaxAverage(nums, k); // メソッドを呼び出して結果を得る
        System.out.println("最大平均: " + result); // 結果を表示
    }
}
