package kosta.mvc.view;

import java.util.Scanner;

import kosta.mvc.controller.BoardController;
import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.dto.ReBoardDTO;

public class MenuView {
   static Scanner sc =new Scanner(System.in);
 
   /**
    * 메뉴
    * */
    public static void menuChoice() {
         while(true) {
        	 System.out.println("\n----------------------------------------");
        	 System.out.print("[ 1. 전체검색 ");
        	 System.out.print("2. 글번호에 해당하는 검색 ");
          	System.out.print("3. 제목에 포함된 검색 ");
         	System.out.print("4. 등록 ");
         	System.out.print("5. 수정 ");
         	System.out.print("6. 삭제 ");
         	System.out.print("7. 댓글등록");
         	System.out.print("8. 글번호에 해당하는 댓글검색");
         	System.out.print("9. 종료 ]");

              System.out.println("\n--------------------------------------------");
              System.out.println("선택메뉴는?");
              try {
	              int menu = Integer.parseInt(sc.nextLine());//
	              switch (menu) {
				  case 1:
					  BoardController.boardSelectAll();	
					break;
	               case 2:
	            	   inputBoardByno(); //존재하는 게시물
					break;
	               case 3:
	            	   inputBoardBySubject();
	 				break;
	               case 4:
	            	   inputInsertBoard();
	 				break;
	               case 5:
	    				inputUpdateBoard();
	    				break;
	               case 6:
	            	   inputDeleteBoard();
	    				break;
	               case 7:
	            	   inputInsertReBoard();
	            	   break;
	               case 8:
	            	   inputreboardByno();
	            	   break;
	               case 9:
	            	  System.out.println("다음에 다시 만나요~~^^ 로그아웃됩니다...");
	    			 System.exit(0);	
	    			break;
				default:
					System.out.println("잘못되었습니다..다시 입력해주세요.");
				}
	        	 
              }catch (NumberFormatException e) {
				System.out.println("메뉴는 숫자만 가능합니다.");
			}
         }//while문
    	
    }
    /**
     * 글번호에 해당하는 댓글검색
     * */
    public  static void inputreboardByno() {
    	try {
    		System.out.println("몇번글의 댓글을 보시겠습니까?");
    		int boardNo=Integer.parseInt(sc.nextLine());
    		//BoardController.boardSelectByNo(boardNo);
    		//BoardController.reboardSelectByNo(boardNo);
    		BoardController.replySelectByNo(boardNo);
    	}catch(NumberFormatException e) {
    		System.out.println("글번호는 숫자만 입력해주세요");
    		System.out.println("다시 할래요?  yes or no");
			String choice = sc.nextLine();
			if(choice.equals("yes")) {
				inputreboardByno();
			}
    	}
    }
	/**
     * 2. 글번호 검색...
     * */
     public static void inputBoardByno() {
    	 try {
	    	 System.out.println("글번호는 ???");
	    	 String no = sc.nextLine();
	    	 
	    	 BoardController.boardSelectByNo(Integer.parseInt(no));
    	  }catch (NumberFormatException e) {
			System.out.println("글번호는 숫자만 입력해주세요.");
			System.out.println("다시 할래요?  yes or no");
			String choice = sc.nextLine();
			if(choice.equals("yes")) {
				inputBoardByno();
			}
		 }//catch블럭End
     }//메소드 end
     
     /**
      *  검색필드..검색
      * */
     public static void inputBoardBySubject() {
    	 System.out.println("찾을 문자열은 ???");
    	 String word = sc.nextLine();
    	 BoardController.boardSelectBySubject(word);
     }
    /**
     * 댓글등록
     * */
     public static void inputInsertReBoard() {
    	 System.out.println("몇번글에 댓글을 입력하시겠습니까?");
    	 String no = sc.nextLine();
    	 System.out.println("댓글을입력하세요");
    	 String content=sc.nextLine();
    	 ReBoardDTO reBoard=new ReBoardDTO(0,content,Integer.parseInt(no),null);
    	 BoardController.reBoardInsert(reBoard);
     }
    
    /**
     *  등록
     * */
     public static void inputInsertBoard() {
    	 System.out.println("제목은?");
    	 String subject = sc.nextLine();
    	 
    	 System.out.println("작성자?");
    	 String writer = sc.nextLine();
    	 
    	 System.out.println("내용은?");
    	 String content = sc.nextLine();
    	 
    	 BoardDTO board =  new BoardDTO(0, subject, writer, content, null);
    	 BoardController.boardInsert(board);
     }
     
    /**
     * 수정
     * */
     public static void inputUpdateBoard() {
    	 System.out.println("수정 할 게시물 번호는?");
    	 int no = Integer.parseInt(sc.nextLine());
    	 
    	 System.out.println("수정 내용은?");
    	 String content = sc.nextLine();
    	
    	 BoardDTO board =  new BoardDTO(no, null, null, content, null);
    	 
    	 BoardController.boardUpdate(board);
     }
    
    /**
     * 삭제
     * */
     public static void inputDeleteBoard() {
    	 System.out.println("삭제 게시물 번호는?");
    	 int no = Integer.parseInt(sc.nextLine());
    	 BoardController.boardDelete(no);
     }
}









