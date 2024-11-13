package slidingWindow.longestOnes.Solution2;

public class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int zeros = 0;

        while (end < nums.length) {
            if (nums[end] == 0) {
                zeros++;
            }
            end++;
            if (zeros > k) {
                if (nums[start] == 0) {
                    zeros--;
                }
                start++;
            }
        }
        return end - start;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // // 入力例1
        // int[] A1 = { 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1 };
        // int K1 = 2;
        // System.out.println("最大連続する1の長さ（例1）: " + solution.longestOnes(A1, K1)); // 出力:
        // 8

        // // 入力例2
        // int[] A2 = { 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0 };
        // int K2 = 3;
        // System.out.println("最大連続する1の長さ（例2）: " + solution.longestOnes(A2, K2)); // 出力:
        // 6

        // 入力例3
        int[] A3 = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int K3 = 2;
        System.out.println("最大連続する1の長さ（例3）: " + solution.longestOnes(A3, K3)); // 出力: 6
    }
}
