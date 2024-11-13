package maxArea;

class Solution {
    /**
     * 与えられた配列から、最大の水量（面積）を求めるメソッド。
     * 各インデックスがx軸上の位置を表し、高さが水の高さを表していると考え、異なるインデックス間でできる長方形の最大面積を計算します。
     *
     * @param height 各インデックスの高さを表す整数配列
     * @return 最大面積
     */
    public int maxArea(int[] height) {
        int maxArea = 0; // 最大面積を記録する変数
        int left = 0; // 左側からのポインタ
        int right = height.length - 1; // 右側からのポインタ

        // 左右のポインタが交差するまでループを実行
        while (left < right) {
            // 現在のleftとrightの間でできる面積を計算
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * h);

            // 高さの低い側を内側に移動させて、より大きな面積を狙う
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        // 最大面積を返す
        return maxArea;        
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // テストケース1: {1,8,6,2,5,4,8,3,7} の場合
        int[] heights1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result1 = solution.maxArea(heights1);
        System.out.println("Maximum area for heights1: " + result1); // 結果: 49

        // テストケース2: {1,1} の場合
        int[] heights2 = {1, 1};
        int result2 = solution.maxArea(heights2);
        System.out.println("Maximum area for heights2: " + result2); // 結果: 1

        // テストケース3: {4,3,2,1,4} の場合
        int[] heights3 = {4, 3, 2, 1, 4};
        int result3 = solution.maxArea(heights3);
        System.out.println("Maximum area for heights3: " + result3); // 結果: 16

        // テストケース4: {1,2,1} の場合
        int[] heights4 = {1, 2, 1};
        int result4 = solution.maxArea(heights4);
        System.out.println("Maximum area for heights4: " + result4); // 結果: 2
    }
}
