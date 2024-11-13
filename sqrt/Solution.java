package sqrt;

/**
 * このクラスは、非負整数の平方根の整数部分を求める機能を提供します。
 * 二分探索アルゴリズムを使用して、与えられた整数 x に対してその平方根の整数部分を返します。
 */
public class Solution {

    /**
     * 与えられた非負整数 x の平方根の整数部分を返します。
     * <p>
     * 平方根の計算には二分探索を使用します。例えば、x = 8 の場合、平方根は約 2.828 ですが、
     * 整数部分のみが必要なため、2 を返します。x が 0 の場合は 0 を返します。
     * 
     * @param x 平方根を求める対象の非負整数
     * @return x の平方根の整数部分
     */
    public int mySqrt(int x) {
        // x が 0 の場合、その平方根は 0
        if (x == 0) {
            return 0;
        }

        // 二分探索の範囲を 1 から x に設定
        int left = 1;
        int right = x;
        
        // 二分探索で平方根の整数部を探索
        while (left <= right) {
            int mid = (left + right) / 2;
            
            // mid の二乗が x と等しい場合は、その mid が平方根
            if (mid == x / mid) {
                return mid;
            // mid の二乗が x を超える場合、探索範囲を左半分に縮小
            } else if (mid > x / mid) {
                right = mid - 1;
            // mid の二乗が x 未満の場合、探索範囲を右半分に縮小
            } else {
                left = mid + 1;
            }
        }

        // 最終的に right が平方根の整数部分
        return right;
    }

    /**
     * エントリーポイント。与えられた整数に対して平方根の整数部分を計算し、結果を表示します。
     * <p>
     * 例えば、x = 4 の場合、結果として 2 が出力されます。
     * 
     * @param args コマンドライン引数。未使用。
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // テストケース1: 4の平方根
        int x = 4;
        int result = solution.mySqrt(x);
        // 結果を出力
        System.out.println("Square root of " + x + " is: " + result); // 出力: 2
        x = 8;
        result = solution.mySqrt(x);
        System.out.println("Square root of " + x + " is: " + result); // 出力: 2

    }
}
