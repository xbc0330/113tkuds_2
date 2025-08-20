import java.util.*;

public class M06_PalindromeClean {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) sb.append(c);
        }
        String t = sb.toString();
        String r = sb.reverse().toString();
        if (t.equals(r)) System.out.println("Yes");
        else System.out.println("No");
    }
}
