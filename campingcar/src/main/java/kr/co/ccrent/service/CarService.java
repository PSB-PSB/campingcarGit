package kr.co.ccrent.service;

import java.util.List;

import kr.co.ccrent.dto.CarDTO;

public interface CarService {
	String getTime();
	void register(CarDTO carDTO);
	List<CarDTO> getAll();
	CarDTO getOne(int car_regid);
	void modify(CarDTO carDTO);
	void remove(int car_regid);
}
