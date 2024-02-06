import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        /*
        int[] dp = new int[n + 1];
        
        dp[0] = 0;
        dp[1] = 1;
        
        if(n == 1) return 1;
        
        for(int i = 2; i <= n; i++) {
            if(i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        
        ans = dp[n];
        */
        
        while(n > 0) {
            if(n % 2 == 0) {
                n = n / 2;
            } else {
                n -= 1;
                ans++;
            }
        }
        
        return ans;
    }
}