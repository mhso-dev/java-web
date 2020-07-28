package kr.co.spring.ch01.classes1;

// IOC / DI ������ �ܼ��ϰ� Ŭ���� ���信�� �����Ű�� ���� �ƴ�, ������Ʈ ���������� ����� �� �ֵ��� �����Ų �� -> Spring Framework
public class Car {
	
	// IOC : ���� Ŭ������ ���� ��� Ŭ�������� �𸣴� ���¿��� ���� Ŭ���� ��ü�� ���� ������ �ܺο��� �����Ѵ�.( new ~~~Engine() )
	private Engine engine;

	// DI  : �ܺο��� ������� Engine Ŭ������ ���� �޴� ��( ���� )
	public Car(Engine engine) {
		this.engine = engine;
	}

	public void start() {
		engine.turnOn();
		System.out.println("�ڵ����� ����մϴ�.");
	}

	public void stop() {
		System.out.println("�ڵ����� �����մϴ�.");
		engine.turnOff();
	}

}
