package kakao_userBlock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
//https://school.programmers.co.kr/learn/courses/30/lessons/92334 - 신고 결과 받기
	
	public static void main(String[] args) {
		
		String[] list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
		
		//String[] list = {"con", "ryan"};
		//String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int blockedCount = 2;
		
		System.out.println(Arrays.toString(solution(list, report, blockedCount)));
		
	}
	
	public static int[] solution(String[] id_list, String[] report, int k) {
		
		HashMap<String, ArrayList<String>> toReportUser = new LinkedHashMap<>();
		HashMap<String, Integer> getReportUser = new HashMap<>();
			
		for(int i = 0; i<id_list.length; i++) {
			toReportUser.put(id_list[i], new ArrayList<>());
		}

		System.out.println("report " + Arrays.toString(report));
			
			
		for(int i = 0; i<report.length; i++) {
			String getName = report[i].split(" ")[0];
			String getReportedName = report[i].split(" ")[1];
				
			if(!toReportUser.get(getName).contains(getReportedName)) {
				getReportUser.put(getReportedName, getReportUser.getOrDefault(getReportedName, 0) + 1);
				ArrayList<String> temp = new ArrayList<>(toReportUser.get(getName));
					
				temp.add(getReportedName);
					
				toReportUser.put(getName, temp);
			}
				
		}
			
			
		System.out.println("----------");
			
		Iterator<String> it = toReportUser.keySet().iterator();
			
		while(it.hasNext()) {
			String name = it.next();
				
			System.out.println(name + " / " + toReportUser.get(name));
		}
			
		System.out.println("----------");
			
		Iterator<String> it2 = getReportUser.keySet().iterator();

		while(it2.hasNext()) {
			String name = it2.next();
				
			System.out.println(name + " / " + getReportUser.get(name) + "회 먹음");
		}
			
			
		ArrayList<String> isBlocked = new ArrayList<>();
			
		Iterator<String> usersBlocked = getReportUser.keySet().iterator();
		while(usersBlocked.hasNext()) {
			String name = usersBlocked.next();
				
			if(getReportUser.get(name) >= k) {
				isBlocked.add(name);
			}
		}
			
		System.out.println("----------");
			
		usersBlocked = toReportUser.keySet().iterator();
			
		int[] answer = new int[id_list.length];
		for(int i = 0; i<answer.length; i++)
			answer[i] = 0;

		int i = 0;
		while(usersBlocked.hasNext()) {
			String name = usersBlocked.next();
				
			int count = 0;
			for(int ii = 0; ii<isBlocked.size(); ii++) {
				if(toReportUser.get(name).contains(isBlocked.get(ii))) {
					count = count + 1;
				}
					
			}
				
			answer[i] = count;
				
			System.out.println(name + " " + count + "회 안내");
			i++;
		}
			



		return answer;
	}
	
	 public static int[] solution2(String[] id_list, String[] report, int k) {
	        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
	        HashMap<String, Integer> count = new HashMap<>();
	        for (String s : list) {
	            String target = s.split(" ")[1];
	            count.put(target, count.getOrDefault(target, 0) + 1);
	        }

	        return Arrays.stream(id_list).map(_user -> {
	            final String user = _user;
	            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
	            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
	        }).mapToInt(Long::intValue).toArray();
	    }
	
}
