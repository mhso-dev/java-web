package kr.co.spring.myboard.test.persistence;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.spring.myboard.domain.ReplyVO;
import kr.co.spring.myboard.mapper.ReplyMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	@Setter(onMethod_= {@Autowired})
	private ReplyMapper mapper;
	
	@Test
	public void testReplyMapperDI() {
		assertNotNull(mapper);
	}
	
	@Test
	public void testReplyList() {
		mapper.getReplyList(3L).forEach(reply -> log.info(reply));
	}
	
	@Test
	public void testReplyInsert() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(4L);
		vo.setBno(3L);
		vo.setReply("ㅎㅎ");
		vo.setReplyer("eclipse");
		
		log.info(mapper.insert(vo) == 1);
		
	}
	
}










