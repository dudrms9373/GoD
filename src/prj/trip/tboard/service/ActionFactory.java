package prj.trip.tboard.service;

public class ActionFactory {

	public Action getAction(String command) {
		Action action = null;
		
		switch(command){
		case "insert":
			action = new InsertUser();
			break;
		default: break;
		}
		
		return action;
	}
	
	
}
