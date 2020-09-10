package app;

public class Tech3 {

    public static void main(String[] args) throws Exception {
        String word = "I love you";

        System.out.println(solve(word));
    }

    private static StringBuilder solve(String word) {
        StringBuilder sb = new StringBuilder();
        char[] upper = new char[] { 'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J',
                'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A' };

        char[] lower = new char[] { 'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j',
                'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a' };

        for (int i = 0; i < word.length(); i++) {
            if ((int) word.charAt(i) >= 65 && (int) word.charAt(i) <= 90) {
                sb.append(upper[(int) word.charAt(i) - 65] + "");
            } else if ((int) word.charAt(i) == 32) {
                sb.append(" ");
            } else if ((int) word.charAt(i) >= 97 && (int) word.charAt(i) <= 122) {
                sb.append(lower[(int) word.charAt(i) - 97] + "");
            }
        }
        sb.insert(0, '"');
        sb.append('"');
        return sb;

    }
}