import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < words.length; i++) {
            if(set.contains(words[i]) || (i > 0 && (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0))) ) {
                answer[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
                answer[1] = i / n + 1;
                break;
            }
            set.add(words[i]);
        }
        
        return answer;
    }
}