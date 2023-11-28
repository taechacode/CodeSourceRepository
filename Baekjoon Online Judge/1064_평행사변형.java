
import java.io.*;
import java.util.*;

public class Main {

	static StringBuffer sb = new StringBuffer();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double xA = Double.parseDouble(st.nextToken());
		double yA = Double.parseDouble(st.nextToken());
		double xB = Double.parseDouble(st.nextToken());
		double yB = Double.parseDouble(st.nextToken());
		double xC = Double.parseDouble(st.nextToken());
		double yC = Double.parseDouble(st.nextToken());
		
		// AB����� AC���Ⱑ ������ 3���� ���� ���������� ���� �����̴�.
		// (xA - xB) / (yA - yB) == (xA - xC) / (yA - yC)
		double M1 = (xA - xB) * (yA - yC);
		double M2 = (xA - xC) * (yA - yB);
		
		// �� �������� �Ÿ� ���ϱ�
		double distanceAB = Math.sqrt(Math.pow((xA - xB), 2) + Math.pow((yA - yB), 2));
		double distanceAC = Math.sqrt(Math.pow((xA - xC), 2) + Math.pow((yA - yC), 2));
		double distanceBC = Math.sqrt(Math.pow((xB - xC), 2) + Math.pow((yB - yC), 2));
		
		double maxLength  = 0;
		double minLength  = 0;
		
		if(M1 == M2) {
			System.out.println(-1.0);
		} else {
			// 2���� ���� ���ϰ�, �� ���� 2��� �ϸ� ����纯���� �ѷ��� ���´�.
			maxLength = Math.max(distanceAB + distanceBC, Math.max(distanceAC + distanceBC, distanceBC + distanceBC));
			minLength = Math.min(distanceAB + distanceBC, Math.min(distanceAC + distanceBC, distanceBC + distanceBC));
			System.out.println((maxLength * 2) - (minLength * 2));
		}
		
	}
	
}
