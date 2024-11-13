package heightChecker;

import java.util.Arrays;

public class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length); // heightsのコピーを作成
        Arrays.sort(expected); // expectedを昇順にソート

        int count = 0; // 異なるインデックスの数をカウントする変数
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) { // heightsとexpectedが異なる場合
                count++; // カウントを増加
            }
        }
        return count; // 異なるインデックスの数を返す
    }
}
