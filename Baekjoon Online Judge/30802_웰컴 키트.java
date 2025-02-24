import java.io.*;
import java.util.*;
	
class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st2.nextToken());
		int P = Integer.parseInt(st2.nextToken());
		
		int tSize = 0;
		int groupCntT = 0;
		for(int size = 0; size < 6; size++) {
			tSize = Integer.parseInt(st1.nextToken());
			if(tSize % T == 0) {
				groupCntT += tSize / T;
			} else {
				groupCntT += tSize / T + 1;
			}
		}
		
		System.out.println(groupCntT);
		
		int groupCntP = N / P;
		int eachCntP = N % P;
		System.out.println(groupCntP + " " + eachCntP);
		
	}
	
}