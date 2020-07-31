package kr.co.spring.myboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.spring.myboard.domain.ReplyVO;
import kr.co.spring.myboard.service.ReplyService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/reply/*")
@Log4j
public class ReplyController {
	@Setter(onMethod_ = { @Autowired })
	private ReplyService service;

	@GetMapping(value = "/{bno}")
	public List<ReplyVO> getReplyList(@PathVariable("bno") Long bno) {
		return service.getList(bno);
	}

	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, // 컨트롤러가 클라이언트로 부터 받는 데이터의 타입
												   produces = MediaType.APPLICATION_JSON_UTF8_VALUE) // 컨트롤러가 클라이언트에게 전송하는 데이터의 타입
	public ReplyVO create(@RequestBody ReplyVO replyVO) { // @RequestBody : "문자열 형태로 데이터를 받아서", 자바 Bean으로 바꿔주겠다.
		
		log.info("ReplyController........................ - " + replyVO);
		
		// create( /new )는 문자열로 파라미터를 받을건데, JSON 형식으로 받겠다.
		int insertCount = service.register(replyVO);
		if (insertCount == 1) {
			return replyVO;
		} else {
			return null;
		}
	}

}
