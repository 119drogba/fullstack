package fileex;

import java.io.File;
import java.io.IOException;

public class FileEx05 {

	public static void main(String[] args) throws IOException {

		File f = new File("C:/jwork/Second/fileex/FileEx04.java");
		String fileName = f.getName();
		int pos = fileName.lastIndexOf("."); //FileEx04.java   8
		//lastIndexOf 오른쪽에서 왼쪽

		System.out.println("경로를 제외한 파일이름 - " + f.getName());
		System.out.println("확장자를 제외한 파일이름 - " + fileName.substring(0, pos));   //pos 8-1
		System.out.println("확장자 - " + fileName.substring(pos + 1));

		System.out.println("경로를 포함한 파일이름 - " + f.getPath()); //실질적으로 들어오는 경로
		System.out.println("파일의 절대경로       - " + f.getAbsolutePath());
		System.out.println("파일에 속해 있는 디렉토리 - " + f.getParent());
		System.out.println();

		System.out.println("File.separator - " + File.separator); //String
		System.out.println("File.separatorChar - " + File.separatorChar); //Char
		System.out.println("현재 디렉토리=" + System.getProperty("user.dir"));

	}

}
