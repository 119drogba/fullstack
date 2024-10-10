package com.kr.co;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		
		/*  GenericXmlApplicationContext
		 * xml기반의 스프링 컨테이너를 구동시키는 기능을 하는 클래스
		 * 컨테이너 안에 스프링 빈 설정파일에 기술되어 있는 로직을 읽어서
		 * 객체를 생성한 후 저장해둠.
		 * 기본 경로 : src/main/resources(classpath:) 폴더 경로까지 자동으로 가지고 있음.
		 */
	
		AbstractApplicationContext ac = new GenericXmlApplicationContext("applicationContext.xml");
		TV tv = (TV) ac.getBean("ltv");
		tv = (TV) ac.getBean("ltv");
		tv = (TV) ac.getBean("ltv");
		
//		TV tv = (TV) ac.getBean("ltv",Lg.class);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		tv = (TV) ac.getBean("http://stv");
		tv = (TV) ac.getBean("http://stv");
		tv = (TV) ac.getBean("http://stv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		ac.close();
		
		
		
		
	}

}