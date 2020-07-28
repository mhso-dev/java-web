package kr.co.spring.ch02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.spring.ch02.classes1.Car;
import kr.co.spring.ch02.classes1.CarFactory;

public class Example01 {

	public static void main(String[] args) {
		// 1) CarFactory가 Spring Container에 등록되어 있다
		// 2) Spring Container에 Car를 달라고 요청
		
		// Spring Context를 준비한다. -> Application Context
		//  어노테이션(@)에 의한 설정을 했기 때문에 AnnotationConfigApplicationContext를 불러온다.
		
		//		어떤 공장을 이용할지를 미리 알려준다.
		ApplicationContext context = new AnnotationConfigApplicationContext(CarFactory.class);
		
		Car car = context.getBean("car", Car.class);	// 첫 번째 매개변수는 : 함수명,  두 번째 매개변수는 제네릭 ( 없으면 원하는 타입으로 다운캐스팅 )
		car.start();
		
		
		
	}
	
}
