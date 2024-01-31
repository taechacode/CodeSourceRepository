import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        String next = "";
        
        Stack<String> stk = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            next = String.valueOf(s.charAt(i));
            
            if(i == 0) {
                stk.push(next);
                continue;
            }
            
            if(!stk.isEmpty() && (next.equals(stk.peek()))) {
                stk.pop();
                continue;
            }
            
            stk.push(next);
            
        }
        
        if(stk.isEmpty()) {
            answer = 1;
        }

        return answer;
    }
}