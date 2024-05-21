package com.busanit501.test501jsp.todo.dao;

import com.busanit501.test501jsp.todo.domain.TodoVO;
import com.busanit501.test501jsp.todo.util.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {



    public List<TodoVO> selectAll() throws Exception{
        // 예외 처리 여부를 , throws 진행하기.
        // 디비 연결 하는 순서
        // 1) 연결 하는 도구 Connection 타입의 인스턴스 필요
        // 2) SQL 전달하는 도구 : PreparedStatement 타입의 인스턴스 필요
        // 3) select 할 때는, 조회 결과를 받기 위한 ResultSet 타입의 인스턴스 필요
        // 작업 후, 반납. -> @Cleanup 사용할 예정.
        String sql = "select * from tbl_todo";
        //1)
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        // 디비에서 조회한 데이터 내용들을 담을 임시 List 가 필요함. 여기에 담을 예정.
        List<TodoVO> samples = new ArrayList<TodoVO>();

        while (resultSet.next()){
            // 기존에는 , set 를 이용해서 담는 방법
            // 임시 TodoVO에 담기, -> 다시 임시 목록에 담기.
            // 방법1
//            TodoVO todoVO = new TodoVO();
//            // resultSet.getLong("tno"), 디비에서 조회한 내용.
//            todoVO.setTno(resultSet.getLong("tno"));
//            todoVO.setTitle(resultSet.getString("title"));
//            todoVO.setDueDate(resultSet.getDate("dueDate").toLocalDate());
//            todoVO.setFinished(resultSet.getBoolean("finished"));
//            // 리스트에 담기.
//            samples.add(todoVO);
            // builder 패턴으로 담는 방법.
            // 방법2
            TodoVO todoVOBuilder = TodoVO.builder()
                    .tno(resultSet.getLong("tno"))
                    .title(resultSet.getString("title"))
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .finished(resultSet.getBoolean("finished"))
                    .build();
            // 리스트에 담기.
            samples.add(todoVOBuilder);
        }

        //임시 반환값.
        return samples;
    }
    public TodoVO selectOne(Long tno) throws Exception{
        String sql = "select * from tbl_todo where tno = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1,tno);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();

        resultSet.next();

        TodoVO todoVO = TodoVO.builder()
                .tno(resultSet.getLong("tno"))
                .title(resultSet.getString("title"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .finished(resultSet.getBoolean("finished"))
                .build();

        return todoVO;

    }

    public void insert(TodoVO vo) throws Exception{
        String sql = "insert into tbl_todo (title,dueDate,finished) values(?,?,?);";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,vo.getTitle());
        pstmt.setDate(2, Date.valueOf(vo.getDueDate()));
        pstmt.setBoolean(3,vo.isFinished());
        //int result = pstmt.executeUpdate();
        pstmt.executeUpdate();
    }

    public void delete(Long tno) throws Exception{
        String sql = "delete from tbl_todo where tno = ?;";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1,tno);
        //int result = pstmt.executeUpdate();
        pstmt.executeUpdate();
    }

    public void update(TodoVO todoVO) throws Exception {
        String sql = "update tbl_todo set finished = ?, title = ?, dueDate = ? where tno = ?;";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        // 임시 모델에 담겨진 변경할 데이터의 내용을 가져와서, 디비에 전달 할 예정.
        pstmt.setBoolean(1, todoVO.isFinished());
        pstmt.setString(2, todoVO.getTitle());
        pstmt.setDate(3, Date.valueOf(todoVO.getDueDate()));
        pstmt.setLong(4, todoVO.getTno());
        pstmt.executeUpdate();
    }


    public String getTime2() throws Exception {
     @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
     @Cleanup PreparedStatement pstmt = connection.prepareStatement("select now()");
     @Cleanup ResultSet rs = pstmt.executeQuery();
     rs.next();
     String now = rs.getString(1);
     return "now";
    }
    public String getTime() {
        //Connection conn = ConnectionUtil.INSTANCE.getConnection();
     String now = null;
     try(Connection connection = ConnectionUtil.INSTANCE.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select now()");
         ResultSet rs = pstmt.executeQuery();
     ){
         rs.next();
         now = rs.getString(1);
     }catch(Exception exception){
         exception.printStackTrace();
     }
    return now;
    }


}
