import java.util.*;

class AVLNode {
    int val;
    AVLNode left, right;
    AVLNode(int v) { val = v; }
}

public class M09_AVLValidate {
    static AVLNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;
        AVLNode root = new AVLNode(arr[0]);
        Queue<AVLNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            AVLNode cur = q.poll();
            if (i < arr.length && arr[i] != -1) {
                cur.left = new AVLNode(arr[i]);
                q.offer(cur.left);
            }
            i++;
            if (i < arr.length && arr[i] != -1) {
                cur.right = new AVLNode(arr[i]);
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    static boolean isBST(AVLNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }

    static int checkAVL(AVLNode node) {
        if (node == null) return 0;
        int lh = checkAVL(node.left);
        if (lh == -1) return -1;
        int rh = checkAVL(node.right);
        if (rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;
        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        AVLNode root = buildTree(arr);
        if (!isBST(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            System.out.println("Invalid BST");
            return;
        }
        if (checkAVL(root) == -1) {
            System.out.println("Invalid AVL");
            return;
        }
        System.out.println("Valid");
    }
}

/*
 * Time Complexity: O(n)
 * 說明：檢查 BST 需走訪所有節點一次，檢查 AVL 平衡亦需後序遍歷一次，
 * 因此總體為 O(n)。
 */