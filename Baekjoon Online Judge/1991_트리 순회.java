
import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static char[][] trees;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		trees = new char[26][3];
		
		StringTokenizer st;
		char root_alphabet;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			root_alphabet = st.nextToken().charAt(0);
			trees[root_alphabet - 65][0] = root_alphabet;			
			trees[root_alphabet - 65][1] = st.nextToken().charAt(0);
			trees[root_alphabet - 65][2] = st.nextToken().charAt(0);			
		}
		
		visited = new boolean[26];
		preorder('A');
		sb.append("\n");
		
		visited = new boolean[26];
		inorder('A');
		sb.append("\n");
		
		visited = new boolean[26];
		postorder('A');
		
		System.out.println(sb.toString());
		
	}
	
	private static void preorder(char root) {
		
		visited[root - 65] = true;
		sb.append(root);
		
		if(trees[root - 65][1] == '.' && trees[root - 65][2] == '.') {
			return;
		}		
		
		if(trees[root - 65][1] != '.') {
			if(!visited[trees[root - 65][1] - 65]) {
				preorder(trees[root - 65][1]);
			}
		}
		
		if(trees[root - 65][2] != '.') {
			if(!visited[trees[root - 65][2] - 65]) {
				preorder(trees[root - 65][2]);
			}
		}	
		
	}
	
	private static void inorder(char root) {
		
		if(trees[root - 65][1] != '.') {
			if(!visited[trees[root - 65][1] - 65]) {
				inorder(trees[root - 65][1]);
			}
		}
		
		if(trees[root - 65][1] == '.' && trees[root - 65][2] == '.') {
			visited[root - 65] = true;
			sb.append(root);
			return;
		}
		
		visited[root - 65] = true;
		sb.append(root);
		
		if(trees[root - 65][2] != '.') {
			if(!visited[trees[root - 65][2] - 65]) {
				inorder(trees[root - 65][2]);
			}
		}			
		
	}
	
	private static void postorder(char root) {
		
		if(trees[root - 65][1] != '.') {
			if(!visited[trees[root - 65][1] - 65]) {
				postorder(trees[root - 65][1]);
			}
		}
		
		if(trees[root - 65][2] != '.') {
			if(!visited[trees[root - 65][2] - 65]) {
				postorder(trees[root - 65][2]);
			}
		}
		
		if(trees[root - 65][1] == '.' && trees[root - 65][2] == '.') {
			visited[root - 65] = true;
			sb.append(root);
			return;
		}
		
		visited[root - 65] = true;
		sb.append(root);
			
	}
		
}
