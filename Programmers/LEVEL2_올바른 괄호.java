import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int count = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.substring(i, i + 1).equals(")")) {
                answer = false;
                break;
            } else {
                if(s.substring(i, i + 1).equals(")")) {
                    if(count == 0) {
                        answer = false;
                        break;
                    }
                    count--;
                } else {
                    count++;
                }
            }
        }
        
        if(count != 0) {
            answer = false;
        }
        
        return answer;
    }
}