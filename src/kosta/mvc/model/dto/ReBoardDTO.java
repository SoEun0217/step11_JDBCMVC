package kosta.mvc.model.dto;

public class ReBoardDTO {
	private int boardNo;
	private String content;
	private int priNo;
	private String reBoardDate;
	
	public ReBoardDTO(){}

	public ReBoardDTO(int boardNo, String content, int priNo, String reBoardDate) {
		super();
		this.boardNo = boardNo;
		this.content = content;
		this.priNo = priNo;
		this.reBoardDate = reBoardDate;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPriNo() {
		return priNo;
	}

	public void setPriNo(int priNo) {
		this.priNo = priNo;
	}

	public String getReBoardDate() {
		return reBoardDate;
	}

	public void setReBoardDate(String reBoardDate) {
		this.reBoardDate = reBoardDate;
	}
	
	@Override
	public String toString() {
		return "¤¤"+boardNo + " | " + content + "|" + priNo + "|" + "|" + reBoardDate;
	}
	
}
