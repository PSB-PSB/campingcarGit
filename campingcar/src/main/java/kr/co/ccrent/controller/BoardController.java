package kr.co.ccrent.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.ccrent.dto.BoardDTO;
import kr.co.ccrent.dto.PageRequestDTO;
import kr.co.ccrent.service.BoardService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/register")
	public void register() {
		System.out.println("<Board Controller> register GET");
	}
	@PostMapping("/register")
	public String registerPOST(@RequestParam("file") MultipartFile[] file, RedirectAttributes redirectAttributes, BoardDTO boardDTO) {
		System.out.println("<Board Controller> register POST");
		System.out.println(boardDTO);
		for(MultipartFile multipartFile : file) {
			System.out.println("Upload File Name: "+multipartFile.getOriginalFilename());
		}
		return "redirect:/board/register";
	}
	@PostMapping("/multipartUpload")
	public void mutipartUploadPOST(MultipartFile[] uploadFile) {
		System.out.println("<Board Controller> multipartUpload POST");
		String uploadFolder = "C:\\upload";
		for(MultipartFile multipartFile : uploadFile) {
			System.out.println("Upload File Name: "+multipartFile.getOriginalFilename());
			String uploadFileName = multipartFile.getOriginalFilename();
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			File saveFile = new File(uploadFolder,uploadFileName);
			try {
				multipartFile.transferTo(saveFile);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}			
		}
	}
	@GetMapping("/list")
	public void listGET(Model model, PageRequestDTO pageRequestDTO) {
		System.out.println("<Board Controller> list GET");
		model.addAttribute("responseDTO", boardService.getList(pageRequestDTO));
	}
	@GetMapping("/read")
	public void readGET() {
		
	}

}
