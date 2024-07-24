package fileex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class FileEx07 {
//Stream을 보면 바이트화
	public static void main(String[] args) {
		try {
			OutputStream output = new FileOutputStream("C:/jwork/Output.txt");  // C:/jwork/Output.txt 파일 생성
			String str = "오늘 날씨는 아주 덥습니다.";	//문자열 객체만 생성								// 있으면 덮어쓰기
			byte[] by = str.getBytes(); //getBytes 메소드 바이트 코드화 배열 객체로 생성

			output.write(by);
			output.close();

			FileInputStream fis = new FileInputStream("C:/jwork/Output.txt");
			InputStreamReader isr = new InputStreamReader(fis); //StreamReader - 바이트를 문자화
			int c;												//
			while ((c = isr.read()) != -1) {
				System.out.print((char) c);
			}
			isr.close();
			fis.close();

			System.out.println();
			System.out.println("작업 완료\n");
		} catch (Exception e) {
			e.getStackTrace();
		}
		System.out.println("프로그램 종료");

	}

}
