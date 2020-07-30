package kr.co.spring.myboard.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	//Criteria 클래스 : 검색의 조건을 의미하는 클래스
	private int pageNum;
	private int amount;
	
	private int start;
	private int end;
	
	//검색 조건 추가
	private String type;
	//검색어
	private String keyword;
	
		
	public Criteria() {
		this(1, 10);	//기본값은 언제나 1페이지를 보여주도록 할 것임
	}
	
	public Criteria(int pageNum, int amount) {
		
		this.pageNum = pageNum;
		this.amount  = amount;

		this.start = (pageNum-1) * amount;
		this.end   = pageNum * amount;
	}
	
	//각각의 검색 조건 구하기 - TCW
	public String[] getTypeArr() {
		//타입이 없으면 비어있는 문자열 배열을 리턴
		//타입이 있으면 문자열을 하나씩 쪼개서 배열화 시키고 리턴
		return type == null ? new String[] {} : type.split("");
	}
}
