class Solution {
    public int solution(int[] arr) {
        
        if(arr.length == 1) return arr[0];
        
        int answer = arr[0];
        for(int i = 0; i < arr.length; i++) {
            answer = (answer * arr[i]) / gcd(answer, arr[i]);
        }
              
        return answer;
    }
    
    private int gcd(int a, int b) {
        int r = a % b;
        if(r == 0) return b;
        return gcd(b, r);
    }
}