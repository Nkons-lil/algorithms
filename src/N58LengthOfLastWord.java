//https://leetcode.com/problems/length-of-last-word/description/
public class N58LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;

        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }

        return end - start;
    }

    public static void main(String[] args) {
        new N58LengthOfLastWord().lengthOfLastWord("Hello world");
    }
}
