package FBoard.controller;

import FBoard.impl.FBLikeCnt;
import FBoard.impl.FBoardClick;
import FBoard.impl.FBoardWrite;
import FBoard.impl.FBoardWriter;
import FBoard.impl.FreeBoard;

public class ActionFactory {

	public Action getAction(String command) {
		Action action = null;
		
		switch(command){
		
		case "FreeBoard":
			action = new FreeBoard();
			break;
		case "FBoardWriter":
			action = new FBoardWriter();
			break;
		case "FBoardWrite":
			action = new FBoardWrite();
			break;
		case "FBoardClick":
			action = new FBoardClick();
			break;
		case "FBLikeCnt":
			action = new FBLikeCnt();
			break;
			
			
		default: break;
		}
		
		return action;
	}
	
	
}