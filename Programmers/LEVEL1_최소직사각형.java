class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int wMax = Integer.MIN_VALUE;
        int hMax = Integer.MIN_VALUE;
        
        for(int i = 0; i < sizes.length; i++) {
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            wMax = Math.max(wMax, w);
            hMax = Math.max(hMax, h);
        }
        
        answer = wMax * hMax;
        
        return answer;
    }
}