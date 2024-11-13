//ここまで復習 2024/10/14
package removeDuplicatesFromSortedList;

/**
 * ListNodeは、単方向リンクリストのノードを表すクラスです。
 * 各ノードは整数の値と、次のノードへの参照を持ちます。
 */
class ListNode {
    int val;
    ListNode next;

    /**
     * ListNodeのコンストラクタ。ノードの値を指定して初期化します。
     * 
     * @param x ノードの値
     */
    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * Solutionクラスは、ソートされた単方向リンクリストから重複した値を削除するためのメソッドを提供します。
 * ソートされたリストにおいて、同じ値が連続して出現する場合、重複を取り除きます。
 */
public class Solution {

    /**
     * ソートされたリンクリストから重複する要素を削除します。
     * <p>
     * このメソッドは、ソートされた単方向リンクリストを受け取り、隣接するノードが同じ値を持つ場合に
     * その重複を削除します。リストが空または要素が1つしかない場合は、そのままのリストを返します。
     * 
     * @param head ソートされた単方向リンクリストの先頭ノード
     * @return 重複を削除したリストの先頭ノード
     */
    public ListNode deleteDuplicates(ListNode head) {
        // リストが空、または1つの要素しか持たない場合はそのまま返す
        if (head == null || head.next == null) {
            return head;
        }

        // 現在のノードを追跡
        ListNode current = head;

        // リストの終端に達するまで繰り返す
        while (current != null && current.next != null) {
            // 現在のノードと次のノードが同じ値であれば、重複をスキップ
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                // 異なる値の場合、次のノードへ進む
                current = current.next;
            }
        }

        // 重複を削除したリストの頭を返す
        return head;
    }

    /**
     * メインメソッドは、リンクリストを作成し、重複を削除するメソッドをテストします。
     * 結果として得られたリンクリストを標準出力に表示します。
     * 
     * @param args コマンドライン引数。未使用。
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // リストの構築
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        // 重複を削除
        ListNode result = solution.deleteDuplicates(head);

        // 結果を出力
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
