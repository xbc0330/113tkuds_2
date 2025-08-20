import java.util.*;

public class M12_MergeKTimeTables {
    static class Entry {
        int val, list, idx;
        Entry(int v, int l, int i) { val = v; list = l; idx = i; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int len = sc.nextInt();
            List<Integer> t = new ArrayList<>();
            for (int j = 0; j < len; j++) t.add(sc.nextInt());
            lists.add(t);
        }

        PriorityQueue<Entry> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.val));
        for (int i = 0; i < K; i++) {
            if (!lists.get(i).isEmpty()) pq.offer(new Entry(lists.get(i).get(0), i, 0));
        }

        List<Integer> merged = new ArrayList<>();
        while (!pq.isEmpty()) {
            Entry e = pq.poll();
            merged.add(e.val);
            if (e.idx + 1 < lists.get(e.list).size()) {
                pq.offer(new Entry(lists.get(e.list).get(e.idx + 1), e.list, e.idx + 1));
            }
        }

        for (int i = 0; i < merged.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(merged.get(i));
        }
    }
}