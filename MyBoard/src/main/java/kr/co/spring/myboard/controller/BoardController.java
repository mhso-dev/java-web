package kr.co.spring.myboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.spring.myboard.domain.BoardVO;
import kr.co.spring.myboard.service.BoardService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	@Setter(onMethod_ = { @Autowired })
	private BoardService service;

	// 게시글 전체 조회 ( /list )
	@GetMapping("/list")
	public void list(Model model) {
		// Model을 사용해서 서버의 데이터를 클라이언트에게 전달해 준다.
		
		model.addAttribute("list", service.getList());
	}
	// 게시글 상세 조회 ( /get )
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
		model.addAttribute("board", service.get(bno));
	}
	
	// 게시글 등록 페이지( /register ) - get방식
	@GetMapping("/register")
	public void register() {}
	
	// 게시글 등록 기능 ( /register ) - post방식
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		log.info("BoardController..... - register " + board);
		service.register(board);
		return "redirect:/board/list";
		
	}

}














