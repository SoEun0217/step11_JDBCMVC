package kosta.mvc.model.dto;

import java.util.ArrayList;
import java.util.List;

public class BoardDTO {

	private int boardNo; // 글번호
	private String subject; // 제목
	private String writer; // 작성자
	private String content; // 내용
	private String boardDate; // 등록일
	
	//1:다 의 개념(현재 객체 글번호에 해당하는 댓글 여러개
	private List<ReBoardDTO>replyList=new ArrayList<ReBoardDTO>();	
	
	public BoardDTO() {}

	public BoardDTO(int boardNo, String subject, String writer, String content, String boardDate) {
		super();
		this.boardNo = boardNo;
		this.subject = subject;
		this.writer = writer;
		this.content = content;
		this.boardDate = boardDate;
	}

	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	
	
	public List<ReBoardDTO> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<ReBoardDTO> replyList) {
		this.replyList = replyList;
	}

	@Override
	public String toString() {
		return boardNo + " | " + writer + "|" + subject + "|" + "|" + content + "|" + boardDate;
	}
}
