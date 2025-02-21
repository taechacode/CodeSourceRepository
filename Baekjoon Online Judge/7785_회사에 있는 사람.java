import java.io.*;
import java.util.*;
	
class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException {

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null; // �Է°��� parsing�� StringTokenizer
		String currentEmpNm = null; // ���� �Է¹��� �������� ����
		String enterLeaveYn = null; // ���� �Է¹��� ������ ����ٿ���
		HashSet<String> empSet = new HashSet<>(); // ���� ������ ������ HashSet
				
		for(int logCnt = 0; logCnt < N; logCnt++) {
			st = new StringTokenizer(br.readLine());
			currentEmpNm = st.nextToken();
			enterLeaveYn = st.nextToken();
			
			if(enterLeaveYn.equals("enter")) {
				empSet.add(currentEmpNm);
			} else {
				empSet.remove(currentEmpNm);
			}
		}
		
		// ���� ������ �����ϱ� ���� ArrayList
		ArrayList<String> empList = new ArrayList<>(); 
		
		for(String enterEmpNm : empSet) {
			empList.add(enterEmpNm);
		}
		
		// ���� ������ �������� ����
		Collections.sort(empList, Collections.reverseOrder());
		
		for(String answer : empList) {
			System.out.println(answer);
		}		
		
	}
	
}