class Solution {
    public int[] solution(int brown, int yellow) {
               
        int sum = brown + yellow;
        int row = 0, col = 0;
        
        for(int i = 3; i < sum; i++) {
            if(sum % i == 0) {
                if(((sum / i) - 2) * (i - 2) == yellow) {
                    row = sum / i;
                    col = i;
                    break;
                }                
            }
        }
        
        int[] answer = {row, col};
        
        return answer;
    }
}