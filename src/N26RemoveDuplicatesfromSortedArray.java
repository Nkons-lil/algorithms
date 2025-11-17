//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class N26RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,2,2,3,4,4,4,4,4};
        removeDuplicates(a);
    }
}
