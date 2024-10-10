package com.springbook.biz;

public class Samsung implements TV {
	
	private Speaker speaker; 
	private int price;
	
	public Samsung() {System.out.println("===> Samsung(); 객체 생성");}

	public Samsung(Speaker speaker) {
		System.out.println("===> SamsungTV(speaker) 객체 생성");
		this.speaker = speaker;
	}
	
	public Samsung(Speaker speaker, int price) {
		System.out.println("===> Samsung(speaker,price) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void powerOn() {
		System.out.printf("Samsung---전원을 켠다. (가격: %d원) \n",price);
	}

	public void powerOff() {
		System.out.println("Samsung---전원을 끈다.");
	}

	
	public void volumeUp() {
		speaker.volumnUp();
		System.out.println("s볼륨 올리기");
	}

	
	public void volumeDown() {
		speaker.volumnDown();
		System.out.println("s볼륨 낮추기");
	}
	
	

}
