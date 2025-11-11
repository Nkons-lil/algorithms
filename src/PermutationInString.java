public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {
        // Если первая строка длиннее второй — сразу нет смысла проверять
        if (s1.length() > s2.length()) {
            return false;
        }

        // Частоты символов в s1 (26 символов латиницы)
        int[] s1Count = new int[26];
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        // Частоты символов в текущем "окне" s2
        int[] s2Count = new int[26];
        int left = 0;

        // Перебираем символы s2, расширяя окно вправо
        for (int right = 0; right < s2.length(); right++) {
            s2Count[s2.charAt(right) - 'a']++;

            // Если окно стало длиннее s1 — двигаем левую границу
            if (right - left + 1 > s1.length()) {
                s2Count[s2.charAt(left) - 'a']--;
                left++;
            }

            // Проверяем, совпадают ли частоты — значит, найдена перестановка
            if (matches(s1Count, s2Count)) {
                return true;
            }
        }

        return false;
    }

    // Проверка, одинаковы ли частоты букв в двух массивах
    private static boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ooab";
        String s2 = "baeidbaooo";

        System.out.println(checkInclusion(s1, s2)); // true
    }
}
