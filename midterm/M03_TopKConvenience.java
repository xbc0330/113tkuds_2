import java.util.*;

public class M03_TopKConvenience {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), K = sc.nextInt();
        List<String> names = new ArrayList<>();
        List<Integer> qtys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int qty = sc.nextInt();
            names.add(name);
            qtys.add(qty);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{qtys.get(i), i});
            if (pq.size() > K) pq.poll();
        }

        List<int[]> result = new ArrayList<>(pq);
        result.sort((a, b) -> {
            if (b[0] != a[0]) return b[0] - a[0];
            return a[1] - b[1];
        });

        for (int[] e : result) {
            System.out.println(names.get(e[1]) + " " + e[0]);
        }
    }
}

/*
 * Time Complexity: O(n log K)
 * 說明：每筆資料最多進出堆一次，堆大小固定 K，
 * 每次操作 O(log K)，總計 O(n log K)。
 */