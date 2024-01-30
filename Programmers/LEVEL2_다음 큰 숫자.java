class Solution {
    public int solution(int n) {
        int answer = 0;
                
        String str = Integer.toBinaryString(n);        
        int count = 0;
        
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1') {
                count++;
            }
        }
                
        int nextN = n;
        String nextStr = ""; 
        int nextCount = 0;
        
        while(count != nextCount) {
            
            nextN++;
            nextStr = Integer.toBinaryString(nextN); 
            nextCount = 0;
            
            for(int i = 0; i < nextStr.length(); i++) {
                if(nextStr.charAt(i) == '1') {
                    nextCount++;
                }
            }
        }
        
        answer = nextN;
            
        return answer;
    }
}