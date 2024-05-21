package com.busanit501.test501jsp.todo.dao;

import com.busanit501.test501jsp.todo.domain.LunchVO;
import com.busanit501.test501jsp.todo.util.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LunchDAO {
    public List<LunchVO> selectAll() throws Exception {

        String sql = "select * from lunchmenu";
        //1)
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        List<LunchVO> samples = new ArrayList<LunchVO>();

        while (resultSet.next()){

            LunchVO lunchVOBuilder = LunchVO.builder()
                    .menuNo(resultSet.getLong("menuNo"))
                    .menuTitle(resultSet.getString("MenuTitle"))
                    .menuRegDate(resultSet.getDate("MenuRegDate").toLocalDate())
                    .build();

            samples.add(lunchVOBuilder);
        }

        return samples;

    }
    public LunchVO selectOne(Long menuNO) throws Exception {
        String sql = "select * from lunchmenu where menuNo=?;";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1,menuNO );
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        resultSet.next();

        LunchVO lunchVO = LunchVO.builder()
                .menuNo(resultSet.getLong("menuNo"))
                .menuTitle(resultSet.getString("menuTitle"))
                .menuRegDate(resultSet.getDate("menuRegDate").toLocalDate())
                .build();
        return lunchVO;
    }

    public void insert(LunchVO lunchVO) throws Exception {
        String sql = "insert into lunchmenu (MenuTitle,MenuRegDate) values(?,?);";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,lunchVO.getMenuTitle());
        pstmt.setDate(2,Date.valueOf(lunchVO.getMenuRegDate()));
        pstmt.executeUpdate();
    }

    public void update(LunchVO VO) throws Exception {
        String sql = "update lunchmenu set  MenuTitle = ? , MenuRegDate=? where menuNo = ?;";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,VO.getMenuTitle());
        pstmt.setDate(2,Date.valueOf(VO.getMenuRegDate()));
        pstmt.setLong(3,VO.getMenuNo());
        pstmt.executeUpdate();
    }

    public void delete(Long menuNo) throws Exception {
        String sql = "delete from lunchmenu where menuNo=?;";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setLong(1,menuNo);
        pstmt.executeUpdate();
    }
}