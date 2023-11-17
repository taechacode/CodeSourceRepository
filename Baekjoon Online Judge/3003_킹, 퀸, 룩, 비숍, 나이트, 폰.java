
import java.io.*;
import java.util.*;

public class Main {

	static StringBuffer sb = new StringBuffer();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static final int KING = 1;
	static final int QUEEN = 1;
	static final int ROOK = 2;
	static final int BISHOP = 2;
	static final int KNIGHT = 2;
	static final int PAWN = 8;
	
	public static void main(String[] args) throws IOException {
		
		int[] pieces = {KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN};
				
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int piece = 0; piece < pieces.length; piece++) {
			pieces[piece] -= Integer.parseInt(st.nextToken());
			sb.append(pieces[piece]).append(" ");
		}
		
		System.out.println(sb.toString());
		
	}
	
}
