package kr.co.ccrent.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import kr.co.ccrent.domain.BoardVO;
import kr.co.ccrent.dto.BoardDTO;
import kr.co.ccrent.dto.PageRequestDTO;
import kr.co.ccrent.dto.PageResponseDTO;
import kr.co.ccrent.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardMapper boardMapper;
	private final ModelMapper modelMapper;
	
	@Override
	public List<BoardDTO> getAll(String bo_table) {
		List<BoardDTO> dtolist = boardMapper.selectAll(bo_table).stream()
				.map(vo -> modelMapper.map(vo, BoardDTO.class))
				.collect(Collectors.toList());
		return dtolist;
		
	}

	@Override
	public PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO) {
		pageRequestDTO.setBo_table("write_"+pageRequestDTO.getBo_table());
		List<BoardVO> volist = boardMapper.selectList(pageRequestDTO);
		List<BoardDTO> dtolist = volist.stream()
				.map(vo -> modelMapper.map(vo, BoardDTO.class))
				.collect(Collectors.toList());
		int total = boardMapper.selectCount(pageRequestDTO);
		PageResponseDTO<BoardDTO> pageResponseDTO = PageResponseDTO.<BoardDTO>withAll()
				.dtoList(dtolist)
				.total(total)
				.pageRequestDTO(pageRequestDTO)
				.build();
		return pageResponseDTO;
	}

}
