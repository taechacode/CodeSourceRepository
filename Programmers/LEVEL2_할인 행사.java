class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0;

        for(int i = 0; i < discount.length - 9; i++) {

            int dayCount = 0;
            for(int j = 0; j < want.length; j++) {
                int matchCount = 0;
                for(int k = i; k < i + 10; k++) {
                    if(discount[k].equals(want[j])) matchCount++;
                }
                if(matchCount < number[j]) break;
                else dayCount++;
            }
            
            if(dayCount == want.length) answer++;
        }
        
        return answer;
    }
}