package kr.co.spring.ch03.test.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.spring.ch03.domain.Restaurant;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

// 이 클래스는 테스트 전용 클래스가 되어야 한다.
//  Spring 에서 테스트를 진행 한다.
//   JUnit4 + Spring 설정

@RunWith(SpringJUnit4ClassRunner.class) // JUnit 테스트 환경설정 ( 스프링 환경으로 지정 )

// 환경설정 정보가 담긴 파일을 불러오기
//  * 스프링에서의 환경설정 정보는 결국 Bean을 만들어 내는 설계도
@ContextConfiguration(
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		)
@Log4j // 에러나면 지워요
public class RestaurantTest {

	
//	@Test
//	public void testRestaurant() {
//		
//		// 에러나면 System.out.println 으로 하세요
//		log.info("=== 테스트 시작 ===");
//		
//		// Matching 여부를 확인하는 테스트
//		Restaurant restaurant = new Restaurant("kimbab");
//		
//		// restaurant의 getName이 Bob zip과 똑같은가?
//		assertThat(restaurant.getName(), Is.is("kimbab"));
//		
//		log.info("===  테스트 끝  ===");
//	}
	
	// 실제 제일 중요한 테스트 ( 의존성 주입 테스트 )
	
	@Setter(onMethod_ = {@Autowired})
	private Restaurant restaurant;
	
	// 의존성 주입 테스트 확인
	@Test
	public void testRestaurantDI() {
		assertNotNull(restaurant); // Null이면 오류
		
		// restaurant.setLocation("Seoul");
		
		log.info("-----의존성 주입 테스트-----");
		
		log.info(restaurant);
		
		log.info(restaurant.getLocation());
		log.info(restaurant.getName());
		
		log.info("-----------------------");
	}
}















