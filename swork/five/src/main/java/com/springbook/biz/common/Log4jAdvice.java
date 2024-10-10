package com.springbook.biz.common;

public class Log4jAdvice {
	public Log4jAdvice() {
		System.out.println("advice객체 생성");
	}
	
	public void printLogging() {
		System.out.println("6. [공통 로그-Log4j]비즈니스 로직 수행 전 동작");
	}
}
