package twoSum.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * このクラスは、整数配列とターゲット値が与えられたときに、
 * その配列内の2つの数の和がターゲット値になるような数のインデックスを見つける機能を提供します。
 */
class Solution {

    /**
     * 与えられた整数配列から、2つの数の和が指定されたターゲットに等しい組み合わせのインデックスを返します。
     * <p>
     * このメソッドはハッシュテーブルを使用して、配列の各要素に対する補数（ターゲット値からその要素を引いた値）が
     * 既にハッシュテーブルに存在するかどうかを確認します。補数が見つかった場合、その補数のインデックスと
     * 現在の要素のインデックスを配列として返します。もし解が見つからない場合、
     * {@link IllegalArgumentException} が投げられます。
     * </p>
     * 
     * @param nums   調べる対象の整数配列
     * @param target 2つの数の和として見つけたいターゲット値
     * @return 和がターゲット値になる2つの数のインデックスを含む整数配列。
     *         インデックスは配列内での位置に基づきます。
     * @throws IllegalArgumentException 解が存在しない場合に投げられます。
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i
                };
            }
            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        // サンプルの入力データ
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Solutionクラスのインスタンスを作成
        Solution solution = new Solution();

        // twoSumメソッドを呼び出し
        try {
            int[] result = solution.twoSum(nums, target);

            // 結果を表示
            System.out.println("インデックス: " + result[0] + ", " + result[1]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}