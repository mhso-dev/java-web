package kr.co.spring.myboard.mapper;

import java.util.List;

import kr.co.spring.myboard.domain.ReplyVO;

public interface ReplyMapper {
	// insert, update, delete를 할 때 성공한 row의 개수를 반환한다.
	public int insert(ReplyVO replyVO);
	// public ReplyVO read(Long rno);
	public List<ReplyVO> getReplyList(Long bno); 
}
