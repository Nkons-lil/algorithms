//https://leetcode.com/problems/single-number/description/
import java.util.HashMap;
import java.util.Map;

public class N136SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // Считаем количество каждого числа
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        // Ищем число, которое встретилось 1 раз
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1; // если не найдено (по условию задачи такого быть не должно)
    }
}