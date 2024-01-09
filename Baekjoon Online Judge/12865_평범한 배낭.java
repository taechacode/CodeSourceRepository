
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
				dp[i][bagWeight] = dp[i - 1][bagWeight]; // ���� ���� ��(��ġ)�� ����
				if(bagWeight - bag[i].W >= 0) { // ���� ���� ���԰� ������ �ִٸ�
					// ���� �࿡�� ������ ��(��ġ)��
					// ���� �� ������ ��ġ + ���� �࿡�� ���� �� ������ ���Ը�ŭ�� ���� ���� ��ġ
					// ... �߿��� ū ��ġ�� �����Ѵ�.
					dp[i][bagWeight] = Math.max(dp[i][bagWeight], bag[i].V + dp[i - 1][bagWeight - bag[i].W]); // �ش� ���� ����(bagWeight)���� ������ i��°���� ���� �� ���� ���� ��ġ�� ���� �� �ִ�.
				}				
			}
			
		}
		
		System.out.println(dp[N][K]);
	}
			
}
