package kr.co.ccrent.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import kr.co.ccrent.dto.CarDTO;

public interface CarService {
	String getTime();
	void register(CarDTO carDTO,  MultipartFile[] file, HttpServletRequest request);
	List<CarDTO> getAll();
	CarDTO getOne(int car_regid);
	void modify(CarDTO carDTO);
	void remove(int car_regid);
}
