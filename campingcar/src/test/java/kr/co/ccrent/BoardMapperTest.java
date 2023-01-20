package kr.co.ccrent;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import kr.co.ccrent.domain.BoardVO;
import kr.co.ccrent.dto.PageRequestDTO;
import kr.co.ccrent.mapper.BoardMapper;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {
	
	@Autowired
	private BoardMapper boardMapper;
	
	// @Test
	public void selectAllTest() {
		List<BoardVO> volist = boardMapper.selectAll("write_free");
		volist.forEach(vo -> System.out.println(vo));
	}
	
	@Test
	public void selectListTest() {
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
				.bo_table("write_free")
				.page(1)
				.size(10)
				.build();
		List<BoardVO> volist = boardMapper.selectList(pageRequestDTO);
		volist.forEach(vo -> System.out.println(vo));
	}
}
