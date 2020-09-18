package kosta.mvc.view;

import java.util.List;

import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.dto.ReBoardDTO;

public class SuccessView {
	public static void selectPrint(List<BoardDTO> list) {
		System.out.println("검색 결과 출력");
		for(BoardDTO board:list) {
			System.out.println(board);
		}
	
		//System.out.println(list);
	}
	
	public static void SelectByNoPrint(BoardDTO board) {
		System.out.println(board);
	}
	public static void messagePrint(String message) {
		System.out.println(message);
	}

	public static void reBoardPrint(List<ReBoardDTO> list) {
		for(ReBoardDTO rDTO:list) {
			System.out.println(rDTO);
		}
		
	}

	/**
	 * 개선된 댓글정보 출력하기
	 * */
	public static void printReplyBoard(BoardDTO board) {
		System.out.println(board);
		System.out.println("댓글 개수 : "+board.getReplyList().size()+"개");
		
		for(ReBoardDTO dto:board.getReplyList()) {
			System.out.println("▶  "+dto);
		}
	}
}
