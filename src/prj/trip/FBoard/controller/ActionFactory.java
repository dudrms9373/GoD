package prj.trip.FBoard.controller;

import prj.trip.FBoard.impl.FreeBoard;
import prj.trip.FBoard.service.Action;

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