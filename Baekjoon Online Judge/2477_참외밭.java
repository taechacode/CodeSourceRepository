package Baekjoon;

import java.io.*;
import java.util.*;

public class Main {	
	static BufferedReader br;
	static StringTokenizer st;
	static int K, minDir, minLength = Integer.MAX_VALUE;
	static int[] array;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());
		
		array = new int[6];
		
		int widthMaxLength = 0;
		int heightMaxLength = 0;
		int widthMaxIndex = 0;
		int heightMaxIndex = 0;
		
		// 1 동쪽 2 서쪽 3 남쪽 4 북쪽
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			array[i] = length;
			if((dir == 1 || dir == 2) && length > widthMaxLength) {
				widthMaxLength = length;
				widthMaxIndex = i;
			}
			if((dir == 3 || dir == 4) && length > heightMaxLength) {
				heightMaxLength = length;
				heightMaxIndex = i;
			}
		}
		
		// 최대 가로 길이와 최대 세로 길이를 곱한 전체 넓이
		int space = widthMaxLength * heightMaxLength;
		
		// 전체 넓이에서 빼주어야 할 가로와 세로 길이 변수
		int outWidth = 0;
		int outHeight = 0;
		
		// 최대 높이가 저장된 index가 5일 경우 (배열의 마지막일 경우)
		if(widthMaxIndex == 5) {
			if(array[0] == heightMaxLength) {
				outHeight = array[4];
			}
			else {
				outHeight = array[0];
			}
		}
		
		// 최대 높이가 저장된 index가 0일 경우 (배열의 처음일 경우) 
		if(widthMaxIndex == 0) {
			if(array[5] == heightMaxLength) {
				outHeight = array[1];
			}
			else {
				outHeight = array[5];
			}
		}
		
		// 최대 높이가 저장된 index가 0과 5 사이일 경우 (배열의 중간일 경우)
		if(widthMaxIndex < 5 && widthMaxIndex > 0) {
			if(array[widthMaxIndex + 1] == heightMaxLength) {
				outHeight = array[widthMaxIndex - 1];
			}
			else {
				outHeight = array[widthMaxIndex + 1];
			}
		}
		
		// 최대 너비가 저장된 index가 5일 경우 (배열의 마지막일 경우) 
		if(heightMaxIndex == 5) {
			if(array[0] == widthMaxLength) {
				outWidth = array[4];
			}
			else {
				outWidth = array[0];
			}
		}
		
		// 최대 너비가 저장된 index가 0일 경우 (배열의 처음일 경우) 
		if(heightMaxIndex == 0) {
			if(array[5] == widthMaxLength) {
				outWidth = array[1];
			}
			else {
				outWidth = array[5];
			}
		}
		
		// 최대 너비가 저장된 index가 0과 5 사이일 경우 (배열의 중간일 경우)
		if(heightMaxIndex < 5 && heightMaxIndex > 0) {
			if(array[heightMaxIndex + 1] == widthMaxLength) {
				outWidth = array[heightMaxIndex - 1];
			}
			else {
				outWidth = array[heightMaxIndex + 1];
			}
		}
		
		outWidth = Math.abs(widthMaxLength - outWidth);
		outHeight = Math.abs(heightMaxLength - outHeight);
		
		// 단위 넓이별 참외의 개수를 곱하여 전체 참외의 수를 구한다
		space = K * (space - (outWidth * outHeight));
		
		System.out.println(space);
	}
}
