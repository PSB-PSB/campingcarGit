package kr.co.ccrent.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import kr.co.ccrent.domain.CarVO;
import kr.co.ccrent.dto.CarDTO;
import kr.co.ccrent.mapper.CarMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

	private final CarMapper carMapper;
	private final ModelMapper modelMapper;
	
	@Override
	public String getTime() {
		return carMapper.selectTime();
	}

	@Override
	public void register(CarDTO carDTO) {
		CarVO carVO = modelMapper.map(carDTO, CarVO.class);
		carMapper.insert(carVO);
	}

	@Override
	public List<CarDTO> getAll() {
		List<CarDTO> dtolist = carMapper.selectAll().stream()
				.map(vo -> modelMapper.map(vo, CarDTO.class))
				.collect(Collectors.toList());
		return dtolist;
	}

	@Override
	public CarDTO getOne(int car_regid) {
		CarVO carVO = carMapper.selectOne(car_regid);
		CarDTO carDTO = null;
		if(carVO!=null) {
			carDTO = modelMapper.map(carVO, CarDTO.class);
		}
		return carDTO;
	}

	@Override
	public void modify(CarDTO carDTO) {
		CarVO carVO = modelMapper.map(carDTO, CarVO.class);
		carMapper.update(carVO);
	}

	@Override
	public void remove(int car_regid) {
		carMapper.delete(car_regid);
	}


}
