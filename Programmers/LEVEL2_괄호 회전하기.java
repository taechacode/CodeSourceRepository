import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(i > 0) {
                s = pushStr(s);
            }
            if(checkStr(s)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static String pushStr(String s) {
        s = s.substring(1, s.length()) + s.substring(0, 1);
        return s;
    }
    
    private static boolean checkStr(String s) {
        Stack<Character> stk = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            if(stk.isEmpty()) {
                stk.push(s.charAt(i));
            } else if(s.charAt(i) == ']' && stk.peek() == '[') {
                stk.pop();
            } else if(s.charAt(i) == '}' && stk.peek() == '{') {
                stk.pop();
            } else if(s.charAt(i) == ')' && stk.peek() == '(') {
                stk.pop();
            } else {
                stk.push(s.charAt(i));
            }
        }
        
        if(stk.isEmpty()) {
            return true;
        }
        
        return false;
    }
    
}