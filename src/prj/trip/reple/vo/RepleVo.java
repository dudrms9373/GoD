package prj.trip.reple.vo;

public class RepleVo {
	// Fields
	private int    repleNum;	//댓글번호
	private String repleCont;	//댓글내용
	private String repleWriter; //댓글작성자
	private String repledate;   //댓글날짜
	private int    boardNum;    //게시판번호
	// Constructor
	public RepleVo() {}
	public RepleVo(int repleNum, String repleCont, String repleWriter, String repledate, int boardNum) {
		this.repleNum = repleNum;
		this.repleCont = repleCont;
		this.repleWriter = repleWriter;
		this.repledate = repledate;
		this.boardNum = boardNum;
	}
	// Getter / Setter
	public int getRepleNum() {
		return repleNum;
	}
	public void setRepleNum(int repleNum) {
		this.repleNum = repleNum;
	}
	public String getRepleCont() {
		return repleCont;
	}
	public void setRepleCont(String repleCont) {
		this.repleCont = repleCont;
	}
	public String getRepleWriter() {
		return repleWriter;
	}
	public void setRepleWriter(String repleWriter) {
		this.repleWriter = repleWriter;
	}
	public String getRepledate() {
		return repledate;
	}
	public void setRepledate(String repledate) {
		this.repledate = repledate;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	//toString
	@Override
	public String toString() {
		return "RepleVo [repleNum=" + repleNum + ", repleCont=" + repleCont + ", repleWriter=" + repleWriter
				+ ", repledate=" + repledate + ", boardNum=" + boardNum + "]";
	}
}
