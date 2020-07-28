package kr.co.spring.ch01.classes1;

// IOC / DI 개념을 단순하게 클래스 개념에만 적용시키는 것이 아닌, 프로젝트 전반적으로 사용할 수 있도록 적용시킨 것 -> Spring Framework
public class Car {
	
	// IOC : 엔진 클래스가 실제 어떠한 클래스인지 모르는 상태에서 엔진 클래스 객체에 대한 생성을 외부에서 진행한다.( new ~~~Engine() )
	private Engine engine;

	// DI  : 외부에서 만들어진 Engine 클래스를 주입 받는 곳( 접점 )
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
