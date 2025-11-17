import java.util.HashMap;

//https://leetcode.com/problems/contains-duplicate/description/
public class N217ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int num : nums) {
            if (seen.containsKey(num) && seen.get(num) >= 1)
                return true;
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        containsDuplicate(new int[]{1, 2, 3, 4, 5});
    }
}
