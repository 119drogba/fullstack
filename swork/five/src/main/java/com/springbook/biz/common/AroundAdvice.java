package com.springbook.biz.common;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.user.UserVO;
public class AroundAdvice {
	//(ProceedingJoinPoint pjp :핵심로직(포인트컷메소드)정보를 담고 있는 객체
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		/* pjp 객체가 담고있는 포인트컷 메소드
		public UserVO login(UserVO vo) {
			System.out.println("포인트컷메소드");
			return dao.login(vo);
		}
		 * */	
		
		Object returnObj = pjp.proceed(); 
		
		System.out.println("[around시점-proceed전 실행]: 비즈니스 메소드 수행 전에 처리할 내용.");
		System.out.println("[around시점-proceed후 실행]: 비즈니스 메소드 수행 후에 처리할 내용.");
		//이 부분이 핵샘로직이 실행(pjp.proceed())되는 시점 
		System.out.print("returnObj: ");
		System.out.println(returnObj);
		return returnObj;
	}
}