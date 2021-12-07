package prj.trip.FBoard.controller;

import prj.trip.FBoard.impl.FBLikeCnt;
import prj.trip.FBoard.impl.FBoardClick;
import prj.trip.FBoard.impl.FBoardWrite;
import prj.trip.FBoard.impl.FBoardWriter;
import prj.trip.FBoard.impl.FreeBoard;

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
