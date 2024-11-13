package reverseLinkedList;

public class Solution {
    /**
     * ノードを表す内部クラス。リンクリストの各ノードがこのクラスのインスタンスで表されます。
     */
    public class ListNode {
        int val;  // ノードの値
        ListNode next;  // 次のノードへの参照

        // コンストラクタ: デフォルトコンストラクタ
        ListNode() {
        }

        // コンストラクタ: 値を指定する場合
        ListNode(int val) {
            this.val = val;
        }

        // コンストラクタ: 値と次のノードを指定する場合
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * リンクリストを逆転させるメソッド。
     * @param head リンクリストの先頭ノード
     * @return 逆転後のリンクリストの先頭ノード
     */
    public ListNode reverseList(ListNode head) {
        /* iterative solution */
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next; // 次のノードを保持
            head.next = newHead;        // 現在のノードを逆転リストの先頭に接続
            newHead = head;             // newHeadを現在のノードに更新
            head = next;                // headを次のノードに移動
        }
        return newHead;
    }

    /**
     * リンクリストを表示するメソッド。各ノードの値を順に出力します。
     * @param head リンクリストの先頭ノード
     */
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * 配列からリンクリストを作成するヘルパーメソッド。
     * @param values 配列内の各要素がノードの値になります。
     * @return 配列の値を元に作成されたリンクリストの先頭ノード
     */
    public ListNode createList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // テストケース 1: リスト [1, 2, 3, 4, 5] を逆転
        ListNode test1 = solution.createList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Original List 1: ");
        solution.printList(test1);
        ListNode reversed1 = solution.reverseList(test1);
        System.out.print("Reversed List 1: ");
        solution.printList(reversed1);

        // テストケース 2: リスト [1, 2] を逆転
        ListNode test2 = solution.createList(new int[]{1, 2});
        System.out.print("Original List 2: ");
        solution.printList(test2);
        ListNode reversed2 = solution.reverseList(test2);
        System.out.print("Reversed List 2: ");
        solution.printList(reversed2);

        // テストケース 3: リスト [1] を逆転
        ListNode test3 = solution.createList(new int[]{1});
        System.out.print("Original List 3: ");
        solution.printList(test3);
        ListNode reversed3 = solution.reverseList(test3);
        System.out.print("Reversed List 3: ");
        solution.printList(reversed3);

        // テストケース 4: 空のリストを逆転
        ListNode test4 = solution.createList(new int[]{});
        System.out.print("Original List 4: ");
        solution.printList(test4);
        ListNode reversed4 = solution.reverseList(test4);
        System.out.print("Reversed List 4: ");
        solution.printList(reversed4);
    }
}
