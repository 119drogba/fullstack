package fileex;

import java.io.FileWriter;

public class FileEx01_00 {

	public static void main(String[] args) throws Exception {

		String source = "하늘을 우러러 한 점 부끄러움이 없기를\n" + " 잎새에 이는 바람에도 나는 괴로워했다\n" + " ...\n" + " 오늘 밤에도 별이 바람에 스치운다.\n";
		System.out.println(source.length());
		char intxt[] = new char[source.length()];   //length 키워드 사용
		//지역변수 배열 자동초기화값 = 공백한칸
		

		// getChars(복사할 객체의 시작인덱스번호(int), 복사할객체의 마지막인덱스-1(int),
		// 복사해서 붙여넣기할 객체명, 붙여넣을 객체의 시작 위치 인덱스 번호(int));
		source.getChars(0, source.length(), intxt, 0);  //source = 문자열을 차배열로
		// source.getChars(6, 20, intxt, 5);

		FileWriter fw = new FileWriter("data1.txt"); //파일생성
		//FileWriter = 파일에 문자 기반 데이터를 쓰기 위한 기반
		fw.write(intxt);   //파일내용생성
		// fw.write(source);
		fw.close();

	}

}
