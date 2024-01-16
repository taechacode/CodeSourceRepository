class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int pCount = 0;
        int yCount = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.substring(i, i + 1).toUpperCase().equals("P")) {
                pCount++;
            }
            if(s.substring(i, i + 1).toUpperCase().equals("Y")) {
                yCount++;
            }
        }
        
        if(pCount != yCount) {
            answer = false;
        }
        
        return answer;
    }
}