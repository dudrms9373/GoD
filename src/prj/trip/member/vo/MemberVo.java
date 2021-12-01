package memebr.vo;

public class MemberVo {
	private String uid ;
	private String upw ;
	private String uname ;
	private String uemail ;
	private String birth ;
	private String tel ;
	private String gender ;
	public MemberVo(String uid, String upw, String uname, String uemail, String birth, String tel, String gender) {
		super();
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uemail = uemail;
		this.birth = birth;
		this.tel = tel;
		this.gender = gender;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "MemberVo [uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uemail=" + uemail + ", birth=" + birth
				+ ", tel=" + tel + ", gender=" + gender + "]";
	}
	
}
