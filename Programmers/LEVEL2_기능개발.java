import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int answerCount = 0;
        int dayCount = 0;
        
        Stack<Integer> stk = new Stack<>();
        
        for(int p = 0; p < progresses.length; p++) {
            
            progresses[p] += speeds[p] * dayCount;
            
            if(progresses[p] >= 100) {
                int current = stk.pop() + 1;
                stk.push(current);
                continue;
            }
            
            while(progresses[p] < 100) {
                progresses[p] += speeds[p];
                dayCount++;
            }
            
            stk.push(1);
        }
        
        int[] answer = new int[stk.size()];
        
        for(int i = answer.length - 1; i >= 0 ; i--) {
            answer[i] = stk.pop();
        }
        
        return answer;
    }
}