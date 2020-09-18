package kosta.mvc.controller;

import java.sql.SQLException;

import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.dto.ReBoardDTO;
import kosta.mvc.model.service.BoardService;
import kosta.mvc.model.service.BoardServiceImpl;
import kosta.mvc.view.FailView;
import kosta.mvc.view.SuccessView;

public class BoardController {
	static BoardService service = new BoardServiceImpl();

	public static void boardSelectAll() {
		try {
			SuccessView.selectPrint(service.boardSelectAll());
		} catch (Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void boardSelectBySubject(String keyWord) {
		try {
			SuccessView.selectPrint(service.boardSelectBySubject(keyWord));
		}catch(Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void boardSelectByNo(int boardNo) {
		try {
			SuccessView.SelectByNoPrint(service.boardSelectByNo(boardNo));
		}catch(Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void boardInsert(BoardDTO board) {
		try {
			SuccessView.messagePrint("등록완료되었습니다.");
			service.boardInsert(board);
		}catch(Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void boardUpdate(BoardDTO boardDTO) {
		try {
			SuccessView.messagePrint("수정완료되었습니다.");
			service.boardUpdate(boardDTO);
		}catch(Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void boardDelete(int boardNo) {
		try {
			SuccessView.messagePrint("삭제되었습니다.");
			service.boardDelete(boardNo);
		}catch(Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void reboardSelectByNo(int boardNo) {
		try {
			SuccessView.reBoardPrint(service.reboardSelectByNo(boardNo));
			
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}

	public static void reBoardInsert(ReBoardDTO reBoard) {
		try {
			SuccessView.messagePrint("댓글이 입력되었습니다.");
			service.reBoardInsert(reBoard);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void replySelectByNo(int boardNo) {
		try {
			BoardDTO board=service.replySelectByNo(boardNo);
			SuccessView.printReplyBoard(board);
			
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
