package hashMapSet.equalPairs;

import java.util.HashMap;

class Solution {
    public int equalPairs(int[][] grid) {
        int pair = 0; // 行と列が等しいペアの数を格納する変数
        int temp = 0; // ループで行のインデックスを追跡する変数
        int row = 0; // 現在の行のインデックスを示す変数

        // 行数だけループを回す
        while (temp <= grid.length - 1) {
            HashMap<Integer, Integer> map = new HashMap<>(); // 現在の行の値を格納するHashMap
            // 現在の行の要素をHashMapに格納 (インデックスをキー、値をバリューとして設定)
            for (int j = 0; j < grid.length; j++) {
                map.put(j, grid[row][j]);
            }

            // 各列と現在の行を比較する
            for (int i = 0; i < grid.length; i++) {
                int curr = 0; // 現在の列が行と等しいかを追跡する変数

                // 現在の列の各要素と現在の行の対応する要素を比較
                for (int k = 0; k < grid.length; k++) {
                    // 対応する要素が一致しない場合、currを0にして比較を終了
                    if (map.get(k) != grid[k][i]) {
                        curr = 0;
                        break;
                    } else
                        curr = 1; // 一致する場合は1を設定
                }

                // currが1の場合、ペア数をインクリメント
                pair += curr;
            }

            // 次の行に移動
            row++;
            temp++;
        }

        // 行と列が等しいペアの総数を返す
        return pair;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] grid = {
                { 3, 2, 1 },
                { 1, 7, 6 },
                { 2, 7, 7 }
        };

        int result = solution.equalPairs(grid);
        System.out.println("行と列が等しいペアの数: " + result);
    }
}
