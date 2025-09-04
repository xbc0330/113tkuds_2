import java.util.*;

public class It_39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            path.add(cand[i]);
            backtrack(cand, remain - cand[i], i, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        It_39_CombinationSum sol = new It_39_CombinationSum();
        System.out.println(sol.combinationSum(new int[]{2,3,6,7}, 7)); // [[2,2,3],[7]]
        System.out.println(sol.combinationSum(new int[]{2,3,5}, 8));   // [[2,2,2,2],[2,3,3],[3,5]]
        System.out.println(sol.combinationSum(new int[]{2}, 1));       // []
    }
}