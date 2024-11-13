package kThSymbolInGrammar;

public class Solution {
    public int kthGrammar(int n, int k) {
        // ベースケース: 最初の行で最初のシンボルは 0
        if (n == 1 && k == 1) {
            return 0;
        }
        
        // (k + 1) / 2 が上位行での位置を指す
        int parent = kthGrammar(n - 1, (k + 1) / 2);
        
        // k が奇数なら親と同じ、偶数なら逆
        if (k % 2 == 1) {
            return parent;  // 親と同じ
        } else {
            return 1 - parent;  // 親と逆
        }
    }
}

