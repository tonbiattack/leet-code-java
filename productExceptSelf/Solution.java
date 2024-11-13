package productExceptSelf;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 結果を格納するための配列を初期化
        // ここで全ての要素を1で初期化することで、後に左積・右積の値を簡単に掛け算できるようにしています。
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = 1; // 各位置を1で初期化
        }

        // 左積の計算
        // leftは現在の位置より左側の全要素の積を保持する変数です
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            // output[i]にleftを代入することで、現在の位置を含めない左側の積が反映されます。
            output[i] *= left; // 現在の位置の左側だけの積をセット
            // 次の要素に進む前に、leftに現在のnums[i]を掛けることで、次の要素の左側の積を更新します。
            left *= nums[i];   // 次の位置に進むためleftを更新
        }

        // 右積の計算
        // rightは現在の位置より右側の全要素の積を保持する変数です
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // output[i]にrightを掛けることで、現在の位置を含めない右側の積が反映されます。
            // 既に左積が入っているoutput[i]に右積を掛け合わせることで「自分以外の全要素の積」が計算されます。
            output[i] *= right; // 現在の位置の右側だけの積を掛け合わせる
            // 次の要素に進む前に、rightに現在のnums[i]を掛けることで、次の要素の右側の積を更新します。
            right *= nums[i];   // 次の位置に進むためrightを更新
        }

        // 結果の配列outputには、各位置iにおいてnums[i]以外の全要素の積が格納されています。
        return output;        
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // テストデータ
        int[] nums = { 1, 2, 3, 4 };

        // メソッドを呼び出し結果を取得
        int[] result = solution.productExceptSelf(nums);

        // 結果を出力
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
