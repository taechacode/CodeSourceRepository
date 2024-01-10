
import java.io.*;
import java.util.*;
import java.text.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		String str = br.readLine();
		
		boolean zeroSerialFlag = false;
		boolean oneSerialFlag = false;
		int zeroSerialCount = 0;
		int oneSerialCount = 0;
		
		for(int i = 0; i < str.length(); i++) {
			
			if(str.charAt(i) == '0') {
				if(!zeroSerialFlag) {
					zeroSerialCount++;
					zeroSerialFlag = true;	
					oneSerialFlag = false;
				}				
			} 
			
			if(str.charAt(i) == '1') {
				if(!oneSerialFlag) {					
					oneSerialCount++;
					oneSerialFlag = true;
					zeroSerialFlag = false;
				}				
			}
			
		}
		
		System.out.println(Math.min(zeroSerialCount, oneSerialCount));
		
	}
			
}
