package kakao_numCharAndEng;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "ninenineseven4one";
		System.out.println(solution(s) + "");
		
		
		s = "one4seveneight";
		System.out.println(solution(s) + "");
		
		s = "23four5six7";
		System.out.println(solution(s) + "");
		
		s = "2three45sixseven";
		System.out.println(solution(s) + "");
		
		s = "123";
		System.out.println(solution(s) + "");
		
	}

	
	public static int solution(String s) {
		
		String[] toNum = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		
		for(int i = 0; i<toNum.length; i++) {
			if(s.contains(toNum[i])) {
				s = s.replaceAll(String.valueOf(toNum[i]), String.valueOf(i));
			}
		}
		
		int answer = Integer.parseInt(s);
		return answer;
	}
}
