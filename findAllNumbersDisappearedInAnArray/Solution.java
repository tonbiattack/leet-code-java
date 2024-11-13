package findAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 各数値に基づいてインデックスをマーク
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // 数値からインデックスを計算
            if (nums[index] > 0) { // 既に負でなければマーク
                nums[index] = -nums[index];
            }
        }

        // 負でないインデックスの数値を収集
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) { // 負でなければそのインデックスに対応する数値が存在しない
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // テストケース 1
        int[] nums1 = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println("Test Case 1: " + solution.findDisappearedNumbers(nums1)); // 出力: [5, 6]

        // テストケース 2
        int[] nums2 = { 1, 1 };
        System.out.println("Test Case 2: " + solution.findDisappearedNumbers(nums2)); // 出力: [2]
    }
}
