package kakao_recommandId;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String id = ".banana1..A¾ß+.";
		System.out.print(id + " -> ");
		System.out.println(solution(id) + "\n");
		
		
		id = "...!@BaT#*..y.abcdefghijklm";
		System.out.print(id + " -> ");
		System.out.println(solution(id) + "\n");
		
		
		id = "z-+.^.";
		System.out.print(id + " -> ");
		System.out.println(solution(id) + "\n");
		
		
		id = "=.=";
		System.out.print(id + " -> ");
		System.out.println(solution(id) + "\n");
		
		
		id = "123_.def";
		System.out.print(id + " -> ");
		System.out.println(solution(id) + "\n");
		
		
		id = "abcdefghijklmn.p";
		System.out.print(id + " -> ");
		System.out.println(solution(id) + "\n");
		
		

	}
	
	public static String solution(String new_id) {
		StringBuilder sb = new StringBuilder();
		ArrayList<String> removeChars = new ArrayList<>();
		
		for(int i = 0; i<new_id.length(); i++) {
			sb.append("\\.");
			if(i >= 1) {
				removeChars.add(sb.toString());
			}
		}
		
		Collections.reverse(removeChars);
		
		//1, 2
		new_id = new_id.toLowerCase().replaceAll("[^[a-z0-9-_.]]", "");
		
		//3
		for(int i = 0; i<removeChars.size(); i++) {
			new_id = new_id.replaceAll(removeChars.get(i), ".");
		}

		//4
		new_id = eraseFirstEndDot(new_id);
		
		//5
		if(new_id.equals("")) 
			new_id = "a";
		
		//6
		if(new_id.length() > 15) {
			new_id = new_id.substring(0, 15);
			new_id = eraseFirstEndDot(new_id);
		}
		
		//7
		if(new_id.length() <= 2) {
			String getEndChar = new_id.substring(new_id.length() - 1, new_id.length());
		
			for(int i = new_id.length(); i<3; i++) {
				new_id = new_id + getEndChar;
			}
			
		}
		
		return new_id;
	}
	
	public static String eraseFirstEndDot(String new_id) {
		if(new_id.startsWith(".")) new_id = new_id.substring(1);
		if(new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length() - 1);
		
		return new_id;
	}

}
