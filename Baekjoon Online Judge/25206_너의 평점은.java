
import java.io.*;
import java.util.*;

public class Main {

	static StringBuffer sb = new StringBuffer();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException {
		
		StringTokenizer str;
		String inputGrade;
		Double grade;
		Double allSum = 0.0;
		Double credit;
		Double creditSum = 0.0;
		
		for(int input = 0; input < 20; input++) {
			
			str = new StringTokenizer(br.readLine());
			
			str.nextToken();
			credit = Double.parseDouble(str.nextToken());
			
			inputGrade = str.nextToken();
			
			if(!inputGrade.equals("P")) {
				grade = Double.parseDouble(getGradeScore(inputGrade));
				creditSum += credit;
				allSum += credit * grade;
			}
			
		}
		
		System.out.println(allSum / creditSum);
		
	}
	
	private static String getGradeScore(String grade) {
		
		String gradeScore = grade;
		
		switch(grade) {
		case "A+":
			gradeScore = "4.5";
			break;
		case "A0":
			gradeScore = "4.0";
			break;
		case "B+":
			gradeScore = "3.5";
			break;
		case "B0":
			gradeScore = "3.0";
			break;
		case "C+":
			gradeScore = "2.5";
			break;
		case "C0":
			gradeScore = "2.0";
			break;
		case "D+":
			gradeScore = "1.5";
			break;
		case "D0":
			gradeScore = "1.0";
			break;
		case "F":
			gradeScore = "0.0";
			break;
		}
		
		return gradeScore;
		
	}
	
}
