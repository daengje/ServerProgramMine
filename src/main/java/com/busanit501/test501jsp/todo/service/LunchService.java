package com.busanit501.test501jsp.todo.service;

import com.busanit501.test501jsp.todo.dao.LunchDAO;
import com.busanit501.test501jsp.todo.domain.LunchVO;
import com.busanit501.test501jsp.todo.dto.LunchDTO;
import com.busanit501.test501jsp.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@Log4j2
public enum LunchService {
    INSTANCE;

    private LunchDAO lunchDAO;
    private ModelMapper modelMapper;


    LunchService() {
        lunchDAO = new LunchDAO();

        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register2(LunchDTO lunchDTO) throws Exception {
        // DTO -> VO 변환 이 필요함. , 도구 이용법.
        LunchVO lunchVO = modelMapper.map(lunchDTO, LunchVO.class);

        log.info("lunchVO : "+ lunchVO);
        // 실제 디비에도 넣기.
        lunchDAO.insert(lunchVO);
    }
    // 전체 조회
    public List<LunchDTO> listAll() throws Exception {
        // DB -> DAO -> TodoVO -> TodoDTO , 변환.
        // DB : 모델 : TodoVO
        // 화면 : 모델 : TodoDTO
        List<LunchVO> sampleList = lunchDAO.selectAll();
        log.info("LunchService , 확인1, sampleList : " + sampleList);
        List<LunchDTO> sampleDtoList = sampleList.stream()
                .map(vo -> modelMapper.map(vo,LunchDTO.class))
                .collect(Collectors.toList());
        return sampleDtoList;

    }



    public void register(LunchDTO dto) {
        System.out.println("debug register dto 확인중 : " + dto);
    }


    public List<LunchDTO> getList() {

        List<LunchDTO> listSample = IntStream.range(0,10).mapToObj(i -> {
            // 임시 Todo 하나를 의미,
            LunchDTO dto = new LunchDTO();
            dto.setMenuNo((long)i);
            dto.setMenuTitle("Sample Todo Title " + i);
            dto.setMenuRegDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());
        return listSample;
    }
    public List<LunchDTO> getList2() {

        List<LunchDTO> sampleList = new ArrayList<>();

        for (int i = 0; i <10; i++) {
            LunchDTO dto = new LunchDTO();
            dto.setMenuNo((long)i);
            dto.setMenuTitle("Sample Todo Title " + i);
            dto.setMenuRegDate(LocalDate.now());
            sampleList.add(dto);
        }
        return sampleList;
    }
}
