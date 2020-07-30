package kr.co.spring.myboard.mapper;

import java.util.List;

import kr.co.spring.myboard.domain.BoardVO;
import kr.co.spring.myboard.domain.Criteria;

public interface BoardMapper {
	public List<BoardVO> getList();

	// 첫 번째 삽입 방식 => 일반 insert 방식 ( 사전에 키값을 미리 알지 못해요 )
	// => 만약에 글 번호(bno)가 auto_increment에 의해서 들어가는 방식이면 사용할 수 있다.
	public void insert(BoardVO boardVO);

	// 두 번째 삽입 방식 => 키값을 미리 발생 시키고, 그 키값을 VO에 넣어놓고 데이터를 삽입하는 방식
	public void insertSelectKey(BoardVO boardVO);

	// 게시글 상세 조회
	public BoardVO read(Long bno);

	public int delete(Long bno);

	public int update(BoardVO board);

	public int getTotalCount(Criteria cri);

	// 페이징 방식 리스트 보여주기 메소드 추가
	public List<BoardVO> getListWithPaging(Criteria cri);
}
