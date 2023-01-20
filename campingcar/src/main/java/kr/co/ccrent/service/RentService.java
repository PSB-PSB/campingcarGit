package kr.co.ccrent.service;

import java.util.HashMap;
import java.util.List;

import kr.co.ccrent.dto.PageResponseDTO;
import kr.co.ccrent.dto.RentDTO;

public interface RentService {
	String getTime();
	void register(RentDTO rentDTO);
	List<RentDTO> getAll();
	HashMap<String, RentDTO> getByCarId(HashMap<String,Object> varmap);
	RentDTO getOne(int rent_id); 
}
