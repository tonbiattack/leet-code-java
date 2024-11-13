package hashMapSet.uniqueOccurrences;

import java.util.*; // MapとHashSetのインポート

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // 各整数の出現回数を保持するためのMapを作成
        Map<Integer, Integer> count = new HashMap<>();
        
        // 配列の各要素について出現回数を数える
        for (int a : arr) {
            // 'count'マップにすでにある場合は1増加し、ない場合は0をデフォルト値とする
            count.put(a, 1 + count.getOrDefault(a, 0));
        }
        
        // 出現回数のコレクションをHashSetに変換して、重複を取り除く
        // 'count.size()'はユニークなキー（整数）の数であり、
        // 'new HashSet<>(count.values()).size()'はユニークな出現回数の数を示す
        // 両者が等しい場合、すべての出現回数がユニークであることを意味する
        return count.size() == new HashSet<>(count.values()).size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // テストケース例1
        int[] arr1 = { 1, 2, 2, 1, 1, 3 };
        System.out.println(solution.uniqueOccurrences(arr1)); // 出力: true
        // 理由: 各整数の出現回数は {1:3, 2:2, 3:1} となり、すべての出現回数が異なる

        // テストケース例2
        int[] arr2 = { 1, 2 };
        System.out.println(solution.uniqueOccurrences(arr2)); // 出力: false
        // 理由: 各整数の出現回数は {1:1, 2:1} となり、出現回数が同じ

        // テストケース例3
        int[] arr3 = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };
        System.out.println(solution.uniqueOccurrences(arr3)); // 出力: true
        // 理由: 各整数の出現回数は {-3:3, 0:2, 1:4, 10:1} となり、すべての出現回数が異なる
    }
}
