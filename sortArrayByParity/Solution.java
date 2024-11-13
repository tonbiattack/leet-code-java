package sortArrayByParity;

public class Solution {
    public int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++)
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;;
            }
        return A;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // テストケース：整数配列を定義
        int[] testArray = { 3,1,2,4};
        solution.sortArrayByParity(testArray);
    }
}
