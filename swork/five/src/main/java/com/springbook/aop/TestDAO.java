package com.springbook.aop;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository("testDAO")
public class TestDAO {
	public TestDAO() {
		System.out.println("dao객체 생성");
	}

	public int getNum(){
		System.out.println("2. getNum()메소드 호출");
		return 1;
	}
	
	public void intNum(int no) {
		System.out.println("10. intNum()메소드 호출: "+no);
	}
	
	public void setNum(String str, int no) {
		System.out.println("7. setNum()메소드 호출: "+str+", "+no);
	}

}
