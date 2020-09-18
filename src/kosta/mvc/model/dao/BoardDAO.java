package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.dto.ReBoardDTO;

public interface BoardDAO {
	/**
	 * 레코드 전체검색
	 */
	List<BoardDTO> boardSelectAll() throws SQLException;
	
	/**
	 * 제목에 특정 문자열이 포함된 레코드 검색
	 * select * from board where subject like ?
	 */
	List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException;
	
	/**
	 * 글번호에 해당하는 레코드 검색
	 * select * from board where board_no = ? 
	 */
	BoardDTO boardSelectByNo(int boardNo) throws SQLException;
	
	/**
	 * 게시물 등록하기
	 * insert into board (board_no, subject, writer, content, board_date) 
	 * values (board_seq.nextval, ?, ?, ?, sysdate)
	 */
	int boardInsert(BoardDTO boardDTO) throws SQLException;
	
	/**
	 * 글번호에 해당하는 게시물 내용 수정하기
	 * update board set content = ? where board_no = ?
	 */
	int boardUpdate(BoardDTO boardDTO) throws SQLException;
	
	/**
	 * 글번호에 해당하는 레코드 삭제
	 * delete from board where board_no = ?
	 */
	int boardDelete(int boardNo) throws SQLException;
	
	List<ReBoardDTO> reboardSelectByNo(int boardNO) throws SQLException;

	int reBoardInsert(ReBoardDTO reBoard) throws SQLException;

	BoardDTO replySelectByNo(int boardNo) throws SQLException;
}
