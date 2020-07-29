package kr.co.spring.ch06.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// VO -> Value Object 또는 Visual Object 
// 서버가 클라이언트에게 전달해주는 ( 어트리뷰트 ), 데이터를 담아낸 객체

// DTO -> Data Transfer Object
// 클라이언트가 서버에게 전달해주는 데이터( 파라미터 )를 담아낸 객체

@Data		// property에 대한 Getter / Setter 설정
@AllArgsConstructor	// 모든 property를 매개변수로 받는 생성자 만들기
@NoArgsConstructor	// 기본 생성자( default constructor )를 만들어주는 역할
public class SampleVO {

	private Integer mno;
	private String firstName;
	private String lastName;
	
}




