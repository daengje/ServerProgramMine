package com.busanit501.test501jsp.menu.service;

import com.busanit501.test501jsp.menu.dao.MenuDAO;
import com.busanit501.test501jsp.menu.domain.MenuVO;
import com.busanit501.test501jsp.menu.dto.MenuDTO;
import com.busanit501.test501jsp.todo.dto.TodoDTO;
import com.busanit501.test501jsp.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public enum MenuService {
    INSTANCE;

    //준비물), 1) TodoDAO ,인스턴슨 필요
    // 2) DTO <-> VO 간에 변환기 필요, MapperUtil
    private MenuDAO menuDAO;
    private ModelMapper modelMapper;

    //TodoService, 생성자 만들기.
    MenuService() {
        menuDAO = new MenuDAO();
        // 기본 생성자 호출해서, 할당하기. 0x100
        modelMapper = MapperUtil.INSTANCE.get();
    }

    //test
    // 쓰기, 오전에 작업한 모델은 TodoVO,
    // 지금 모델 타입 TodoDTO 을 받아서, 작업 하기 위해서, VO로 변환.
    // modelMapper 이용할 예정.
    // 작성한 데이터의 내용을 담을 임시 모델.TodoDTO
    public void register2(MenuDTO menuDTO) throws Exception {
        // DTO -> VO 변환 이 필요함. , 도구 이용법.
        MenuVO menuVO = modelMapper.map(menuDTO, MenuVO.class);
        // 수동으로 한다면,


        log.info("menuVO : "+ menuVO);

        // 실제 디비에도 넣기.
        menuDAO.insert(menuVO);
    }
    // 전체 조회
    public List<MenuDTO> listAll() throws Exception {
        List<MenuVO> sampleList = menuDAO.selectAll();
        log.info("TodoService , 확인1, sampleList : " + sampleList);
        List<MenuDTO> sampleDtoList = sampleList.stream()
                .map(vo -> modelMapper.map(vo,MenuDTO.class))
                .collect(Collectors.toList());

        return sampleDtoList;

    }

    public void register(TodoDTO dto) {
        System.out.println("debug register dto 확인중 : " + dto);
    }


    public List<MenuDTO> getList() {
        List<MenuDTO> listSample = IntStream.range(0,10).mapToObj(i -> {
            MenuDTO dto = new MenuDTO();
            dto.setMenuNo((long)i);
            dto.setMenuTitle("Sample Todo Title " + i);
            dto.setMenuRegDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());
        return listSample;
    }



}
