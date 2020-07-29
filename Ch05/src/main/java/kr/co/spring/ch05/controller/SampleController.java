package kr.co.spring.ch05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.spring.ch05.domain.SampleDTO;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	// 특정 url로 요청이 들어왔을 때 컨트롤러가 수행할 메소드를 작성한다.
	// 메소드들은 Front Controller에 의해 실행된다.
	@RequestMapping("")
	public void basic() {
		log.info("--------------------------------");
		log.info("basic..................................");
		log.info("--------------------------------");
	}

	// RequestMapping의 value 매개변수에는 url이 들어간다.
	// method 매개변수에는 통신 방식이 들어간다. ( GET, POST, PUT, DELETE, UPDATE 등등.... )
	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST })
	public void basicRequest() {
		log.info("basic Request...............................");
	}

	// GET이나 POST 중 한가지만 매핑하는 경우 GetMapping, PostMapping을 사용하기도 한다.
	@GetMapping("/basicOnlyGet")
	public void basicGet() {
		log.info("Basic Get Request........................");
	}

	// 클라이언트가 보내는 파라미터를 DTO로 받기
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {

		log.info(dto.toString());
		return "ex01";
	}

	// 파라미터의 키값을 이용해서 명시적으로 파라미터를 받기
	// DTO를 만들지 않아도 될 때
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") Integer age) {

		log.info("name : " + name);
		log.info("age : " + age);

		return "ex02";
	}

	@GetMapping("/ex03")
	public String ex03(Model model) { // Model : 클라이언트 에게 전달할 데이터를 담는 클래스

		// Attribute : 서버가 클라이언트에게 보내는 데이터
		model.addAttribute("name", "YOUR NAME");
		model.addAttribute("age", 30);

		return "ex03";
	}

	// Java Bean의 자동 어트리뷰트 전달
	// SampleDTO 처럼 Property가 있고 Getter / Setter만 존재하는 것들을 의미한다.

	// * Java Bean이 될 수 있는 규칙
	// 1) 생성자에 매개변수가 없어야 한다. ( Default Constructor 만 사용해야 한다. ) public SampleDTO(){}
	// 2) 메소드는 Getter / Setter만 있어야 한다.

	// 결론적으로 Java Bean은 Front Controller에서 자동으로 만들어 주는 존재

	@GetMapping("/ex04")
	public String ex04(SampleDTO sampleDTO, // Java Bean이 파라미터로 넘어오게 되면 addAttribute를 하지 않아도 자동으로 attribute로 등록이 된다.
			@ModelAttribute("page") int page // int 같은 자바 기본 자료형은 반드시 @ModelAttribute를 넣어줘야 attribute로 등록이 된다.
	) {

		log.info("dto : " + sampleDTO);
		log.info("page : " + page);

		return "ex04";
	}

	// 메소드의 리턴 타입이 void 인 경우
	// url의 이름 자체가 jsp 파일 이름이 된다.

	// ex05로 요청하기 위한 url -> /sample/ex05
	// 실제 실행되는 함수 -> ex05_page
	// 보여주는 jsp -> /sample/ex05.jsp
	@GetMapping("/ex05")
	public void ex05_page() {

		log.info("ex05....................");
	}

	// Rest API화 하기
	// @RestController로 컨트롤러 클래스를 만들면 모든 함수가 Rest API화가 되지만, 일반 @Controller에서 Rest
	// API를 만들기 위해서는
	// 메소드명 앞에 @ResponseBody를 붙여주면 된다.

	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("ex06.............................");

		SampleDTO dto = new SampleDTO();
		dto.setName("YOUR NAME");
		dto.setAge(10);

		return dto;
	}

}










