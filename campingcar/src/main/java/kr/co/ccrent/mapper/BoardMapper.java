package kr.co.ccrent.mapper;

import java.util.List;

import kr.co.ccrent.domain.BoardVO;
import kr.co.ccrent.dto.PageRequestDTO;

public interface BoardMapper {
	List<BoardVO> selectAll(String bo_table);
	List<BoardVO> selectList(PageRequestDTO pageRequestDTO);
	int selectCount(PageRequestDTO pageRequestDTO);
}
