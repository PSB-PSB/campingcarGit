package kr.co.ccrent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.ccrent.dto.PageRequestDTO;
import kr.co.ccrent.service.BoardService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/list")
	public void listGET(Model model, PageRequestDTO pageRequestDTO) {
		System.out.println("<Board Controller> list GET");
		model.addAttribute("responseDTO", boardService.getList(pageRequestDTO));
	}
	@GetMapping("/read")
	public void readGET() {
		
	}

}
