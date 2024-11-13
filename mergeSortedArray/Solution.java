package mergeSortedArray;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // nums1の末尾からマージを行うため、nums1の末尾インデックスを計算
        int lastIndex = m + n - 1;

        // nums1とnums2の最後の要素の位置を指すインデックス
        int i = m - 1;
        int j = n - 1;

        // nums1の末尾から順に値を埋めていく
        while (i >= 0 && j >= 0) {
            // nums1の現在の要素とnums2の現在の要素を比較して、大きい方を末尾に配置
            if (nums1[i] > nums2[j]) {
                nums1[lastIndex] = nums1[i];
                i--;
            } else {
                nums1[lastIndex] = nums2[j];
                j--;
            }
            lastIndex--;
        }

        // nums2の残りの要素をnums1に埋める
        // nums1はすでに正しい位置にあるため、nums2の要素だけ埋める必要がある
        while (j >= 0) {
            nums1[lastIndex] = nums2[j];
            j--;
            lastIndex--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        // int m = 3;
        // int[] nums2 = { 2, 5, 6 };
        // int n = 3;

        int[] nums1 = { 4, 5, 6, 0, 0, 0 }; // nums1 の有効要素がすべて nums2 の要素より大きい
        int m = 3; // nums1 に3つの有効要素がある
        int[] nums2 = { 1, 2, 3 }; // nums2 にも3つの有効要素がある
        int n = 3; // nums2 に3つの有効要素がある

        solution.merge(nums1, m, nums2, n);


        // 結果を表示
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}
