package kr.co.ccrent.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.ccrent.dto.CarDTO;
import kr.co.ccrent.service.BoardFileService;
import kr.co.ccrent.service.CarService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

	private final CarService carService;
	private final BoardFileService boardFileService;
	
	@GetMapping("/register")
	public void registerGET(Model model, String car_regid) {
		if(car_regid!=null) {
			System.out.println("<Controller> modify GET ==============================");
			model.addAttribute("dto", carService.getOne(Integer.parseInt(car_regid)));
		}else {
			System.out.println("<Controller> register GET ==============================");
		}
	}
	@PostMapping("/register")
	public String registerPOST(CarDTO carDTO) {
		System.out.println("<Controller> register POST ==============================");
		System.out.println(carDTO);
		// carService.register(carDTO, null, null, null);
		return "redirect:/car/list";

	}
	@PostMapping("/modify")
	public String modifyPOST(CarDTO carDTO) {
		System.out.println("<Controller> modify POST ==============================");
		System.out.println(carDTO);
		// carService.modify(carDTO);
		return "redirect:/car/list";
	}
	@GetMapping("/list")
	public void listGET(Model model) {
		System.out.println("<Controller> list GET ==============================");
		model.addAttribute("time", carService.getTime());
		model.addAttribute("dtolist", carService.getAll());
	}
	@GetMapping("/read")
	public void readGET(Model model, int car_regid) {
		System.out.println("<Controller> read GET ==============================");
		model.addAttribute("dto", carService.getOne(car_regid));
		HashMap<String, Object> fieldmap = new HashMap<>();
		fieldmap.put("bo_table", "car");
		fieldmap.put("wr_id", car_regid);
		model.addAttribute("filelist", boardFileService.getFileList(fieldmap));		
	}
	@PostMapping("/remove")
	public String removePOST(int car_regid) {
		System.out.println("<Controller> remove POST ==============================");
		carService.remove(car_regid);
		return "redirect:/car/list";
	}
	
}
