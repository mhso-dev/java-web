package kr.co.spring.ch01.classes2;

public class BenzEngine extends Engine {

	@Override
	public void turnOn() {
		System.out.println("���� �������� �õ��� �̴ϴ�.");
	}

	@Override
	public void turnOff() {
		System.out.println("���� �������� �õ��� ���ϴ�.");
	}

}
