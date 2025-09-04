
public class It_33_SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (nums[m] == target) return m;
            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m]) r = m - 1;
                else l = m + 1;
            } else {
                if (nums[m] < target && target <= nums[r]) l = m + 1;
                else r = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        It_33_SearchinRotatedSortedArray sol = new It_33_SearchinRotatedSortedArray();
        System.out.println(sol.search(new int[]{4,5,6,7,0,1,2}, 0)); // 4
        System.out.println(sol.search(new int[]{4,5,6,7,0,1,2}, 3)); // -1
        System.out.println(sol.search(new int[]{1}, 0));             // -1
    }
    }