
public class It_35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (nums[m] < target) l = m + 1;
            else r = m;
        }
        return l;
    }

    public static void main(String[] args) {
        It_35_SearchInsertPosition sol = new It_35_SearchInsertPosition();
        System.out.println(sol.searchInsert(new int[]{1,3,5,6}, 5)); // 2
        System.out.println(sol.searchInsert(new int[]{1,3,5,6}, 2)); // 1
        System.out.println(sol.searchInsert(new int[]{1,3,5,6}, 7)); // 4
    }
}