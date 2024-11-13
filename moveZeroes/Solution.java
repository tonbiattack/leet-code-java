package moveZeroes;

class Solution {
    public void moveZeroes(int[] nums) {
        int snowBallSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowBallSize++;
            } else if (snowBallSize > 0) {
                int t = nums[i];
                nums[i] = 0;
                nums[i - snowBallSize] = t;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // テストケース：整数配列を定義
        int[] testArray = { 0,1,0,3,12};
        solution.moveZeroes(testArray);
    }
}
