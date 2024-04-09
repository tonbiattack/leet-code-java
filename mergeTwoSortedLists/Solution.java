package mergeTwoSortedLists;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // ダミーノードを作成し、結果リストの先頭を保持
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // l1とl2の両方に要素がある間、小さい方の要素を結果リストに追加
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // l1またはl2のいずれかに残りの要素がある場合、それらを結果リストに追加
        current.next = (l1 != null) ? l1 : l2;

        // ダミーノードの次のノードが結果リストの先頭
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = solution.mergeTwoLists(l1, l2);

        // 結果リストを出力
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
