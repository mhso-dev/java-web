package kr.co.spring.ch02.classes2;

public class Car {
	
	private Engine engine;

	public Car(Engine engine) {
		this.engine = engine;
	}

	public void start() {
		engine.turnOn();
		System.out.println("자동차가 출발합니다.");
	}

	public void stop() {
		System.out.println("자동차가 정지합니다.");
		engine.turnOff();
	}

}
