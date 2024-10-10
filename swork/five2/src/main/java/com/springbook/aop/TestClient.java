package com.springbook.aop;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("testContext.xml");
		TestImpl ts = (TestImpl) container.getBean("testService");
		
		System.out.println("1. getNum()실행 전");
		int i = ts.getNum();
		System.out.println("3. i값은: "+i);
		System.out.println("4. getNum()실행 후\n=================\n");
		
		System.out.println("5. setNum(\"한글창제\", 1446)실행 전");		
		ts.setNum("한글창제", 1446);
		System.out.println("8. setNum(\"한글창제\", 1446)실행 후\n=================\n");
		
		System.out.println("9. intNum(7)실행 전");
		ts.intNum(7);
		System.out.println("11.intNum(7)실행 후\n=================\n");
		
		container.close();
	}

}

