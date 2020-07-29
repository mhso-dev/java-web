package kr.co.spring.test.persistence;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.spring.ch04.mapper.TimeMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	// TimeMapper DI
	@Setter(onMethod_ = {@Autowired})
	private TimeMapper timeMapper;
	
	@Test
	public void checkTimeMapper() {
		assertNotNull(timeMapper);
	}
	
	@Test
	public void testGetTime() {
		log.info(timeMapper.getClass().getName());	// myBatis에 의해서 구현된 클래스의 이름 확인
		log.info(timeMapper.getTime());					// getTime 쿼리 수행 결과 확인
	}
	
	@Test
	public void testGetTime2() {
		log.info("-----------------------------");
		log.info(timeMapper.getTime2());
		log.info("-----------------------------");
	}
	
}





