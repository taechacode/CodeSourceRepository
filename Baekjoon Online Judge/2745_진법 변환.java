
import java.io.*;
import java.util.*;

public class Main {

	static StringBuffer sb = new StringBuffer();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String N = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		
		char number;
		int multi = 0;
		int answer = 0;
		
		for(int pos = N.length() - 1; pos >= 0; pos--) {
			
			number = N.charAt(pos);
			
			// �빮�� ���ĺ��� �ƽ�Ű �ڵ尡 65���� ���� 90���� ����
			// ���ڴ� �ƽ�Ű �ڵ尡 48���� ���� 57�� ����
			// 58�� �����ص� 0���� ũ�ٸ� �ش� number ������ �빮�� ���ĺ��� ���̴�.
			if(number - 58 > 0) {
				answer += (number - 55) * Math.pow(B, multi);
			} else {
				answer += (number - 48) * Math.pow(B, multi);
			}
			
			multi++;
		}
		
		System.out.println(answer);
		
	}
	
}
