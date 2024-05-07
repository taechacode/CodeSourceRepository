import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> pqAsc = new PriorityQueue<>();
        PriorityQueue<Integer> pqDesc = new PriorityQueue<>(Collections.reverseOrder());
        int size = 0;
        
        for(int op = 0; op < operations.length; op++) {
            StringTokenizer st = new StringTokenizer(operations[op]);
            String oper = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(oper.equals("I")) {
                pqAsc.add(num);
                pqDesc.add(num);
                size++;
                continue;
            }
            
            if(oper.equals("D") && num < 0) {
                pqAsc.poll();
            } else if(oper.equals("D") && num > 0) {
                pqDesc.poll();
            }
            size--;
            
            if(size <= 0) {
                pqAsc.clear();
                pqDesc.clear();
            }
        }
        
        int largestNumber = pqDesc.isEmpty() ? 0 : pqDesc.poll();
        int smallestNumber = pqAsc.isEmpty() ? 0 : pqAsc.poll();
        
        int[] answer = {largestNumber, smallestNumber};
        
        return answer;
    }
}