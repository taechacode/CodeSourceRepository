import java.util.*;

public class Solution {
    
    public int solution(int n) {
        int answer = 0;
        String str = String.valueOf(n);
        String[] numArr = str.split("");
        
        for(int i = 0; i < numArr.length; i++) {
            answer += Integer.parseInt(numArr[i]);
        }
        
        return answer;
    }
}