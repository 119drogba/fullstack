package com.springbook.biz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		//1. Spring 컨테이너를 구동한다. => 스프링빈설정파일의 객체를 생성하여 컨테이너에 담아운다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml","speaker/speakerContext.xml");
		
		//2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup) 한다.
		TV tv = ctx.getBean("tv", TV.class);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		//3. Spring 컨테이너를 종료한다.
		ctx.close();
	}

}