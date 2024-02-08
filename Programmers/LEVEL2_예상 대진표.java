class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(n > 1) {            
            if(a % 2 == 1) {
                a += 1;
            }
            if(b % 2 == 1) {
                b += 1;
            }
            
            if(a == b) {
                answer++;
                break;
            }
            
            a /= 2;
            b /= 2;
            n /= 2;
            answer++;            
        }

        return answer;
    }
}