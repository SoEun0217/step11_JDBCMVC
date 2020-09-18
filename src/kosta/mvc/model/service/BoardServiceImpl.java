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
			throw new SQLException("게시물이 존재하지 않습니다.");
		}
		return list;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
		List<BoardDTO>list=boardDAO.boardSelectBySubject(keyWord);
		if(list==null) {
			throw new SQLException("게시물이 존재하지 않습니다.");
		}
		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SQLException {
		BoardDTO board=boardDAO.boardSelectByNo(boardNo);
		if(board==null) {
			throw new SQLException("게시물이 존재하지 않습니다.");
		}
		return board;
	}

	@Override
	public void boardInsert(BoardDTO boardDTO) throws SQLException {
		int result = boardDAO.boardInsert(boardDTO);
		if(result==0) throw new SQLException("등록실패입니다.");
		}
		
	
	@Override
	public void boardUpdate(BoardDTO boardDTO) throws SQLException {
		int result=boardDAO.boardUpdate(boardDTO);
		if(result==0) throw new SQLException("수정실패입니다.");
		}

	@Override
	public void boardDelete(int boardNo) throws SQLException {
		int result=boardDAO.boardDelete(boardNo);
		if(result==0) throw new SQLException("삭제실패입니다");
	}

	@Override
	public List<ReBoardDTO> reboardSelectByNo(int boardNo) throws SQLException {
		List<ReBoardDTO>list=boardDAO.reboardSelectByNo(boardNo);
		if(list==null) {
			throw new SQLException("존재하지 않는 글번호입니다.");
		}
		return list;
	}

	@Override
	public void reBoardInsert(ReBoardDTO reBoard) throws SQLException {
		int result=boardDAO.reBoardInsert(reBoard);
		if(result==0) {
			throw new SQLException("등록실패입니다.");
		}
	}
	/**
	 * 댓글가져오기
	 * */
	@Override
	public BoardDTO replySelectByNo(int boardNo) throws SQLException {
		BoardDTO board=boardDAO.replySelectByNo(boardNo);
		if(board==null) {
			throw new SQLException(boardNo+"는 글번호가 잘 못되었습니다.");
		}else if(board.getReplyList().size()==0) {
			throw new SQLException(boardNo+"의 댓글이 없습니다");
			}
		return board;
	}
	
	

}
