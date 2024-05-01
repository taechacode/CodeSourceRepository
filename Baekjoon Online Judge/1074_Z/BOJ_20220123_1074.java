import java.io.*;
import java.util.*;

public class Main {	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int count = 0;
	public static void main(String[] args) throws IOException {
		int N, r, c;
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int size = (int) Math.pow(2, N);
		search(size, r, c);
		
		System.out.println(count);
	}
	
	public static void search(int size, int r, int c) {
		if(size == 1)
			return;
		if(r < size/2 && c < size/2) {
			search(size/2, r, c);
		}
		else if(r < size/2 && c >=size/2) {
			count += size * size / 4;
			search(size/2, r, c-size/2);
		}
		else if(r >= size/2 && c < size/2) {
			count += size*size / 4 * 2;
			search(size/2, r-size/2, c);
		}
		else {
			count += size*size / 4 * 3;
			search(size/2, r-size/2, c-size/2);
		}
	}
}