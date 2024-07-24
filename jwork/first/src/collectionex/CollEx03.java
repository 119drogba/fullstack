package collectionex;

import java.util.ArrayList;

public class CollEx03 {
	public static void prn(ArrayList<String> list) {

		System.out.print("[ ");
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1)
				System.out.print(list.get(i));
			else
				System.out.print(list.get(i) + " , ");

		}
		System.out.println(" ]\n");
	}

	public static void main(String[] args) {

		// ArrayList list = new ArrayList();
		ArrayList<String> list = new ArrayList<String>();
		list.add("사과");
		list.add("수박");
		list.add("귤");
		list.add("딸기");
		list.add("체리");
		list.add("사과");

		prn(list); // 메소드 호출문

		System.out.println(">> 인덱스 2인 위치에 키위 삽입 <<");
		list.add(2, "키위");
		prn(list);
		
//		list.add(9, "멜론"); //에러 : 연속된 인덱스번호가 아님
//		list.add(list.size(),"멜론");
//		prn(list);

		System.out.println(">> 인덱스 4인 위치의 데이터를 포도로 변경 <<");
		list.set(4, "포도");
		prn(list);

		System.out.println(">> 인덱스 1인 위치의 데이터를 제거 <<");
		list.remove(1);
		prn(list);

//		System.out.println(">> 사과 데이터를 찾아서 제거 <<");
//		list.remove("사과");
//		prn(list);
		
		ArrayList<String> removeList = new ArrayList<>();
		removeList.add("사과");
		removeList.add("포도");
		
		list.removeAll(removeList);
		prn(list);

	}

}
