package com.springbook.component;

import org.springframework.beans.factory.annotation.Autowired;

public class SamsungTV implements TV {
	
	private Speaker speaker; 
	private int price;
	
	public SamsungTV() {System.out.println("===> Samsung(); 객체 생성");}

	@Autowired
	public void setTwo(Speaker speaker, int price) {
		System.out.println("===> SamsungTV setTwo(speaker,price) 메소드 호출");
		this.speaker = speaker;
		this.price = price;
		
	}
	
	

	@Override
	public void powerOn() {
		System.out.printf("Samsung---전원을 켠다. (가격: %d원) \n",price);
	}
	@Override
	public void powerOff() {
		System.out.println("Samsung---전원을 끈다.");
	}

	@Override
	public void volumeUp() {
		speaker.volumnUp();
		System.out.println("s볼륨 올리기");
	}

	
	public void volumeDown() {
		speaker.volumnDown();
		System.out.println("s볼륨 낮추기");
	}
	
	

}
