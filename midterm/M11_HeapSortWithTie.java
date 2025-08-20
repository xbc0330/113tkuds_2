import java.util.*;

public class M11_HeapSortWithTie {
    static class Pair {
        int score, idx;
        Pair(int s, int i) { score = s; idx = i; }
    }

    static void heapify(Pair[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1, r = 2 * i + 2;
        if (l < n && (arr[l].score > arr[largest].score ||
            (arr[l].score == arr[largest].score && arr[l].idx < arr[largest].idx))) largest = l;
        if (r < n && (arr[r].score > arr[largest].score ||
            (arr[r].score == arr[largest].score && arr[r].idx < arr[largest].idx))) largest = r;
        if (largest != i) {
            Pair tmp = arr[i]; arr[i] = arr[largest]; arr[largest] = tmp;
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) arr[i] = new Pair(sc.nextInt(), i);

        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);

        List<Integer> sorted = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            sorted.add(arr[0].score);
            Pair tmp = arr[0]; arr[0] = arr[i]; arr[i] = tmp;
            heapify(arr, i, 0);
        }
        Collections.reverse(sorted);
        for (int i = 0; i < sorted.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(sorted.get(i));
        }
    }
}

/*
 * Time Complexity: O(n log n)
 * 說明：建堆需 O(n)，排序過程進行 n 次 extract-max，
 * 每次 heapify O(log n)，總計 O(n log n)。
 */