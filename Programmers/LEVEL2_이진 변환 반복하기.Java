class Solution {
    public int[] solution(String s) {
        
        int toBinaryCount = 0;
        int delZeroCount = 0;
        
        while(!s.equals("1")) {
            
            int afterDelZeroLength = 0;
        
            for(int i = 0; i < s.length(); i++) {
                int current = Integer.parseInt(s.substring(i, i + 1));
                if(current == 1) {
                    afterDelZeroLength++;
                }
            }  
            
            delZeroCount += s.length() - afterDelZeroLength;
            s = Integer.toBinaryString(afterDelZeroLength);
            toBinaryCount++;
        }
        
                
        int[] answer = {toBinaryCount, delZeroCount};
        return answer;
    }
}