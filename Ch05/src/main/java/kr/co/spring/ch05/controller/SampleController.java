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

	// Ư�� url�� ��û�� ������ �� ��Ʈ�ѷ��� ������ �޼ҵ带 �ۼ��Ѵ�.
	// �޼ҵ���� Front Controller�� ���� ����ȴ�.
	@RequestMapping("")
	public void basic() {
		log.info("--------------------------------");
		log.info("basic..................................");
		log.info("--------------------------------");
	}

	// RequestMapping�� value �Ű��������� url�� ����.
	// method �Ű��������� ��� ����� ����. ( GET, POST, PUT, DELETE, UPDATE ���.... )
	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST })
	public void basicRequest() {
		log.info("basic Request...............................");
	}

	// GET�̳� POST �� �Ѱ����� �����ϴ� ��� GetMapping, PostMapping�� ����ϱ⵵ �Ѵ�.
	@GetMapping("/basicOnlyGet")
	public void basicGet() {
		log.info("Basic Get Request........................");
	}

	// Ŭ���̾�Ʈ�� ������ �Ķ���͸� DTO�� �ޱ�
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {

		log.info(dto.toString());
		return "ex01";
	}

	// �Ķ������ Ű���� �̿��ؼ� ��������� �Ķ���͸� �ޱ�
	// DTO�� ������ �ʾƵ� �� ��
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") Integer age) {

		log.info("name : " + name);
		log.info("age : " + age);

		return "ex02";
	}

	@GetMapping("/ex03")
	public String ex03(Model model) { // Model : Ŭ���̾�Ʈ ���� ������ �����͸� ��� Ŭ����

		// Attribute : ������ Ŭ���̾�Ʈ���� ������ ������
		model.addAttribute("name", "YOUR NAME");
		model.addAttribute("age", 30);

		return "ex03";
	}

	// Java Bean�� �ڵ� ��Ʈ����Ʈ ����
	// SampleDTO ó�� Property�� �ְ� Getter / Setter�� �����ϴ� �͵��� �ǹ��Ѵ�.

	// * Java Bean�� �� �� �ִ� ��Ģ
	// 1) �����ڿ� �Ű������� ����� �Ѵ�. ( Default Constructor �� ����ؾ� �Ѵ�. ) public SampleDTO(){}
	// 2) �޼ҵ�� Getter / Setter�� �־�� �Ѵ�.

	// ��������� Java Bean�� Front Controller���� �ڵ����� ����� �ִ� ����

	@GetMapping("/ex04")
	public String ex04(SampleDTO sampleDTO, // Java Bean�� �Ķ���ͷ� �Ѿ���� �Ǹ� addAttribute�� ���� �ʾƵ� �ڵ����� attribute�� ����� �ȴ�.
			@ModelAttribute("page") int page // int ���� �ڹ� �⺻ �ڷ����� �ݵ�� @ModelAttribute�� �־���� attribute�� ����� �ȴ�.
	) {

		log.info("dto : " + sampleDTO);
		log.info("page : " + page);

		return "ex04";
	}

	// �޼ҵ��� ���� Ÿ���� void �� ���
	// url�� �̸� ��ü�� jsp ���� �̸��� �ȴ�.

	// ex05�� ��û�ϱ� ���� url -> /sample/ex05
	// ���� ����Ǵ� �Լ� -> ex05_page
	// �����ִ� jsp -> /sample/ex05.jsp
	@GetMapping("/ex05")
	public void ex05_page() {

		log.info("ex05....................");
	}

	// Rest APIȭ �ϱ�
	// @RestController�� ��Ʈ�ѷ� Ŭ������ ����� ��� �Լ��� Rest APIȭ�� ������, �Ϲ� @Controller���� Rest
	// API�� ����� ���ؼ���
	// �޼ҵ�� �տ� @ResponseBody�� �ٿ��ָ� �ȴ�.

	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("ex06.............................");

		SampleDTO dto = new SampleDTO();
		dto.setName("YOUR NAME");
		dto.setAge(10);

		return dto;
	}

}










