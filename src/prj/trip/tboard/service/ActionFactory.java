package prj.trip.tboard.service;

import TBoard.impl.IdCheck;
import TBoard.impl.InsertUser;

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
