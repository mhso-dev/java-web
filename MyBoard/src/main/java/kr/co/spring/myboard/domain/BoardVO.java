package kr.co.spring.myboard.domain;

import java.util.Date;
import lombok.Data;

// VO : 서버가 클라이언트에게 보여줄 데이터를 담아내는 객체
@Data
public class BoardVO {
	// 주의사항
	// 쿼리문의 select 결과물의 컬럼 이름들과 vo의 이름이 일치해야 한다.
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;

	// 댓글 개수를 보여주기 위함
	private Integer replyCnt;
}
