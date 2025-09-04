import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int v) { val = v; }
}

public class LC21_MergeTwoLists_Clinics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        ListNode dummy1 = new ListNode(0), cur = dummy1;
        for (int i = 0; i < n; i++) {
            cur.next = new ListNode(sc.nextInt());
            cur = cur.next;
        }
        ListNode list1 = dummy1.next;
        ListNode dummy2 = new ListNode(0);
        cur = dummy2;
        for (int i = 0; i < m; i++) {
            cur.next = new ListNode(sc.nextInt());
            cur = cur.next;
        }
        ListNode list2 = dummy2.next;
        ListNode head = mergeTwoLists(list1, list2);
        while (head != null) {
            System.out.print(head.val + (head.next == null ? "" : " "));
            head = head.next;
        }
    }
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) { cur.next = l1; l1 = l1.next; }
            else { cur.next = l2; l2 = l2.next; }
            cur = cur.next;
        }
        cur.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}