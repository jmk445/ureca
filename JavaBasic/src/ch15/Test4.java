package ch15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test4 {
	public static void main(String[] args) {
		//Map은 key의 중복을 허용하지 않고, 이전 value를 덮어 쓴다. 
		Map<String, Integer> map = new HashMap<>();
		map.put("aaa", 50);
		map.put("aaa", 60);
		map.put("aaa", 70);
		map.put("aaa", 80);
		map.put("aaa", 90);
		
		System.out.println(map.size());
		
		
		//keyset을 이용한 순회 (keySet 메소드 사용)
		
		Set<String> keySet = map.keySet();
		Iterator<String> itr = keySet.iterator();
		while(itr.hasNext()) {
			String k = itr.next();
			Integer v = map.get(k);
			System.out.println(k + " " + v);
		}
		
		//백엔드에서 프론트로 grid를 내려줘야하면, map 자료구조를 구현하고 Spring의 기능을 이용해서 보내면 알아서 json형태로 변형해서 보내준다. 
		
	}

}
