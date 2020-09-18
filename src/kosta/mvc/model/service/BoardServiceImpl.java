package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.BoardDAO;
import kosta.mvc.model.dao.BoardDAOImpl;
import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.dto.ReBoardDTO;

public class BoardServiceImpl implements BoardService {
	private BoardDAO boardDAO=new BoardDAOImpl();
	
	
	@Override
	public List<BoardDTO> boardSelectAll() throws SQLException {
		List<BoardDTO>list =boardDAO.boardSelectAll();
		if(list==null ) {
			throw new SQLException("�Խù��� �������� �ʽ��ϴ�.");
		}
		return list;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
		List<BoardDTO>list=boardDAO.boardSelectBySubject(keyWord);
		if(list==null) {
			throw new SQLException("�Խù��� �������� �ʽ��ϴ�.");
		}
		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SQLException {
		BoardDTO board=boardDAO.boardSelectByNo(boardNo);
		if(board==null) {
			throw new SQLException("�Խù��� �������� �ʽ��ϴ�.");
		}
		return board;
	}

	@Override
	public void boardInsert(BoardDTO boardDTO) throws SQLException {
		int result = boardDAO.boardInsert(boardDTO);
		if(result==0) throw new SQLException("��Ͻ����Դϴ�.");
		}
		
	
	@Override
	public void boardUpdate(BoardDTO boardDTO) throws SQLException {
		int result=boardDAO.boardUpdate(boardDTO);
		if(result==0) throw new SQLException("���������Դϴ�.");
		}

	@Override
	public void boardDelete(int boardNo) throws SQLException {
		int result=boardDAO.boardDelete(boardNo);
		if(result==0) throw new SQLException("���������Դϴ�");
	}

	@Override
	public List<ReBoardDTO> reboardSelectByNo(int boardNo) throws SQLException {
		List<ReBoardDTO>list=boardDAO.reboardSelectByNo(boardNo);
		if(list==null) {
			throw new SQLException("�������� �ʴ� �۹�ȣ�Դϴ�.");
		}
		return list;
	}

	@Override
	public void reBoardInsert(ReBoardDTO reBoard) throws SQLException {
		int result=boardDAO.reBoardInsert(reBoard);
		if(result==0) {
			throw new SQLException("��Ͻ����Դϴ�.");
		}
	}
	/**
	 * ��۰�������
	 * */
	@Override
	public BoardDTO replySelectByNo(int boardNo) throws SQLException {
		BoardDTO board=boardDAO.replySelectByNo(boardNo);
		if(board==null) {
			throw new SQLException(boardNo+"�� �۹�ȣ�� �� ���Ǿ����ϴ�.");
		}else if(board.getReplyList().size()==0) {
			throw new SQLException(boardNo+"�� ����� �����ϴ�");
			}
		return board;
	}
	
	

}
