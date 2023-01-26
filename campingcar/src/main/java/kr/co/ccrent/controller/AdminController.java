package kr.co.ccrent.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.ccrent.config.DateProcess;
import kr.co.ccrent.dto.BoardDTO;
import kr.co.ccrent.dto.CarDTO;
import kr.co.ccrent.service.BoardFileService;
import kr.co.ccrent.service.CarService;
import kr.co.ccrent.service.RentService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
	
	private final CarService carService;
	private final RentService rentService;
	private final BoardFileService boardFileService;
	private final DateProcess dateProcess;
	
	@GetMapping(value={"/",""})
	public String indexGET() {
		System.out.println("<Admin Controller> index GET");
		return "/admin/index";
	}
	@GetMapping("/car/register")
	public void registerGET(Model model, String car_regid) {
		if(car_regid!=null) {
			System.out.println("<Controller> modify GET ==============================");
			model.addAttribute("dto", carService.getOne(Integer.parseInt(car_regid)));
			HashMap<String, Object> fieldmap = new HashMap<>();
			fieldmap.put("bo_table", "car");
			fieldmap.put("wr_id", car_regid);		
			model.addAttribute("filelist", boardFileService.getFileList(fieldmap));			
			
		}else {
			System.out.println("<Controller> register GET ==============================");
		}
	}
	@PostMapping("/car/register")
	public String registerPOST(CarDTO carDTO, @RequestParam("file") MultipartFile[] file, RedirectAttributes redirectAttributes, HttpServletRequest request) {
		System.out.println("<Admin Controller> register POST");
		System.out.println(carDTO);
		carService.register(carDTO, file, request);
		return "redirect:/admin/car/list";

	}
	@PostMapping("/car/modify")
	public String modifyPOST(CarDTO carDTO) {
		System.out.println("<Controller> modify POST ==============================");
		System.out.println(carDTO);
		carService.modify(carDTO);
		return "redirect:/admin/car/list";
	}	
	@GetMapping("/car/list")
	public void carListGET(Model model) {
		System.out.println("<Admin Controller> car list GET");
		model.addAttribute("dtolist", carService.getAll());
	}
	@GetMapping("/car/read")
	public void carReadGET(Model model, int car_regid) {
		System.out.println("<Controller> read GET ==============================");
		model.addAttribute("dto", carService.getOne(car_regid));
		HashMap<String, Object> fieldmap = new HashMap<>();
		fieldmap.put("bo_table", "car");
		fieldmap.put("wr_id", car_regid);		
		model.addAttribute("filelist", boardFileService.getFileList(fieldmap));
	}
	@PostMapping("/car/remove")
	public String removePOST(int car_regid) {
		System.out.println("<Controller> remove POST ==============================");
		carService.remove(car_regid);
		return "redirect:/admin/car/list";
	}
	/*========================================================================================== 예약 */
	@GetMapping("/rent/calendar")
	public void rentCalendarGET(Model model, String curYear, String curMon) {
		System.out.println("<Admin Controller> rent list GET");
		model.addAttribute("carlist", carService.getAll());
		HashMap<String, Object> datemap = dateProcess.dateCalculate(curYear, curMon, 0); // 현재 년, 월 기준 날짜 계산	
		HashMap<Integer, Object> maplist = new HashMap<>(); // 예약 리스트 맵
		HashMap<String, Object> varmap = new HashMap<>(); // 매개변수 맵 
		List<CarDTO> carlist = carService.getAll(); // 차량 목록 불러오기
		System.out.println(datemap.get("firstday"));
		System.out.println(datemap.get("lastday"));
		for(int i=0; i<carlist.size(); i++) {
			varmap.clear();
			varmap.put("car_regid", carlist.get(i).getCar_regid());
			System.out.println("차번호 : "+carlist.get(i).getCar_regid());
			varmap.put("firstday", datemap.get("firstday"));
			varmap.put("lastday", datemap.get("lastday"));			
			varmap.put("dummy", "1");			
			maplist.put(carlist.get(i).getCar_regid(), rentService.getByCarId(varmap));
		}
		model.addAttribute("maplist", maplist);		
	}
	@GetMapping("/rent/list")
	public void rentListGET(Model model) {
		model.addAttribute("dtolist", rentService.getAll());
	}	
	@GetMapping("/rent/read")
	public void rentReadGET(Model model, int rent_id) {
		model.addAttribute("dto", rentService.getOne(rent_id));
	}
	
}
