
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
		
		// AB기울기와 AC기울기가 같으면 3개의 점이 일직선으로 놓인 상태이다.
		// (xA - xB) / (yA - yB) == (xA - xC) / (yA - yC)
		double M1 = (xA - xB) * (yA - yC);
		double M2 = (xA - xC) * (yA - yB);
		
		// 각 점끼리의 거리 구하기
		double distanceAB = Math.sqrt(Math.pow((xA - xB), 2) + Math.pow((yA - yB), 2));
		double distanceAC = Math.sqrt(Math.pow((xA - xC), 2) + Math.pow((yA - yC), 2));
		double distanceBC = Math.sqrt(Math.pow((xB - xC), 2) + Math.pow((yB - yC), 2));
		
		double maxLength  = 0;
		double minLength  = 0;
		
		if(M1 == M2) {
			System.out.println(-1.0);
		} else {
			// 2개의 변을 합하고, 그 값을 2배로 하면 평행사변형의 둘레가 나온다.
			maxLength = Math.max(distanceAB + distanceBC, Math.max(distanceAC + distanceBC, distanceBC + distanceBC));
			minLength = Math.min(distanceAB + distanceBC, Math.min(distanceAC + distanceBC, distanceBC + distanceBC));
			System.out.println((maxLength * 2) - (minLength * 2));
		}
		
	}
	
}
