import java.util.*;

public class It_34_FindFirstandLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int left = lowerBound(nums, target);
        if (left == nums.length || nums[left] != target) return new int[]{-1, -1};
        int right = lowerBound(nums, target + 1) - 1;
        return new int[]{left, right};
    }

    private int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (nums[m] < target) l = m + 1;
            else r = m;
        }
        return l;
    }

    public static void main(String[] args) {
        It_34_FindFirstandLastPosition sol = new It_34_FindFirstandLastPosition();
        System.out.println(Arrays.toString(sol.searchRange(new int[]{5,7,7,8,8,10}, 8))); // [3,4]
        System.out.println(Arrays.toString(sol.searchRange(new int[]{5,7,7,8,8,10}, 6))); // [-1,-1]
        System.out.println(Arrays.toString(sol.searchRange(new int[]{}, 0)));             // [-1,-1]
    }
}