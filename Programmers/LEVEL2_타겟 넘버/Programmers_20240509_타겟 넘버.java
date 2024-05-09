class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        search(numbers, 0, 0, target);
        
        return answer;
    }
    
    private static void search(int[] numbers, int sum, int depth, int target) {
        
        if(depth == numbers.length - 1) {
            if(sum + numbers[depth] == target || sum - numbers[depth] == target) {
                answer++;
            }
            return;
        }
        
        search(numbers, sum + numbers[depth], depth + 1, target);
        search(numbers, sum - numbers[depth], depth + 1, target);
    }
}