package mergeTwoSortedLists;

/**
 * このクラスは、2つのソート済みの単方向リストをマージし、1つのソート済みリストとして結合する機能を提供します。
 */
class ListNode {
    int val;
    ListNode next;

    /**
     * 単方向リストのノードを表すコンストラクタ。
     * 
     * @param val ノードに格納される整数値
     */
    ListNode(int val) {
        this.val = val;
    }

    /**
     * 次のノードを指定して単方向リストのノードを作成するコンストラクタ。
     * 
     * @param val  ノードに格納される整数値
     * @param next 次のノードへの参照
     */
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * このクラスは、2つのソート済みの単方向リストを1つにマージするためのソリューションを提供します。
 */
public class Solution {

    /**
     * 2つのソート済みのリストを1つにマージします。
     * <p>
     * 各リストの先頭から順に比較し、小さい方の要素を新しいリストに追加していきます。
     * 一方のリストが空になったら、もう一方のリストの残りの要素をそのまま新しいリストに追加します。
     * マージされたリストはソートされた状態で保持されます。
     * </p>
     * 
     * @param l1 ソート済みのリスト1の先頭ノード
     * @param l2 ソート済みのリスト2の先頭ノード
     * @return マージされたソート済みのリストの先頭ノード
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // ダミーノードを作成し、結果リストの先頭を保持
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;  // マージ処理中の現在のノードを追跡

        // l1とl2の両方に要素がある間、小さい方の要素を結果リストに追加
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                // l1の現在のノードの値が小さい場合、そのノードを結果リストに追加
                current.next = l1;
                l1 = l1.next;  // l1の次のノードに進む
            } else {
                // l2の現在のノードの値が小さい場合、そのノードを結果リストに追加
                current.next = l2;
                l2 = l2.next;  // l2の次のノードに進む
            }
            current = current.next;  // 結果リストの次の位置に移動
        }

        // l1またはl2のいずれかに残りの要素がある場合、それらを結果リストに追加
        current.next = (l1 != null) ? l1 : l2;

        // ダミーノードの次のノードが結果リストの先頭
        return dummy.next;
    }

    /**
     * エントリーポイント。2つのソート済みリストをマージし、結果を標準出力に表示します。
     * 
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // リスト1を作成: 1 -> 2 -> 4
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        
        // リスト2を作成: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        
        // 2つのリストをマージ
        ListNode result = solution.mergeTwoLists(l1, l2);

        // 結果リストを出力
        while (result != null) {
            System.out.print(result.val + " ");  // マージされたリストの各要素を順に出力
            result = result.next;  // 次のノードに移動
        }
    }
}
