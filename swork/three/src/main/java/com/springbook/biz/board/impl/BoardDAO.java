package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

@Repository
public class BoardDAO{
	//JDBC관련 변수
	private Connection conn =null;
	private PreparedStatement stmt =null;
	private ResultSet rs =null;
	
	
	//sql명령어들
	private final String BOARD_INSERT = "insert into board(title, writer, content) "
			+ " values( ?, ?, ?)";
//	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) "
//			+ " values( (select nvl(max(seq),0)+1 from board), ?, ?, ?)";
	
	private final String BOARD_UPDATE = "update board set title =?, content=? where seq=? ";
	private final String BOARD_DELETE = "delete from board where seq = ?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	//CRUD 기능의 메소드 구현
	//글등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===>JDBC로 insertBoard() 기능처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			//"insert into board(title, writer, content) "
//			+ " values( ?, ?, ?)";
			stmt.setString(1, vo.getTitle()); //"임시제목2"
			stmt.setString(2, vo.getWriter()); //"홍길동2"
			stmt.setString(3, vo.getContent());   //"임시내용2......"
			int cnt = stmt.executeUpdate();
			if(cnt > 0) System.out.println("글 등록 성공");
			else System.out.println("글 등록 실패");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}  //insertBoard(BoardVO vo)종료 중괄호
	
	//글수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===>JDBC로 updateBoard() 기능처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}//updateBoard(BoardVO vo) 종료 중괄호
	
	//글삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===>JDBC로 deleteBoard() 기능처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//글상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===>JDBC로 getBoard() 기능처리");
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			while(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return board;
	}//getBoard메소드 종료 중괄호
	
	//글목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===>JDBC로 getBoardList() 기능처리");
		List<BoardVO> boardList = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			//"select * from board order by seq desc";
			rs = stmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				boardList.add(board);
			}
		}catch (Exception e) {e.printStackTrace();}
		finally {JDBCUtil.close(rs, stmt, conn);}
		return boardList;
	} //getBoardList 메소드 종료 중괄호

} //BoardDAO클래스 종료 중괄호(끝)