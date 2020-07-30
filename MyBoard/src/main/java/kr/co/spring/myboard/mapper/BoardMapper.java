package kr.co.spring.myboard.mapper;

import java.util.List;

import kr.co.spring.myboard.domain.BoardVO;

public interface BoardMapper {
	public List<BoardVO> getList(); 
	
	// 첫 번째 삽입 방식 => 일반 insert 방식 ( 사전에 키값을 미리 알지 못해요 )
	//							 => 만약에 글 번호(bno)가 auto_increment에 의해서 들어가는 방식이면 사용할 수 있다.
	public void insert(BoardVO boardVO);
}
