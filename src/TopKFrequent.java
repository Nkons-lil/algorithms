import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {

    // Оптимальный вариант через Bucket Sort
    // Время: O(n)
    // Память: O(n)
    public static List<Integer> topKFrequent(int[] nums, int k) {
        // Шаг 1: Подсчёт частот
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int n = nums.length;

        // Шаг 2: Создание "корзин" (индекс = частота)
        List<List<Integer>> buckets = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            buckets.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }

        // Шаг 3: Сбор k наиболее частых элементов
        List<Integer> result = new ArrayList<>();
        for (int i = n; i >= 0 && result.size() < k; i--) {
            if (!buckets.get(i).isEmpty()) {
                for (int num : buckets.get(i)) {
                    result.add(num);
                    if (result.size() == k) break;
                }
            }
        }

        return result;
    }

    // Вариант "в лоб" через сортировку по частоте (O(n log n))
    public static List<Integer> topKFrequentBruteForce(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }



        // Сортируем элементы по частоте
        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());

        sortedEntries.sort((a, b) -> b.getValue() - a.getValue());

        // Берём первые k элементов
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k && i < sortedEntries.size(); i++) {
            result.add(sortedEntries.get(i).getKey());
        }

        return result;
    }

    // Пример использования
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println("Optimal (Bucket Sort): " + topKFrequent(nums, k)); // [1, 2]
        System.out.println("Brute Force (Sort): " + topKFrequentBruteForce(nums, k)); // [1, 2]
    }
}