import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> vList = new ArrayList<>(map.values());
        vList.sort((o1, o2) -> o2 - o1);
        
        int sum = 0;
        int min = 0;
        
        for(int v : vList) {
            if(sum + v >= k) {
                min++;
                break;
            } else {
                min++;
                sum += v;                
            }            
        }
        
        return min;
    }
}