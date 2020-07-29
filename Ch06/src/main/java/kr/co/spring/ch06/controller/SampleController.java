package kr.co.spring.ch06.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.spring.ch06.domain.SampleVO;
import lombok.extern.log4j.Log4j;

// @RestController 형식의 컨트롤러는 항상 클라이언트에게 페이지가 아닌 ( jsp가 아닌 ) 데이터를 준다.

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {
	// Restful Controller는 MIME 타입을 직접 지정해서 클라이언트에게 보여주고자 하는 데이터의 형식을 지정할 수 있습니다.
	// produces 프로퍼티를 활용하여 MIME 타입을 지정합니다.

	// 1) 평문 ( plain text ) -> 일반 문자열
	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}

	// 2) JSON
	// jackson 라이브러리 dependency 추가 필수
	@GetMapping(value = "/getSample")
	public SampleVO getSample() {
		return new SampleVO(123, "AAA", "BBB");
	}

	// 3) 리스트 형태의 JSON 리턴하기 (JSON ARRAY)
	// 리턴형을 List로 만들어 놓으면 된다.
	@GetMapping("/getList")
	public List<SampleVO> getList() {
		// Java 8 스트림 채널 사용하기

		// List에 SampleVO가 10개가 들어있다.
		return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i + "firstName", i + "lastName"))
				.collect(Collectors.toList());
	}

	// RESTFul 방식은 페이지가 아닌 데이터를 전달하는 방식
	// 잘못된 데이터들에 대해서는 잘못 되었다 라는 응답 자체를 따로 해줄 수 있다.
	// 에러 코드를 마음대로 설정해서 사용이 가능하다.

	// ResponseEntity : 응답에 대한 상태코드와 에러 메세지 등을 같이 전달할 수 있다.
	@GetMapping(value = "/check", params = { "height", "weight" })
	public ResponseEntity<SampleVO> check(Double height, Double weight) {

		SampleVO vo = new SampleVO(0, "" + height, "" + weight);

		ResponseEntity<SampleVO> result = null;

		// 에러 및 정상 상황에 대한 비즈니스 로직 작성

		if (height < 150) { // 키가 150 미만이면 비정상적인 상황이라고 가정하기
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}

		return result;
	}

	// @PathVariable
	// URL 형식으로 파라미터 담기
	// 일반 @Controller와 @RestController 모두 지원하지만, RestController에서 사용하는 것이 대중적이다. (
	// 관례 )
	// 보통은 RestFul 방식을 구현하기 위해서 많이 사용합니다.

	// ★★★★★ PathVariable을 사용해서 파라미터를 받을 때는 자바의 기본자료형이 들어갈 수 없습니다. ★★★★★
	// ex) double -> Double
	// int -> Integer

	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid) {

		return new String[] { "category : " + cat, "product : " + pid };
	}

}
	








