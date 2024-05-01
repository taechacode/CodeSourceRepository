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
	
	// ���⼭ ��и��� �ϼ��� 1��и�, �ϵ��� 2��и�, ������ 3��и�, ������ 4��и����� ���� 
	private static void search(int r, int c, int size) {
		
		if(size == 1) {
			return;
		}
		
		// 1��и�
		if(r < size/2 && c < size/2) {
			// �� ��и��� �������� count�� �����ֱ� �����̹Ƿ� 4�� ���� ���� �� ��и鿡 �´� ��ġ�� �°� �����ش�.
			// 1��и��̸� 0, 2��и��̸� 1, 3��и��̸� 2, 4��и��̸� 3
			count += size * size / 4 * 0;
			search(r, c, size/2);
		}
		
		// 2��и�
		else if(r < size/2 && c >= size/2) {
			count += size * size / 4 * 1;
			search(r, c - size/2, size/2);
		}
		
		// 3��и�
		else if(r >= size/2 && c < size/2) {
			count += size * size / 4 * 2;
			search(r - size/2, c, size/2);
		}
		
		// 4��и�
		else {
			count += size * size / 4 * 3;
			search(r - size/2, c - size/2, size/2);
		}
		
	}
	
}