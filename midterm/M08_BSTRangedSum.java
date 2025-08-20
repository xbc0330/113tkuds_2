import java.util.*;

class BSTNode {
    int val;
    BSTNode left, right;
    BSTNode(int v) { val = v; }
}

public class M08_BSTRangedSum {
    static BSTNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;
        BSTNode root = new BSTNode(arr[0]);
        Queue<BSTNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            BSTNode cur = q.poll();
            if (i < arr.length && arr[i] != -1) {
                cur.left = new BSTNode(arr[i]);
                q.offer(cur.left);
            }
            i++;
            if (i < arr.length && arr[i] != -1) {
                cur.right = new BSTNode(arr[i]);
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    static int rangeSum(BSTNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L) return rangeSum(root.right, L, R);
        if (root.val > R) return rangeSum(root.left, L, R);
        return root.val + rangeSum(root.left, L, R) + rangeSum(root.right, L, R);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int L = sc.nextInt(), R = sc.nextInt();
        BSTNode root = buildTree(arr);
        System.out.println("Sum: " + rangeSum(root, L, R));
    }
}