import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        boolean answer = true;
        if(phone_book.length < 2) return answer;
        
        // 사전식으로 배열하면 바로 직전의 값하고만 비교해도 prefix 여부를 검증 가능하다.
        Arrays.sort(phone_book);
        
        for(int next_phone = 1; next_phone < phone_book.length; next_phone++) {
            if(phone_book[next_phone].startsWith(phone_book[next_phone - 1])) {
                answer = false;
                break;
            }            
        }
        
        return answer;
    }
}