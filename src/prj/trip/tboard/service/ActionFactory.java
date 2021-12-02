package prj.trip.tboard.service;

import prj.trip.tboard.impl.IdCheck;
import prj.trip.tboard.impl.InsertUser;

public class ActionFactory {

	public Action getAction(String command) {
		Action action = null;
		
		switch(command){
		case "insert":
			action = new InsertUser();
			break;
		case "IdCheck":
			action = new IdCheck();
			break;
		default: break;
		}
		
		return action;
	}
	
	
}
