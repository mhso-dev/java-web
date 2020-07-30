package kr.co.spring.myboard.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {

	// 현재 시작 페이지와 마지막 페이지를 저장할 변수
	// ex) startPage가 1이라면 endPage는 10
	private int startPage;
	private int endPage;

	// 현재 사용자가 게시글을 띄운 위치가 처음인지 마지막인지 구분
	private boolean prev, next;

	// 전체 글의 개수
	private int total;

	// 몇 페이지에 몇개의 데이터를 보여줄 것인지를 저장하는 Criteria
	private Criteria cri;

	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;

		// 현재 보고있는 페이지에서 마지막 페이지 번호 구하기
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;

		// 현재 보고 있는 페이지에서 제일 첫 번째 페이지 번호 구하기
		this.startPage = this.endPage - 9;

		// 마지막 페이지에 띄워줄 글의 개수
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

		// endPage는 * 10이 된다.
		// 그러기 때문에 11개의 글이 있더라도 원래는 endPage가 20까지 보여진다.
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}

		// 앞으로가기 버튼을 보여주려면 startPage는 무조건 1보다 커야한다.
		this.prev = this.startPage > 1;

		// 뒤로가기 버튼을 보여주려면 endPage가 realEnd보다 작아야 한다.
		this.next = this.endPage < realEnd;

	}

}
