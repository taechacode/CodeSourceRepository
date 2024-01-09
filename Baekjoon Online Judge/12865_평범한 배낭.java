
import java.io.*;
import java.util.*;
import java.text.*;

class Thing {
	
	int W;
	int V;
	
	Thing(int W, int V) {
		this.W = W;
		this.V = V;
	}
	
}

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static Thing[] bag;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		bag = new Thing[K + 1];
		dp = new int[N + 1][K + 1];		
		
		for(int things = 1; things <= N; things++) {		
			st = new StringTokenizer(br.readLine());
			bag[things] = new Thing(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));			
		}
		
		for(int i = 1; i <= N; i++) {
			
			for(int bagWeight = 1; bagWeight <= K; bagWeight++) {
				dp[i][bagWeight] = dp[i - 1][bagWeight]; // 이전 행의 값(가치)을 복사
				if(bagWeight - bag[i].W >= 0) { // 만약 가방 무게가 여유가 있다면
					// 이전 행에서 복사한 값(가치)과
					// 현재 행 물건의 가치 + 이전 행에서 현재 행 물건의 무게만큼을 뺐을 때의 가치
					// ... 중에서 큰 가치로 갱신한다.
					dp[i][bagWeight] = Math.max(dp[i][bagWeight], bag[i].V + dp[i - 1][bagWeight - bag[i].W]); // 해당 가방 무게(bagWeight)에서 물건이 i번째까지 있을 때 가장 높은 가치를 구할 수 있다.
				}				
			}
			
		}
		
		System.out.println(dp[N][K]);
	}
			
}
