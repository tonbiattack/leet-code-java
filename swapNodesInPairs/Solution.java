package swapNodesInPairs;

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
     * リンクリストのノードをペアで交換するメソッド。
     * 再帰的にリンクリストのペアを交換して、交換後のリストの先頭を返します。
     * 
     * @param head リンクリストの先頭ノード
     * @return 交換後のリストの先頭ノード
     */
    public ListNode swapPairs(ListNode head) {
        // ベースケース: リストが空またはノードが1つだけなら、そのまま返す
        if ((head == null) || (head.next == null))
            return head;

        // headの次のノードを新しいheadとして保存
        ListNode n = head.next;
        
        // head.nextを再帰呼び出しの結果で更新（次のペアの先頭を得る）
        head.next = swapPairs(head.next.next);

        // 新しい先頭nの次を元のheadにして、ペアを逆順に接続
        n.next = head;

        // 交換された新しいheadを返す
        return n;
    }

    /**
     * リンクリストを表示するメソッド。各ノードの値を順に出力します。
     * 
     * @param head リンクリストの先頭ノード
     */
    public void printList(ListNode head) {
        ListNode current = head;
        // リストの末尾に達するまで、各ノードの値を出力
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // テストケース 1: 配列[1, 2, 3, 4]からリンクリストを生成し、swapPairsメソッドを呼び出し
        ListNode test1 = solution.createList(new int[]{1, 2, 3, 4});
        System.out.print("Original List 1: ");
        solution.printList(test1);
        ListNode swapped1 = solution.swapPairs(test1);
        System.out.print("Swapped List 1: ");
        solution.printList(swapped1);

        // テストケース 2: 配列[1, 2, 3]からリンクリストを生成し、swapPairsメソッドを呼び出し
        ListNode test2 = solution.createList(new int[]{1, 2, 3});
        System.out.print("Original List 2: ");
        solution.printList(test2);
        ListNode swapped2 = solution.swapPairs(test2);
        System.out.print("Swapped List 2: ");
        solution.printList(swapped2);

        // テストケース 3: 配列[1]（ノードが1つのみ）からリンクリストを生成し、swapPairsメソッドを呼び出し
        ListNode test3 = solution.createList(new int[]{1});
        System.out.print("Original List 3: ");
        solution.printList(test3);
        ListNode swapped3 = solution.swapPairs(test3);
        System.out.print("Swapped List 3: ");
        solution.printList(swapped3);
    }

    /**
     * 配列をもとにリンクリストを作成するヘルパーメソッド。
     * 
     * @param values 配列内の各要素がノードの値となります。
     * @return 配列の値をもとに作成されたリンクリストの先頭ノード
     */
    public ListNode createList(int[] values) {
        // 空の配列ならnullを返す
        if (values.length == 0) return null;

        // 最初の要素を持つheadノードを作成
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        
        // 配列の各要素を順にリンクリストに追加
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        // 作成されたリストの先頭を返す
        return head;
    }
}
