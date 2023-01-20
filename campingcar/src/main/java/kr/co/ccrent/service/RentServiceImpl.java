package kr.co.ccrent.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import kr.co.ccrent.domain.RentVO;
import kr.co.ccrent.dto.RentDTO;
import kr.co.ccrent.mapper.RentMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RentServiceImpl implements RentService {

	private final RentMapper rentMapper;
	private final ModelMapper modelMapper;
	
	@Override
	public String getTime() {
		return rentMapper.selectTime();
	}

	@Override
	public void register(RentDTO rentDTO) {
		RentVO rentVO = modelMapper.map(rentDTO, RentVO.class);
		rentMapper.insert(rentVO);
	}

	@Override
	public List<RentDTO> getAll() {
		List<RentDTO> dtolist = rentMapper.selectAll().stream()
				.map(vo -> modelMapper.map(vo, RentDTO.class))
				.collect(Collectors.toList());
		return dtolist;
	}
	
	@Override
	public HashMap<String, RentDTO> getByCarId(HashMap<String,Object> varmap) {
		
		// car_regid, firstday, lastday로 예약목록 select, dto로 불러오기
		List<RentDTO> dtolist = rentMapper.selectByCarId(varmap).stream()
				.map(vo -> modelMapper.map(vo, RentDTO.class))
				.collect(Collectors.toList());

		// DTO를 키를 날짜(re_startday)로 잡고 해시맵에 넣기
		HashMap<String, RentDTO> resultmap = new HashMap<>();		
		
		
		// 연속 일정에 따른 더미 데이터 처리
		for(int i=0; i<dtolist.size(); i++) {
			// 출고일, 반납일 계산
			Date startday = java.sql.Date.valueOf(dtolist.get(i).getRent_startdate());
			Date endday = java.sql.Date.valueOf(dtolist.get(i).getRent_enddate());
			long Sec = (endday.getTime() - startday.getTime()) / 1000; // 초
			long Min = (endday.getTime() - startday.getTime()) / 60000; // 분
			long Hour = (endday.getTime() - startday.getTime()) / 3600000; // 시
			long Days = Sec / (24*60*60); // 날짜 차이 (일단위)
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			dtolist.get(i).setRent_diffdate(Long.valueOf(Days).intValue());
			dtolist.get(i).setRent_dummy(false);
			resultmap.put(String.valueOf(dtolist.get(i).getRent_startdate()), dtolist.get(i));
			System.out.println(dtolist.get(i).isRent_dummy());
			
			// 더미데이터를 추가할 경우
			if(varmap.get("dummy").equals("1")) {
				if(Days>1) {
					LocalDate startdayLocal = dtolist.get(i).getRent_startdate();
					LocalDate enddayLocal = dtolist.get(i).getRent_enddate();
					for(int j=startdayLocal.getDayOfMonth()+1; j<enddayLocal.getDayOfMonth(); j++) {
						String keydate = String.valueOf(startdayLocal.getYear()+"-"+String.format("%02d",startdayLocal.getMonthValue())+"-"+String.format("%02d", j));
						System.out.println(keydate);
						dtolist.get(i).setRent_dummy(true);
						resultmap.put(keydate, dtolist.get(i));
					}
					System.out.println("더미데이터");
				}
				System.out.println("==============================");
			}
			
		}
		return resultmap;
	}

	@Override
	public RentDTO getOne(int rent_id) {
		RentVO rentVO = rentMapper.selectOne(rent_id);
		RentDTO rentDTO = null; 
		if(rentVO!=null) {
				rentDTO = modelMapper.map(rentVO, RentDTO.class);
		}
		return rentDTO;
	}

}
