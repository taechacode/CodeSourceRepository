class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] numArray = s.split(" ");
        int currentNum = 0;
        int maxNum = 0;
        int minNum = 0;
        
        for(int i = 0; i < numArray.length; i++) {
            currentNum = Integer.parseInt(numArray[i]);
            if(i == 0) {
                maxNum = currentNum;
                minNum = currentNum;
                continue;
            }
            maxNum = Math.max(maxNum, currentNum);
            minNum = Math.min(minNum, currentNum);            
        }
        
        answer = String.valueOf(minNum) + " " + String.valueOf(maxNum);
        
        return answer;
    }
}