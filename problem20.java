import java.util.*;

class Solution {
    public boolean isValid(String s) {

// use the stack 
        Stack<Character> stack = new Stack<>();
// convert ch to string for more readable
        for(char ch : s.toCharArray()) {
// if bracket is open then push it into the stack
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else {
                // if stack is empty then return false

                if(stack.isEmpty()) {
                    return false;
                }

//if stack is not empty then pop the bracket from the stack
                char top = stack.pop();

                if((ch == ')' && top != '(') ||
                   (ch == '}' && top != '{') ||
                   (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
