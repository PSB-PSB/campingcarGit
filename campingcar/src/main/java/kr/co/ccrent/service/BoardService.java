package kr.co.ccrent.service;

import java.util.List;

import kr.co.ccrent.dto.BoardDTO;
import kr.co.ccrent.dto.PageRequestDTO;
import kr.co.ccrent.dto.PageResponseDTO;

public interface BoardService {
	List<BoardDTO> getAll(String bo_table);
	PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO);
	
}
