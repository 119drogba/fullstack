package com.springbook.component;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component @Scope("prototype") @Lazy
public class LgTV implements TV {
	
	public LgTV() {
		System.out.println("LgTV 객체 생성");
	}
	
	public void powerOn() {
				System.out.println("Lg전원 켜기");
	}

	
	public void powerOff() {
		System.out.println("Lg전원 끄기");
	}

	
	public void volumeUp() {
		System.out.println("Lg볼륨 올리기");
	}

	
	public void volumeDown() {
		System.out.println("Lg볼륨 낮추기");
	}

}
