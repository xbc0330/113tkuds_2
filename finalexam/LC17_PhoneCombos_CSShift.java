import java.util.*;

public class LC17_PhoneCombos_CSShift {
    static String[] map = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    static List<String> ans = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        if (digits.length() == 0) return;
        backtrack(new StringBuilder(), digits, 0);
        for (String s : ans) System.out.println(s);
    }
    static void backtrack(StringBuilder sb, String digits, int idx) {
        if (idx == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String letters = map[digits.charAt(idx) - '0'];
        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(sb, digits, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}