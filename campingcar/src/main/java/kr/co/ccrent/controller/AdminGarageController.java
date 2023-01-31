package kr.co.ccrent.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import kr.co.ccrent.dto.Criteria;
import kr.co.ccrent.dto.GarageDTO;
import kr.co.ccrent.dto.PageMaker;
import kr.co.ccrent.service.GarageService;

@Controller
public class AdminGarageController {

	@Autowired
	GarageService service;

	// adminlist 페이지 이동
	@GetMapping(value = "/admin/adminlist")
	public String garage_admin() {
		return "/admin/adminlist";
	}
	

	

//	정비소 등록 신청 리스트 전체목록 
	@GetMapping(value = "/admin/garage_admin/garage_reg")
	public ModelAndView garage_reglistAll(Criteria cri, Model model) throws Exception {

		System.out.println("===== list =====");
		ModelAndView mav = new ModelAndView();

		//페이징처리
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.garage_get_regcount(cri));
		model.addAttribute("pageMaker",pageMaker);	
		
		// 기능 수행
		List<GarageDTO> list = service.garage_get_reg(cri);
		mav.addObject("garage_reglist", list);
		mav.setViewName("/admin/garage_admin/garage_reg");
		
				
				
		return mav;
	}


	
	
	
	//정비소 정보수정 이동
	@GetMapping(value="/admin/garage_admin/garage_update")
	public String garage_updatepage(int garage_no, Model model) throws Exception {
		System.out.println("update페이지 접근");
		
		GarageDTO dto = service.garage_modify_get(garage_no); //수정할 garage_no 갖고오기		
		
		model.addAttribute("dto",dto);
	
		return "/admin/garage_admin/garage_update";
	}
	
	//정비소 정보수정 입력폼
	@PostMapping(value = "/admin/garage_admin/garage_update")
	public String garage_update(GarageDTO dto, int garage_no) throws Exception{
		
		
		service.garage_modify(dto);
		System.out.println("===== update =====");
		
		return "redirect:/garage/listcri";
		
	}
		
	//정비소 정보 삭제
	@GetMapping(value="/admin/garage_admin/garage_delete")
	public String garage_remove(int garage_no) {

	
	service.garage_remove(garage_no);
	System.out.println("삭제완료");
	
	return "redirect:/garage/listcri";
}	

	
	
	
	
	
	
}
