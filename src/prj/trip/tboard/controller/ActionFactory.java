package prj.trip.tboard.controller;



import prj.trip.tboard.service.Action;
import prj.trip.tboard.service.TBoardListForm;
import prj.trip.tboard.service.TBoardPagingAction;
import prj.trip.tboard.service.TBoardWriteAction;
import prj.trip.tboard.service.TBoardWriteForm;


public class ActionFactory {

	public Action getAction(String command) {
		Action action = null;
		
		switch(command){
		case "TBOARDWRITEFORM": //글쓰기로 이동
			action = new TBoardWriteForm(); 
			break;
		case "TBOARDWRITEACTION": //글쓰기 완료
			action = new TBoardWriteAction();
			break;
		case "TBOARDLISTFORM": //게시판으로 이동
			action = new TBoardListForm();
			break;
		case "BOARDPAGINGACTION": //게시판 페이징
			action = new TBoardPagingAction();
			break;
	
	
				
		default: break;
		}
		
		return action;
	}
	
	
}
