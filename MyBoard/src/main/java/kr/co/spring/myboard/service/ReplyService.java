package kr.co.spring.myboard.service;

import java.util.List;

import kr.co.spring.myboard.domain.ReplyVO;

public interface ReplyService {
	public int register(ReplyVO vo);

	public List<ReplyVO> getList(Long bno);
}
