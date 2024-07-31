class Solution {
	public String solution(String s) {
		
		String answer = "";
		
		StringTokenizer st = new StringTokenizer(s, " ");
		ArrayList<Integer> arrList = new ArrayList<>();
		while(st.hasMoreTokens()) {
			arrList.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(arrList);
		
		answer = arrList.get(0) + " " + arrList.get(arrList.size() - 1);
		
		return answer;
	}
}