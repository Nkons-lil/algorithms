import java.util.HashMap;
import java.util.Map;

public class ImplementMaximumRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        // Словарь для хранения частоты символов в текущем окне
        Map<Character, Integer> count = new HashMap<>();
        // Максимальная частота любого символа в текущем окне
        int maxCount = 0;
        // Левая граница окна
        int left = 0;
        // Результат — максимальная длина подходящего окна
        int result = 0;

        // Правая граница окна двигается по всей строке
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // Добавляем символ в окно и увеличиваем его частоту
            count.put(c, count.getOrDefault(c, 0) + 1);
            // Обновляем максимальную частоту символа
            maxCount = Math.max(maxCount, count.get(c));

            // Если количество символов, которые нужно заменить, больше k,
            // то окно слишком большое, и его нужно сузить
            if ((right - left + 1) - maxCount > k) {
                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar) - 1);
                left++;
            }

            // Обновляем максимальную длину подходящего окна
            result = Math.max(result, right - left + 1);
        }

        // Возвращаем длину самого длинного подходящего подстрочного окна
        return result;
    }

    // Пример использования
    public static void main(String[] args) {
        ImplementMaximumRepeatingCharacterReplacement sol = new ImplementMaximumRepeatingCharacterReplacement();
//        System.out.println(sol.characterReplacement("ABAB", 2));   // 4
        System.out.println(sol.characterReplacement("AABABBA", 1)); // 4
    }
}
