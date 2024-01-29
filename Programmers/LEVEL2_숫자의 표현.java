class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++) {
            
            int sum = 0;
            for(int j = i; j >= 1; j--) {
                sum += j;
                if(sum > n) break;
                if(sum == n) {
                    answer++;
                    break;
                }
            }
            
        }
        
        return answer;
    }
}