package replaceElementsWithGreatestElementOnRightSide;

public class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int maxRight = -1; // 最右の要素の右側には何もないので初期値は-1

        // 配列を逆順に走査
        for (int i = n - 1; i >= 0; i--) {
            int current = arr[i]; // 現在の要素を保存
            arr[i] = maxRight; // 現在の要素を右側の最大値で置き換え
            maxRight = Math.max(maxRight, current); // maxRightを更新
        }

        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // テストケース：整数配列を定義
        int[] testArray = { 17, 18, 5, 4, 6, 1 };
        solution.replaceElements(testArray);
    }
}
