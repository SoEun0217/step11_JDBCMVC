package kosta.mvc.test;

import java.sql.Connection;
import java.util.List;

import kosta.mvc.model.dao.BoardDAO;
import kosta.mvc.model.dao.BoardDAOImpl;
import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.util.DbUtil;

public class TestMain {

	public static void main(String[] args)throws Exception {
		//로드/연결 테스트 시도
		System.out.println("로드/연결 테스트 시도");
		Connection con=DbUtil.getConnection();
		System.out.println("con = "+con);
		
		//dao 테스트
		BoardDAO dao=new BoardDAOImpl();
		
		List<BoardDTO>list	=dao.boardSelectAll();
		for(BoardDTO board:list) {
			System.out.println(board);
		}
		
	
	}

}
