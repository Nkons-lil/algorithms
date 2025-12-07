import java.util.*;

//https://leetcode.com/problems/intersection-of-two-arrays/
public class N349IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        // Добавляем элементы из nums1
        for (int num : nums1) {
            set.add(num);
        }

        List<Integer> resultList = new ArrayList<>();

        // Проверяем nums2
        for (int num : nums2) {
            if (set.contains(num)) {
                resultList.add(num);
                set.remove(num);   // удаляем, чтобы не было повторов
            }
        }

        // Преобразуем список в массив
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
