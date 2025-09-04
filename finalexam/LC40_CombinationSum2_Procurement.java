import java.util.*;

public class LC40_CombinationSum2_Procurement {
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), target = sc.nextInt();
        int[] cand = new int[n];
        for (int i = 0; i < n; i++) cand[i] = sc.nextInt();
        Arrays.sort(cand);
        backtrack(cand, target, new ArrayList<>(), 0);
        for (List<Integer> comb : res) {
            for (int i = 0; i < comb.size(); i++) {
                System.out.print(comb.get(i) + (i == comb.size() - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
    static void backtrack(int[] cand, int target, List<Integer> cur, int idx) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < cand.length && cand[i] <= target; i++) {
            if (i > idx && cand[i] == cand[i - 1]) continue;
            cur.add(cand[i]);
            backtrack(cand, target - cand[i], cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}

