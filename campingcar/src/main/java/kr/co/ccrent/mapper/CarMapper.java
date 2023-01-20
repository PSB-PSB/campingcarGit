package kr.co.ccrent.mapper;

import java.util.List;

import kr.co.ccrent.domain.CarVO;

public interface CarMapper {
	String selectTime();
	void insert(CarVO carVO);
	void update(CarVO carVO);
	void delete(int car_regid);
	List<CarVO> selectAll();
	CarVO selectOne(int car_regid);
}
