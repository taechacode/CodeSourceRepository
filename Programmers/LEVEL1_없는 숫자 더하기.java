class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] chkLst = new boolean[10];
        
        for(int num : numbers) {
            chkLst[num] = true;
        }
        
        for(int i = 0; i < 10; i++) {
            if(!chkLst[i]) {
                answer += i;
            }
        } 
        
        return answer;
    }
}