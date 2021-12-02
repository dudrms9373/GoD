package prj.trip.tboard.vo;


import java.util.ArrayList;
import java.util.Arrays;

import prj.trip.comment.vo.CommentVo;

public class TBoardVo { // nickname
	// Fields
	private int     		  tripNum;    //게시판 번호
	private String  		  tripAddr;   //주소(지역까지라도 좋음)
	private String  		  tripTitle;  //제목
	private String  		  nickName;   //닉네임
	private String  		  memberId;   //게시자아이디
	private String   		  write_date; //작성일
	private String  	      tripCont;   //내용 
	private String[]  		  img;		  //이미지
	private String[]   		  video;      //비디오
	private ArrayList<CommentVo>     cmtelist;  //댓글
	
	private int 			   cmtCnt;    //댓글수
	private int                readCnt;    //조회수
	private int                like;       //좋아요
	// Constructor
	public TBoardVo() {}
	public TBoardVo(int tripNum, String tripAddr, String tripTitle, String nickName, String memberId, String write_date,
			String tripCont, String[] img, String[] video, ArrayList<CommentVo> cmtelist, int cmtCnt, int readCnt,
			int like) {
		this.tripNum = tripNum;
		this.tripAddr = tripAddr;
		this.tripTitle = tripTitle;
		this.nickName = nickName;
		this.memberId = memberId;
		this.write_date = write_date;
		this.tripCont = tripCont;
		this.img = img;
		this.video = video;
		this.cmtelist = cmtelist;
		this.cmtCnt = cmtCnt;
		this.readCnt = readCnt;
		this.like = like;
	}
	// Getter / Setter
	public int getTripNum() {
		return tripNum;
	}
	public void setTripNum(int tripNum) {
		this.tripNum = tripNum;
	}
	public String getTripAddr() {
		return tripAddr;
	}
	public void setTripAddr(String tripAddr) {
		this.tripAddr = tripAddr;
	}
	public String getTripTitle() {
		return tripTitle;
	}
	public void setTripTitle(String tripTitle) {
		this.tripTitle = tripTitle;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public String getTripCont() {
		return tripCont;
	}
	public void setTripCont(String tripCont) {
		this.tripCont = tripCont;
	}
	public String[] getImg() {
		return img;
	}
	public void setImg(String[] img) {
		this.img = img;
	}
	public String[] getVideo() {
		return video;
	}
	public void setVideo(String[] video) {
		this.video = video;
	}
	public ArrayList<CommentVo> getCmtlist() {
		return cmtelist;
	}
	public void setCmtlist(ArrayList<CommentVo> cmtelist) {
		this.cmtelist = cmtelist;
	}
	public int getReplCnt() {
		return cmtCnt;
	}
	public void setReplCnt(int cmtCnt) {
		this.cmtCnt = cmtCnt;
	}
	public int getReadCnt() {
		return readCnt;
	}
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	//toString
	@Override
	public String toString() {
		return "TBoardVo [tripNum=" + tripNum + ", tripAddr=" + tripAddr + ", tripTitle=" + tripTitle + ", nickName="
				+ nickName + ", memberId=" + memberId + ", write_date=" + write_date + ", tripCont=" + tripCont
				+ ", img=" + Arrays.toString(img) + ", video=" + Arrays.toString(video) + ", cmtelist=" + cmtelist
				+ ", cmtCnt=" + cmtCnt + ", readCnt=" + readCnt + ", like=" + like + "]";
	}
}
