package validMountaInArray;

public class Solution {

    // 山の形の配列かどうかを判定するメソッド
    public boolean validMountainArray(int[] A) {
        int n = A.length; // 配列の長さを取得
        int i = 0, j = n - 1; // 配列の始まり(i)と終わり(j)のインデックスを初期化

        // 単調増加部分の走査: 前方から始めて、隣り合う要素が増加している間iを進める
        while (i + 1 < n && A[i] < A[i + 1])
            i++;

        // 単調減少部分の走査: 後方から始めて、隣り合う要素が減少している間jを進める
        while (j > 0 && A[j - 1] > A[j])
            j--;

        // 山の形である条件を満たすかを確認
        // 1. i > 0 : 増加部分が少なくとも1つの要素を持っている
        // 2. i == j : 増加と減少が同じ位置（頂点）で交差する
        // 3. j < n - 1 : 減少部分が少なくとも1つの要素を持っている
        return i > 0 && i == j && j < n - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // テストケース 1：山の形の配列
        int[] arr1 = { 0, 3, 2, 1 };
        System.out.println("Test Case 1: " + solution.validMountainArray(arr1)); // 出力: true

        // テストケース 2：山の形ではない配列（単調増加のみ）
        int[] arr2 = { 0, 1, 2, 3 };
        System.out.println("Test Case 2: " + solution.validMountainArray(arr2)); // 出力: false

        // テストケース 3：山の形ではない配列（単調減少のみ）
        int[] arr3 = { 3, 2, 1, 0 };
        System.out.println("Test Case 3: " + solution.validMountainArray(arr3)); // 出力: false

        // テストケース 4：頂点がない配列（同じ値）
        int[] arr4 = { 2, 2, 2 };
        System.out.println("Test Case 4: " + solution.validMountainArray(arr4)); // 出力: false
    }
}
