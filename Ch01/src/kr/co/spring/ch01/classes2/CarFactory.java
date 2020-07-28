package kr.co.spring.ch01.classes2;

// �ڵ��� ��ü�� �����ϴ� ������ ������ �ϴ� '���丮 Ŭ����' (Container)
//  ���ο��� �ڵ����� ����� �޶�� ��û�� ����, �˸´� �ڵ����� ���� ���ο��� �ڵ����� ����(return) �ϴ� ������ �� ��

// IOC ( Inversion Of Control )�� ����
// Car Ŭ������ ����....
public class CarFactory {

	// CarFactory�� SingleTon���� �����
	private static CarFactory instance = null;
	public static final CarFactory getInstance() {
		
		// ���� ��û�̸� ���Ӱ� ��ü�� �����.
		if (instance == null) {
			instance = new CarFactory();
		}
		// ������ �־��� ��ü�� �����Ѵ�.
		return instance;
	}

	public Car car() {
		// Car�� ���� DI( Dependency Injection )
		return new Car(benzEngine());
	}

	public BenzEngine benzEngine() {
		return new BenzEngine();
	}

}