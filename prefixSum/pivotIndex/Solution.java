package prefixSum.pivotIndex;

class Solution {
    public int pivotIndex(int[] nums) {
        // Initialize total sum of the given array...
        // 配列全体の合計を格納するための変数 totalSum を初期化します。
        int totalSum = 0;

        // Initialize 'leftsum' as sum of first i numbers, not including nums[i]...
        // 左側の部分和を格納するための変数 leftsum を初期化します。
        int leftsum = 0;

        // Traverse the elements and add them to store the totalSum...
        // 配列の全要素をループして合計を求め、totalSum に格納します。
        for (int ele : nums)
            totalSum += ele;

        // Again traverse all the elements through the for loop and store the sum of i
        // numbers from left to right...
        // もう一度全要素をループし、ピボットインデックスの条件を満たすか確認します。
        for (int i = 0; i < nums.length; leftsum += nums[i++]) {
            // sum to the left == leftsum.
            // sum to the right === totalSum - leftsum - nums[i]..
            // ピボットインデックスの条件は、leftsum が右側の部分和に等しい場合です。
            // 右側の部分和は、totalSum から leftsum と nums[i] を引いた値で表されます。
            // 3. ピボットインデックスの条件
            // ループ内の条件 if (leftsum * 2 == totalSum - nums[i])
            // は、ピボットインデックスを見つけるための重要なロジックです。具体的には以下のように機能します。

            // 左側の合計 (leftsum): 現在の要素を除いた左側の部分和です。
            // 右側の合計: totalSum - leftsum - nums[i] で計算されます。
            // このとき、ピボットインデックスの条件として、leftsum == 右側の合計 が成立する必要があります。
            // この条件を式で表すと、次のようになります：

            // leftsum
            // =
            // totalSum
            // −
            // leftsum
            // −
            // nums
            // [
            // 𝑖
            // ]
            // leftsum=totalSum−leftsum−nums[i]
            // この式を整理すると、leftsum * 2 == totalSum - nums[i] となります。この条件が満たされると、現在の i
            // がピボットインデックスであるため、それを返します。

            // 4. 返り値の処理
            // ピボットインデックスが見つかった場合、すぐに return i
            // でインデックスを返します。ループが最後まで終了しても条件を満たすインデックスがない場合は、ループ終了後に -1
            // を返し、ピボットインデックスが存在しないことを示します。
            if (leftsum * 2 == totalSum - nums[i])
                return i; // 条件を満たすインデックスが見つかった場合、そのインデックスを返します。
        }

        return -1; // 条件を満たすインデックスが見つからなかった場合、-1 を返します。
    }

    public static void main(String[] args) {
        // Example input array
        int[] nums = { 1, 7, 3, 6, 5, 6 };

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Call the pivotIndex method and print the result
        int pivotIndex = solution.pivotIndex(nums);
        System.out.println("Pivot Index: " + pivotIndex);
    }
}
