import java.util.*;

public class It_31_NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    public static void main(String[] args) {
        It_31_NextPermutation sol = new It_31_NextPermutation();
        int[] nums1 = {1,2,3};
        sol.nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {3,2,1};
        sol.nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {1,1,5};
        sol.nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3));
    }
}