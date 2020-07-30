package kr.co.spring.myboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.spring.myboard.domain.BoardVO;
import kr.co.spring.myboard.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	// 스프링 4.3 이상에서 부터는 @Autowired가 없어도 자동으로 주입이 가능하다. 단, 생성자에 BoardMapper가 있어야 한다.
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		mapper.insertSelectKey(board);;
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

}
