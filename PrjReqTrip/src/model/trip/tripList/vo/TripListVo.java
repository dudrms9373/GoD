package model.trip.tripList.vo;

public class TripListVo { // 테이블 구성은 멤버번호로 하는게 맞을듯(nickname, id) .리플 넘버로 호출하는 게 나을 듯
	private int      tripNum;    //게시판 번호
	private String   tripAddr;   //주소(지역까지라도 좋음)
	private String   tripTitle;  //제목
	private String   nickName;   //닉네임
	private String   memberId;   //게시자번호
	private String   tripCont;   //내용 - 이부분은 이미지 배치 문제때문에 고민중
	
	private int      readCnt;    //조회수
	private int      like;       //좋아요
	private int      hate;       //싫어요
	private String[] reply;      //댓글
	
	
}
