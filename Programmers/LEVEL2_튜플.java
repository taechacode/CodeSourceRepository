import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        String[] strs = s.replaceAll("[{}]", " ").trim().split(" ,");  
        Arrays.sort(strs, (a,b)->(a.length()-b.length()));
        HashSet<Integer> set = new HashSet<>();
        
        int[] answer = new int[strs.length];
        int index = 0;
        for(String str : strs) {
            for(String st : str.split(",")) {
                int a = Integer.parseInt(st.trim());
                if(set.contains(a)) continue;
                set.add(a);
                answer[index++] = a;
            }
        }
       
        return answer;
    }
}