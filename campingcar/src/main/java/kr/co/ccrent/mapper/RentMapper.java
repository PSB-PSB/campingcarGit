package kr.co.ccrent.mapper;

import java.util.HashMap;
import java.util.List;

import kr.co.ccrent.domain.RentVO;

public interface RentMapper {
	String selectTime();
	void insert(RentVO rentVO);
	List<RentVO> selectAll();
	List<RentVO> selectByCarId(HashMap<String, Object> varmap);
	RentVO selectOne(int rent_id); // 글 1개 조회
}
