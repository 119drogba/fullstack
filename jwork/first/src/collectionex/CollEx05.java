package collectionex;

import java.util.*;

public class CollEx05 {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("one", "하나");
		map.put("two", "둘");
		map.put("three", "셋");
		map.put("four", "넷");
		map.put("five", "다섯");
		// map은 순서가 없다.
		//key는 중복값을 갖을수 있다. value는 중복값을 갖을수 없다.
		// map.size() =5 메소드
		// System.out.println(map.size());
		Set<String> keys = map.keySet();
		for (String s : keys) {
			System.out.printf("key:%s\t value:%s\n", s, map.get(s));
		}
		Iterator<String> iter = keys.iterator();

		while (iter.hasNext()) {
			String key = iter.next();
			System.out.printf("key:%s\t value:%s\n", key, map.get(key));
		}

		Collection<String> value = map.values();
		for(String s : value) {
			System.out.printf("value : %s\n",s);
		}
		
		iter = value.iterator();
		while (iter.hasNext()) {
			System.out.printf("value : %s\n", iter.next());
		}

	}

}
