import java.util.*;

public class M01_BuildHeap {
    static String type;
    static void heapify(int[] arr, int n, int i) {
        int extreme = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (type.equals("max")) {
            if (l < n && arr[l] > arr[extreme]) extreme = l;
            if (r < n && arr[r] > arr[extreme]) extreme = r;
        } else {
            if (l < n && arr[l] < arr[extreme]) extreme = l;
            if (r < n && arr[r] < arr[extreme]) extreme = r;
        }

        if (extreme != i) {
            int tmp = arr[i];
            arr[i] = arr[extreme];
            arr[extreme] = tmp;
            heapify(arr, n, extreme);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        type = sc.next();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);

        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(arr[i]);
        }
    }
}

/*
 * Time Complexity: O(n)
 * 說明：自底向上建堆，每個節點下沉次數與高度相關，
 * 總計近似 n，線性時間完成。
 */