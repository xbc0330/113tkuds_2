import java.util.*;

public class It_40_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] cand, int remain, int start, List<Integer> path, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < cand.length && cand[i] <= remain; i++) {
            if (i > start && cand[i] == cand[i - 1]) continue;
            path.add(cand[i]);
            backtrack(cand, remain - cand[i], i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        It_40_CombinationSumII sol = new It_40_CombinationSumII();
        System.out.println(sol.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(sol.combinationSum2(new int[]{2,5,2,1,2}, 5));
    }
}