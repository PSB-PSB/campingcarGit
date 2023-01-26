package kr.co.ccrent.service;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import kr.co.ccrent.domain.BoardFileVO;
import kr.co.ccrent.domain.CarVO;
import kr.co.ccrent.dto.CarDTO;
import kr.co.ccrent.mapper.BoardFileMapper;
import kr.co.ccrent.mapper.CarMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

	private final CarMapper carMapper;
	private final BoardFileMapper boardFileMapper;
	private final ModelMapper modelMapper;
	
	@Override
	public String getTime() {
		return carMapper.selectTime();
	}

	@Override
	public void register(CarDTO carDTO,  MultipartFile[] file, HttpServletRequest request) {
		CarVO carVO = modelMapper.map(carDTO, CarVO.class);
		carMapper.insert(carVO);
		int wr_id = carMapper.selectMaxId();
		String bo_table = "car";
		int i = 0;
		for(MultipartFile multipartFile : file) {
			System.out.println("Upload File Name: "+multipartFile.getOriginalFilename());
			try{
				Long unixtime =  System.currentTimeMillis();
				// 파일 업로드 경로 지정
				String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/data/"+bo_table+"/");
				System.out.println(path);
	            File folder = new File(path);
	            if (!folder.exists()) folder.mkdirs();
	            File destination = new File(path + File.separator + unixtime +"_"+ multipartFile.getOriginalFilename());
	            multipartFile.transferTo(destination);
	            System.out.println(destination);
	            BoardFileVO boardFileVO = BoardFileVO.builder()
	            		.bo_table(bo_table)
	            		.wr_id(wr_id)
	            		.bf_no(i)
	            		.bf_file(multipartFile.getOriginalFilename())
	            		.bf_source(unixtime+"_"+multipartFile.getOriginalFilename())
	            		.build();
	            boardFileMapper.insert(boardFileVO);
	            System.out.println("success!");
	        }catch (Exception e){
	            System.out.println("error!");
	        }
			i++;
		} // end of for		
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
