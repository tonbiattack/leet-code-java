package checkIfNAndItsDoubleExist;
import java.util.*;

public class Solution {

    // メソッド：配列内にある数とその2倍または半分の数が存在するかを確認する
    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>(); // 既に見た数を保存するSet

        // 配列内の各数を順に確認
        for (int i : arr) {
            // もし既に見た数に「現在の数の2倍」または「現在の数の半分」が含まれていたらtrueを返す
            if (seen.contains(2 * i) || (i % 2 == 0 && seen.contains(i / 2))) {
                return true;
            }
            // 現在の数をSetに追加
            seen.add(i);
        }
        // 2倍や半分の数が見つからない場合はfalseを返す
        return false;
    }

    // メインメソッド：動作確認用
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // テストケース：整数配列を定義
        int[] testArray = {10, 2, 5, 3};

        // メソッド呼び出し：配列内で倍数や半分が存在するかを確認
        boolean result = solution.checkIfExist(testArray);

        // 結果を出力
        System.out.println("Does the array contain a number and its double? " + result);
    }
}
