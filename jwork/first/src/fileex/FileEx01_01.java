package fileex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileEx01_01 {

	public static void main(String[] args) throws IOException {

		String path = "C:/upload/";
		File file = new File(path);
		if (!file.isDirectory()) {
			file.mkdirs(); // make directory //업로드 폴더 생성
		}
//		 if(!file.exists()) {file.mkdirs();}
		path = path + "/file.txt"; // "C:/upload/file.txt" // 파일생성

		// FileWriter(file, true); true는 뒷 줄에 추가 됨.
		// 디폴트는 false임. false는 덮어쓰기 됨.

		FileWriter fw = new FileWriter(path, true); // 내용을 붙여라
		fw.write("FileWriter는 한글화 된" + "\n");
		fw.write("문자열을 바로 출력할 수 있다." + "\n");
		fw.flush(); 
		fw.close(); //close에는 flush가 숨겨져있다.
		// 닫지 않으면 메모리 누수가 생긴다. 반드시 있어야 한다.

		System.out.println("파일에 저장되었습니다.");

	}

}
