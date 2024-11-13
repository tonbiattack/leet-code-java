package stack.asteroidCollision;

import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] a) {
        LinkedList<Integer> s = new LinkedList<>(); // スタックとしてLinkedListを使用する。最終的に反転する必要がないため効率的。

        for (int i = 0; i < a.length; i++) {
            // 現在の小惑星 a[i] の方向が右方向（正の値）か、スタックが空であるか、スタックの最後の小惑星が左方向に向かっている場合
            if (a[i] > 0 || s.isEmpty() || s.getLast() < 0) {
                // この場合、衝突は発生しないため、スタックにそのまま追加する
                s.add(a[i]);
            } else if (s.getLast() <= -a[i]) { // スタックの最後の小惑星が、現在の小惑星の大きさ以上の場合
                // スタックから小惑星を取り除く（衝突による消失）
                if (s.pollLast() < -a[i]) {
                    // 現在の小惑星の絶対値が、スタック最後の小惑星の絶対値より大きい場合、
                    // 現在の小惑星はまだ衝突していない状態なので再度ループするためにインデックスを1戻す。
                    i--;
                }
                // s.getLast() == -a[i]の場合、衝突して両方消えるので追加しない。
            }
        }
        // 結果として残った小惑星を配列に変換して返す
        return s.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] asteroids = { 5, 10, -5 }; // 例: 入力として小惑星の配列
        // int[] asteroids = {8, -8};
        int[] asteroids = { 10, 2, -5 };
        int[] result = solution.asteroidCollision(asteroids);
        System.out.println(Arrays.toString(result)); // 出力結果を表示
    }
}