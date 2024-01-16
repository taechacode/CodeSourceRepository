class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int ab = 0; ab < absolutes.length; ab++) {
            if(signs[ab]) {
                answer += absolutes[ab];
            } else {
                answer -= absolutes[ab];
            }
        }
        
        return answer;
    }
}