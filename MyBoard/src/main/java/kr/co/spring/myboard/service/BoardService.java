package kr.co.spring.myboard.service;

import java.util.List;

import kr.co.spring.myboard.domain.BoardVO;
import kr.co.spring.myboard.domain.Criteria;

public interface BoardService {
	// 글 등록
	public void register(BoardVO board);
	
	// 글 상세 조회
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);

	public boolean remove(Long bno);

	// public List<BoardVO> getList();

	public List<BoardVO> getList(Criteria cri);

	//추가
	public int getTotal(Criteria cri);
}
