package kr.co.spring.ch01.classes2;

public class AudiEngine extends Engine{

	@Override
	public void turnOn() {
		System.out.println("아우디 엔진으로 시동을 겁니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("아우디 엔진으로 시동을 끕니다.");
	}
	

}
