import java.util.*;

public class It_32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        It_32_LongestValidParentheses sol = new It_32_LongestValidParentheses();
        System.out.println(sol.longestValidParentheses("(()"));      // 2
        System.out.println(sol.longestValidParentheses(")()())"));   // 4
        System.out.println(sol.longestValidParentheses(""));         // 0
    }
}