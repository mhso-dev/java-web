package kr.co.spring.ch02.classes1;

public class BenzEngine extends Engine {

	@Override
	public void turnOn() {
		System.out.println("벤츠 엔진 시동을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("벤츠 엔진 시동을 끕니다.");
	}

}
