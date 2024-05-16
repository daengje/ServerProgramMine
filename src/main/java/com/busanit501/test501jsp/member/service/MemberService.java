package com.busanit501.test501jsp.member.service;

import com.busanit501.test501jsp.member.DTO.MemberDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum MemberService {

    INSTANCE;

    public List<MemberDTO> getList() {

        java.util.List<com.busanit501.test501jsp.member.DTO.MemberDTO> listSample = IntStream.range(0,10).mapToObj(i -> {
            // 임시 Todo 하나를 의미,
            com.busanit501.test501jsp.member.DTO.MemberDTO dto = new com.busanit501.test501jsp.member.DTO.MemberDTO();
            dto.setMemberNo((long)i);
            dto.setMemberName("Sample Todo Title " + i);
            dto.setDueDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());
        return listSample;

    }

}
