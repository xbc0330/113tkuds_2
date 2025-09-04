import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int v) { val = v; }
}

public class LC23_MergeKLists_Hospitals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        List<ListNode> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ListNode dummy = new ListNode(0), cur = dummy;
            while (true) {
                int x = sc.nextInt();
                if (x == -1) break;
                cur.next = new ListNode(x);
                cur = cur.next;
            }
            lists.add(dummy.next);
        }
        ListNode[] arr = lists.toArray(new ListNode[0]);
        ListNode head = mergeKLists(arr);
        while (head != null) {
            System.out.print(head.val + (head.next == null ? "" : " "));
            head = head.next;
        }
    }
    static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) if (node != null) pq.add(node);
        ListNode dummy = new ListNode(0), cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) pq.add(node.next);
        }
        return dummy.next;
    }
}