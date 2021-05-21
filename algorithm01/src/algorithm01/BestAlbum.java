package algorithm01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 프로그래머스 베스트앨범
//스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
	//속한 노래가 많이 재생된 장르를 먼저 수록합니다.
	//장르 내에서 많이 재생된 노래를 먼저 수록합니다.
	//장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
//노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

//제한사항
	//genres[i]는 고유번호가 i인 노래의 장르입니다.
	//plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
	//genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
	//장르 종류는 100개 미만입니다.
	//장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
	//모든 장르는 재생된 횟수가 다릅니다.
public class BestAlbum {

	public static void main(String[] args) {
		BestAlbum bsetAlbum = new BestAlbum();
		int[] dap = bsetAlbum.solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500});
		Arrays.stream(dap).forEach(x -> System.out.println(x));

	}
	public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
        	if(!map.containsKey(genres[i])) {
        		map.put(genres[i], plays[i]);
        	}else {
        		map.put(genres[i], map.get(genres[i])+plays[i]);
        	}
        }
        map.forEach((k, v) -> System.out.println("111 key = "+k+" value = "+v));
        List<String> keySet = new ArrayList<>(map.keySet());	// map 정렬 위해 List에 담고
        keySet.sort((o1, o2) -> map.get(o2) - map.get(o1));		// 내림차순 정렬
//        for (String key : keySet) {
//            System.out.println(String.format("내림차순 Key : %s, Value : %s", key, map.get(key)));
//        }
        List<Integer> idxList = new ArrayList<>();
        for(int i=0; i<keySet.size(); i++) {
//            List<Integer> idxList = new ArrayList<>();
        	Map<Integer, Integer> idxMap = new HashMap<>();
        	for(int j=0; j<genres.length; j++) {
        		if(keySet.get(i).equals(genres[j])) {
        			idxMap.put(j, plays[j]);
        		}
        	}
        	List<Integer> kList = new ArrayList<>(idxMap.keySet());
        	kList.sort((o1, o2) -> idxMap.get(o2) - idxMap.get(o1));
        	if(idxMap.size() > 2) {
        		idxList.add(kList.get(0));
        		idxList.add(kList.get(1));
        	}else {
        		for(int k : kList) {
        			idxList.add(k);
        		}
        	}
        }
        answer = new int[idxList.size()];
        for(int i=0; i<idxList.size(); i++) {
        	answer[i] = idxList.get(i);
        }
        
        return answer;
    }
}