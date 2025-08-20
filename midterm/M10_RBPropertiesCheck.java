import java.util.*;

public class M10_RBPropertiesCheck {
    static class Node {
        int val;
        char color;
        Node left, right;
        Node(int v, char c) { val = v; color = c; }
    }

    static Node buildTree(int[] vals, char[] cols) {
        int n = vals.length;
        if (n == 0 || vals[0] == -1) return null;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            if (vals[i] == -1) nodes[i] = null;
            else nodes[i] = new Node(vals[i], cols[i]);
        }
        for (int i = 0; i < n; i++) {
            if (nodes[i] != null) {
                int l = 2 * i + 1, r = 2 * i + 2;
                if (l < n) nodes[i].left = nodes[l];
                if (r < n) nodes[i].right = nodes[r];
            }
        }
        return nodes[0];
    }

    static boolean redRedViolation(Node root) {
        if (root == null) return false;
        if (root.color == 'R') {
            if ((root.left != null && root.left.color == 'R') ||
                (root.right != null && root.right.color == 'R')) return true;
        }
        return redRedViolation(root.left) || redRedViolation(root.right);
    }

    static int blackHeight(Node root) {
        if (root == null) return 1;
        int lh = blackHeight(root.left);
        int rh = blackHeight(root.right);
        if (lh == -1 || rh == -1 || lh != rh) return -1;
        return lh + (root.color == 'B' ? 1 : 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] vals = new int[n];
        char[] cols = new char[n];
        for (int i = 0; i < n; i++) {
            vals[i] = sc.nextInt();
            cols[i] = sc.next().charAt(0);
            if (vals[i] == -1) cols[i] = 'B';
        }
        Node root = buildTree(vals, cols);

        if (root != null && root.color != 'B') {
            System.out.println("RootNotBlack");
            return;
        }
        if (redRedViolation(root)) {
            System.out.println("RedRedViolation at index 0");
            return;
        }
        if (blackHeight(root) == -1) {
            System.out.println("BlackHeightMismatch");
            return;
        }
        System.out.println("RB Valid");
    }
}