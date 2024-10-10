package com.springbook.annot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class Samsung implements TV {
//	@Autowired
	@Autowired @Qualifier("sony")
	//@Resource
	//@Resource(name="apple")
	//@Inject
	//@Inject @Named("sony")
	
	private Speaker speaker; 
	
	public Samsung() {System.out.println("===> Samsung(); 객체 생성");}

	

	@Override
	public void powerOn() {
		System.out.printf("SamsungTV---전원을 켠다.");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV---전원을 끈다.");
	}

	@Override
	public void volumeUp() {
		speaker.volumnUp();
		System.out.println("SamsungTV---소리를 올린다.");
	}

	@Override
	public void volumeDown() {
		speaker.volumnDown();
		System.out.println("SamsungTV---소리를 내린다.");
	}
}