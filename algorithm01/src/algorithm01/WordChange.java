package algorithm01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 프로그래머스 단어 변환
//두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
	//1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
	//2. words에 있는 단어로만 변환할 수 있습니다.
//예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 
//"hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.
//두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
//제한사항
	//각 단어는 알파벳 소문자로만 이루어져 있습니다.
	//각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
	//words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
	//begin과 target은 같지 않습니다.
	//변환할 수 없는 경우에는 0를 return 합니다.
public class WordChange {

//    private static List<String> changeStr = new ArrayList<>();
//    private static List<String> remainWord = new ArrayList<>();
	public static void main(String[] args) {
//		int solution = solution("hit","cog", new String[] {"hot", "dot", "dog", "lot","oit", "log", "cog"});
//		int solution = solution("1234567000","1234567899", new String[] {"1234567800", "1234567890", "1234567899"});
//		int solution = solution("hit","cog", new String[] {"hot", "dot", "dog", "lot", "log"});
		int solution = solution("aaaaaaaaaa","bbbbbbbbbb", new String[] {"aaaaaaaaab", "aaaaaaaabb", "aaaaaaabbb", "aaaaaabbbb", "aaaaabbbbb", "aaaabbbbbb", "aaabbbbbbb", "aabbbbbbbb", "abbbbbbbbb",
				"aaaabaaaaa", "aaaabaaaba", "aaabbaaaab", "babaaabaab", "abbaaaabbb", "bbaabbbbaa", "babaabbbbb", "abbbbbbabb", "babbbbbbbb", "bbabbbbbbb", "bbbabbbbbb"});
		System.out.println("변환하는 가장 짧은 변환 과정 = "+solution);
	}
	public static int solution(String begin, String target, String[] words) {
		int answer = 0;
		Queue<String> beginQ = new LinkedList<>();
		List<String> wordList = new ArrayList<>();
		if(begin.equals(target)){
            return answer;
        }
		for(String w : words) {
			wordList.add(w);
		}
		for(int i=0; i<wordList.size(); i++) {
			for(int j=0; j<begin.length(); j++) {
				StringBuffer word = new StringBuffer(wordList.get(i)).deleteCharAt(j);
	    		StringBuffer str = new StringBuffer(begin).deleteCharAt(j);
	    		if(word.toString().equals(str.toString())) {
	    			beginQ.add(wordList.remove(i));
	    			j = wordList.size() != 0 ? -1 : j;
	    		}
			}
		}
		answer++;
		System.out.println("beginQ = "+beginQ);
		System.out.println("wordList = "+wordList);
		int count = beginQ.size();
		while(beginQ.size() > 0) {
			if(count == 0) {
				answer++;
				count = beginQ.size();
			}
			count--;
//			answer++;
			System.out.println();
			System.out.println("answer = "+answer+" count = "+count+" beginQ = "+beginQ);
			System.out.println();
			String tmpStr = beginQ.poll();
			if(tmpStr.equals(target)) {
				System.out.println("this??? answer = "+answer);
				return answer; 
			}
			for(int i=0; i<wordList.size(); i++) {
				for(int j=0; j<tmpStr.length(); j++) {
					StringBuffer word = new StringBuffer(wordList.get(i)).deleteCharAt(j);
		    		StringBuffer str = new StringBuffer(tmpStr).deleteCharAt(j);
		    		System.out.println("i = "+i+" j = "+j+" tmpStr = "+tmpStr+" wordList.get(i) = "+wordList.get(i));
		    		if(word.toString().equals(str.toString())) {
		    			System.out.println("===같다===");
		    			beginQ.add(wordList.remove(i));
		    			System.out.println("size = "+wordList.size());
		    			if(wordList.size() > 0) {
		    				j = -1;
		    			}else {
		    				break;
		    			}
		    		}
				}
			}
		}
			
		return 0;
	}
	
//	public static int solution(String begin, String target, String[] words) {
//        int answer = 0;
//        
//        List<String> changeStrList = new ArrayList<>();	// 바꿀 문자열 배열
//        List<String> remainWord = new ArrayList<>();	// 바뀐 문자열 배열
//        for(String w : words) {
//        	changeStrList.add(w);
//        }
//        for(int i=0; i<changeStrList.size(); i++) {
//        	for(int j=0; j<begin.length(); j++) {
//	    		StringBuffer word = new StringBuffer(changeStrList.get(i)).deleteCharAt(j);
//	    		StringBuffer str = new StringBuffer(begin).deleteCharAt(j);
//	    		if(word.toString().equals(str.toString())) {
//	    			remainWord.add(changeStrList.get(i));
//	    		}
//        	}
//    	}
//        while(remainWord.size() > 0) {
//        	for(String r : remainWord) {
//        		if(changeStrList.indexOf(r) != -1) {
//            		changeStrList.remove(changeStrList.indexOf(r));
//            		if(r.equals(target)) {
//                		return answer;
//                	}else if(changeStrList.size() == 0) {
//                		return 0 ;
//                	}
//        		}
//        	}
//        	String str = remainWord.remove(0);
//    		
//    		for(int i=0; i<changeStrList.size(); i++) {
//            	for(int j=0; j<str.length(); j++) {
//    	    		StringBuffer word = new StringBuffer(changeStrList.get(i)).deleteCharAt(j);
//    	    		StringBuffer strBuf = new StringBuffer(str).deleteCharAt(j);
//    	    		if(word.toString().equals(strBuf.toString())) {
//    	    			remainWord.add(changeStrList.get(i));
//    	    		}
//            	}
//        	}
//    		answer++;
//        }
//        
//        return answer;
//    }
	

}
