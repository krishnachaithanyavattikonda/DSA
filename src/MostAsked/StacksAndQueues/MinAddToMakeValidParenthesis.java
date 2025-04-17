package MostAsked.StacksAndQueues;
import java.util.*;

public class MinAddToMakeValidParenthesis {
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())"));
        System.out.println(minAddToMakeValid(")))"));
    }
    static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }
}
