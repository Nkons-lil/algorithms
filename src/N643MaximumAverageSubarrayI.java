//https://leetcode.com/problems/maximum-average-subarray-i/description/

public class N643MaximumAverageSubarrayI {
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,13,5,1};
        System.out.println(findMaxAverage(arr,4));
    }
}



