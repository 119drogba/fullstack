package com.springbook.biz.common;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	
	@Around("execution(* com.springbook.biz..*Impl.*(..))")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		
//		ProceedingJoinPoint pjp 객체가 담고있는 포인트컷 정보
//		@Override
//		public List<BoardVO> getBoardList(BoardVO vo){
//			return boardDAO.getBoardList(vo);
//		}
//		
		String method = pjp.getSignature().getName(); //getBoardList
		
		
		StopWatch stopWatch = new StopWatch();
		
		System.out.println("스톱워치 시작");
		stopWatch.start();
		
		//실제 포인트컷 메소드가 실행되는 시점
		Object returnObj = pjp.proceed();
		
//		System.out.println("returnObj: ");
//		System.out.println(returnObj);
		
		stopWatch.stop();
		System.out.println("스톱워치 종료");
		System.out.println("[AroundAdvice]" + method+"() 메소드 실행 후 수행에 걸린 시간:" + stopWatch.getTotalTimeMillis()+"(ms)초");
		return returnObj;
	
	}
}
