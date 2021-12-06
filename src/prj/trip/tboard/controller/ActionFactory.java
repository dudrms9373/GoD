package prj.trip.tboard.controller;



import prj.trip.tboard.service.Action;
import prj.trip.tboard.service.TBoardWriteAction;


public class ActionFactory {

	public Action getAction(String command) {
		Action action = null;
		
		switch(command){
		case "TBOARDWRITEACTION":
			action = new TBoardWriteAction();
			break;
	
				
		default: break;
		}
		
		return action;
	}
	
	
}
