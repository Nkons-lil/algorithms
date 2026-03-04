import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/number-of-centered-subarrays/description/
public class N3804NumberOfCenteredSubarrays {
    public int centeredSubarrays(int[] nums) {
        int n = nums.length;

        int result = 0;
        for (int i = 0; i < n; i++) {
            int subsum = 0;
            HashSet<Integer> subnums = new HashSet<>();
            for (int j = i; j < n; j++) {
                subsum += nums[j];
                subnums.add(nums[j]);
                result += subnums.contains(subsum) ? 1 : 0;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        new N3804NumberOfCenteredSubarrays().centeredSubarrays(new int[]{-1,1,0});
    }
}
