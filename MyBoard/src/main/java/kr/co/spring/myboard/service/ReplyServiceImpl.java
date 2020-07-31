package kr.co.spring.myboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.spring.myboard.domain.ReplyVO;
import kr.co.spring.myboard.mapper.ReplyMapper;
import lombok.Setter;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Setter(onMethod_= {@Autowired})
	private ReplyMapper mapper;
	
	@Override
	public List<ReplyVO> getList(Long bno) {
		return mapper.getReplyList(bno);
	}

	@Override
	public int register(ReplyVO vo) {
		return mapper.insert(vo);
	}

}
