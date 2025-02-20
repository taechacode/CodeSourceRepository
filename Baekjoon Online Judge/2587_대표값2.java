import java.io.*;
import java.util.*;
	
class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException {
		
		ArrayList<Integer> numberList = new ArrayList<>();
		int sum = 0;
		
		for(int inputCnt = 0; inputCnt < 5; inputCnt++) {
			numberList.add(Integer.valueOf(br.readLine()));
			sum += numberList.get(inputCnt);
		}
		
		Collections.sort(numberList);
		
		System.out.println(sum / 5);
		System.out.println(numberList.get(2));
		
	}
	
}