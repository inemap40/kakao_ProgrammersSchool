package kakao_lotto;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_value = {31, 10, 45, 1, 6, 19};
		
		//int[] lottos = {0, 0, 0, 0, 0, 0};
		//int[] win_value = {38, 19, 20, 40, 15, 25};
		
		//int[] lottos = {45, 4, 35, 20, 3, 9};
		//int[] win_value = {20, 9, 3, 45, 4, 35};

		solution(lottos, win_value);
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
		
		int[] answer = new int[2];
		
		int sameCount = 0;
		int blankCount = 0;
		
		ArrayList<Integer> lottosTemp = new ArrayList<>();
		for(int i = 0; i<lottos.length; i++) {
			lottosTemp.add(lottos[i]);
			
			if(lottos[i] == 0) {
				blankCount = blankCount + 1;
			}
		}
		
		for(int i = 0; i<win_nums.length; i++) {
			if(lottosTemp.contains(win_nums[i])) {
				sameCount = sameCount + 1;
			}
			
		}
		
		
		answer[1] = calculateRank(sameCount);
		
		System.out.println("µ¿ÀÏÇÑ °¹¼ö: " + sameCount + "\nÃÖÀúµî¼ö: " + calculateRank(sameCount));
		System.out.println("----------");
		
		
		if(sameCount != 6) {
			
			answer[0] = calculateRank(sameCount + blankCount);

			System.out.println("ºó °¹¼ö: " + blankCount + "\nÃÖ°íµî¼ö: " + answer[0]);
			System.out.println("----------");
		}
		else {
			for(int i = 0; i<answer.length; i++) answer[i] = 1;
		}
		
		System.out.println(Arrays.toString(answer));
		
		
		return answer;
	}
	
	public static int calculateRank(int sameCount) {
		int[] rank = {6, 5, 4, 3, 2};
		int result = 0;
		
		for(int i = 0; i<rank.length; i++) {
			if(sameCount == rank[i]) result = i + 1;
			else if(sameCount < rank[rank.length - 1]) result = i + 2;
		}
		
		return result;
	}

}




