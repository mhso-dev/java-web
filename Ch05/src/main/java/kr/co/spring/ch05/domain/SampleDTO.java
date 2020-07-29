package kr.co.spring.ch05.domain;

import lombok.Data;

// DTO : Data Transfer Object
// 클라이언트가 서버에게 전송하는 데이터 ( 파라미터 )들을 담기 위한 객체

// * 기본적으로 파라미터의 자료형은 무조건 문자열
// 예전에는 사용자가 파라미터를 원하는 자료형으로 만들기 위해 파싱을 직접 했어야 했다.
// 하지만 스프링에서는 Front Controller가 이러한 파싱 작업을 모두 해준다.

// 변수와 파라미터 키값만 일치한다면 알아서 파싱을 해준다.

@Data
public class SampleDTO {
	private String name;
	private Integer age;
}
