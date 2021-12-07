package prj.trip.fboard.controller;

import prj.trip.fboard.impl.FreeBoard;
import prj.trip.fboard.service.Action;

public class ActionFactory {

	public Action getAction(String command) {
		Action action = null;
		
		switch(command){
		
		case "FreeBoard":
			action = new FreeBoard();
			break;
			
			
		default: break;
		}
		
		return action;
	}
	
	
}