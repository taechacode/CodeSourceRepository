import java.io.*;
import java.util.*;

	
class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int size = (int)Math.pow(2, N);
		
		search(r, c, size);
		
		System.out.println(count);
		
	}
	
	// 여기서 사분면은 북서향 1사분면, 북동향 2사분면, 남서향 3사분면, 남동향 4사분면으로 정의 
	private static void search(int r, int c, int size) {
		
		if(size == 1) {
			return;
		}
		
		// 1사분면
		if(r < size/2 && c < size/2) {
			// 각 사분면의 시작점을 count에 더해주기 위함이므로 4로 나눈 다음 각 사분면에 맞는 위치에 맞게 곱해준다.
			// 1사분면이면 0, 2사분면이면 1, 3사분면이면 2, 4사분면이면 3
			count += size * size / 4 * 0;
			search(r, c, size/2);
		}
		
		// 2사분면
		else if(r < size/2 && c >= size/2) {
			count += size * size / 4 * 1;
			search(r, c - size/2, size/2);
		}
		
		// 3사분면
		else if(r >= size/2 && c < size/2) {
			count += size * size / 4 * 2;
			search(r - size/2, c, size/2);
		}
		
		// 4사분면
		else {
			count += size * size / 4 * 3;
			search(r - size/2, c - size/2, size/2);
		}
		
	}
	
}