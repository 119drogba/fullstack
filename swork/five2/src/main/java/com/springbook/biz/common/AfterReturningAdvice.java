package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning = "returnObj")
//	@AfterReturning(pointcut="execution(* com.springbook.biz..*Impl.get*(..))" , returning = "returnObj")
	
	public void afterLog(JoinPoint j, Object returnObj) {

		
		
		String method = j.getSignature().getName();
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName() + "로그인(Admin)");
			}
		}
		System.out.println("[사후처리]" + method + "()메소드 리턴값:" + returnObj);
	}
}
