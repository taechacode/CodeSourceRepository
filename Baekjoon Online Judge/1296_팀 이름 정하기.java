import java.io.*;
import java.util.*;
	
class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] LOVE_SCORE;
	static int MAX_SCORE = Integer.MIN_VALUE;
	static ArrayList<String> WIN_LIST = new ArrayList<>();
		
	public static void main(String[] args) throws IOException {
		
		String yeonDuEngName = br.readLine();
		int N = Integer.parseInt(br.readLine());		
		
		for(int i = 0; i < N; i++) {
			String teamName = br.readLine();
			LOVE_SCORE = new int[4];
			
			addScore(yeonDuEngName);
			addScore(teamName);			
			int currentTeamScore = scoreAdjustment();
			
			if(currentTeamScore == MAX_SCORE) {
				WIN_LIST.add(teamName);
			} else if(currentTeamScore > MAX_SCORE) {
				WIN_LIST.clear();
				MAX_SCORE = currentTeamScore;
				WIN_LIST.add(teamName);
			}
		}
		
		WIN_LIST.sort(Comparator.naturalOrder());
		
		System.out.println(WIN_LIST.get(0));
		
	}
	
	private static void addScore(String name) {
		
		for(int i = 0; i < name.length(); i++) {
			switch(name.charAt(i)) {
			case 'L':
				LOVE_SCORE[0]++;
				break;
			case 'O':
				LOVE_SCORE[1]++;
				break;
			case 'V':
				LOVE_SCORE[2]++;
				break;
			case 'E':
				LOVE_SCORE[3]++;
				break;
			}
		}
		
	}
	
	private static int scoreAdjustment() {
		return ((LOVE_SCORE[0] + LOVE_SCORE[1]) 
				* (LOVE_SCORE[0] + LOVE_SCORE[2]) 
				* (LOVE_SCORE[0] + LOVE_SCORE[3]) 
				* (LOVE_SCORE[1] + LOVE_SCORE[2])
				* (LOVE_SCORE[1] + LOVE_SCORE[3])
				* (LOVE_SCORE[2] + LOVE_SCORE[3]))
				% 100 ;
	}
	
}