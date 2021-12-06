package FBoard.controller;

import FBoard.impl.FreeBoard;

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