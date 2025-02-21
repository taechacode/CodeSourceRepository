import java.io.*;
import java.util.*;
	
class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException {

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null; // 입력값을 parsing할 StringTokenizer
		String currentEmpNm = null; // 현재 입력받은 직원명을 저장
		String enterLeaveYn = null; // 현재 입력받은 직원의 출퇴근여부
		HashSet<String> empSet = new HashSet<>(); // 잔존 직원을 저장할 HashSet
				
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
		
		// 잔존 직원을 정렬하기 위한 ArrayList
		ArrayList<String> empList = new ArrayList<>(); 
		
		for(String enterEmpNm : empSet) {
			empList.add(enterEmpNm);
		}
		
		// 사전 순서의 역순으로 정렬
		Collections.sort(empList, Collections.reverseOrder());
		
		for(String answer : empList) {
			System.out.println(answer);
		}		
		
	}
	
}