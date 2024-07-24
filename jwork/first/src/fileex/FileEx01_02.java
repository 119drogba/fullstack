package fileex;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileEx01_02 {

	public static void main(String[] args) throws IOException {
		// \r : 캐리지리턴, 그 줄의 처음으로 이동하라는 의미
		// \n : 한 줄 바꿈의 의미
		// \r\n : 개행문자, 다음 줄의 처음으로 이동하라는 의미
		// 기본경로 루트경로 뿌리경로 프로젝트 경로
		String currDir = System.getProperty("user.dir");   //작업디렉토리의 기본경로 가져와 (first)
		System.out.println(currDir);
		File file = new File(currDir + "/test.txt"); //파일생성 클래스
		if (!file.exists())
			file.createNewFile(); //위 경로에 test.txt 파일 존재하니 없으면 만들어

		FileWriter fw = new FileWriter(file); //false 파일이 존재하면 덮어쓰기
		char[] buf = { 'm', 'e', 's', 's', 'a', 'g', 'e' };
		for (int i = 0; i < buf.length; i++)
			fw.write(buf[i]);

		fw.write("이 줄의 마지막에서 개행문자 \r\n");
		fw.close();

		FileReader fr = new FileReader(file); //문자코드로 읽기
		int EOF = -1;
		int c;
		while ((c = fr.read()) != EOF) {   //유니코드 방식으로 하나하나 읽어와라
			System.out.print((char) c);

		}
		fr.close();

	}

}
