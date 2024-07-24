package collectionex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollEx01 {

	public static void main(String[] args) {
		// 리스트 생성
		ArrayList<String> arrList = new ArrayList<String>();

		// 리스트 요소의 저장
		arrList.add("넷");
		arrList.add("둘");
		arrList.add("셋");
		arrList.add("하나");

		//arrList.size() = 4 메소드
		System.out.println("arrList:" + arrList);
		// 리스트 요소의 출력
		//System.out.println(arrList.get(0));
		for (String s : arrList) {
			System.out.println(s);
		}
		arrList.remove(1);  //공간삭제
		// arrList.clear(); //전부삭제 
		
		System.out.println("arrList: " + arrList);
		//System.out.println("arrList방길이:"+arrList.size());
		List<String> lst = new ArrayList<String>();
		
		
		lst.add("alpha");
		lst.add("beta");
		lst.add("charlie");
		System.out.println("1st객체:" + lst);

		// Iterator iter = 1st.iterator();
		Iterator<String> iter = lst.iterator();
// has 가지고있냐? , next로 시작해야 떼어온다.
		while (iter.hasNext()) {
			String str = iter.next();
			System.out.println(str);
		}
		System.out.println("\n===============================\n");
		for (String str : lst) {
			System.out.println(str);
		}
		System.out.println("\n===============================\n");
		for(int i=0; i<lst.size(); i++) {
			System.out.println("인덱스 ["+i+"]"+ lst.get(i));
		}
	}

}


