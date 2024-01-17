import java.util.*;

class Solution {
    public String solution(String s) {
                
        StringTokenizer st = new StringTokenizer(s, " ", true);                
        String str = "";
        StringBuilder answer = new StringBuilder();
        
        while(st.hasMoreTokens()) {
            str = st.nextToken();
            if(str.length() == 0) {
                answer.append(" ");
            } else {                
                answer.append(str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase());
            }
        }
       
        return answer.toString();
    }
}