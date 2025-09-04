public class It_38_CountandSay {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j <= s.length(); j++) {
                if (j < s.length() && s.charAt(j) == s.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count).append(s.charAt(j - 1));
                    count = 1;
                }
            }
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        It_38_CountandSay sol = new It_38_CountandSay();
        System.out.println(sol.countAndSay(1)); // "1"
        System.out.println(sol.countAndSay(4)); // "1211"
    }
}

