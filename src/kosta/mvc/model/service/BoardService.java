package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.dto.ReBoardDTO;

public interface BoardService {
	/**
	 * ��� ���ڵ� �˻�
	 */
	List<BoardDTO> boardSelectAll() throws SQLException;

	/**
	 * ���� Ư�����ڿ� ������ ���ڵ� �˻�
	 */
	List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException;

	/**
	 * �۹�ȣ�� �ش��ϴ� ���ڵ� �˻�
	 */
	BoardDTO boardSelectByNo(int boardNo) throws SQLException;

	/**
	 * �Խù� ��� 
	 */
	void boardInsert(BoardDTO boardDTO) throws SQLException;

	/**
	 * �Խù� ����
	 */
	void boardUpdate(BoardDTO boardDTO) throws SQLException;

	/**
	 * �Խù� ����
	 */
	void boardDelete(int boardNo) throws SQLException;
	
	List<ReBoardDTO> reboardSelectByNo(int boardNo) throws SQLException;

	void reBoardInsert(ReBoardDTO reBoard) throws SQLException;
	/**
	 * �۹�ȣ�� �ش��ϴ� ��� ���� ��������
	 * */
	BoardDTO replySelectByNo(int boardNo) throws SQLException;
}
