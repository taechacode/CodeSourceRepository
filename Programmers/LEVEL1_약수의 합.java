class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] visited = new boolean[n + 1];
        
        if(n == 0) {
            return 0;
        }
        
        for(int i = 1; i <= n; i++) {
            if(!visited[i] && n % i == 0) {
                visited[i] = true;
                visited[n / i] = true;
                if(i != (n / i)) {
                    answer += i + (n / i);
                } else {
                    answer += i;
                }
                
            }
        }
        
        return answer;
    }
}