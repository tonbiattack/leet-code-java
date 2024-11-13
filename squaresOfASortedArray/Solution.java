package squaresOfASortedArray;

class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = { -4,-1,0,3,10}; // テスト用の整数配列
        System.out.println(solution.sortedSquares(nums)); // findNumbersメソッドを呼び出し、結果を出力
    }
}
