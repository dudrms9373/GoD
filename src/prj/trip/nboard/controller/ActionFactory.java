package prj.trip.nboard.controller;

import prj.trip.nboard.impl.nboardWrite;
import prj.trip.nboard.impl.nboardWriteInsert;
import prj.trip.nboard.impl.nboardView;
import prj.trip.nboard.service.Action;
import prj.trip.nboard.impl.nboardDelete;
import prj.trip.nboard.impl.nboardList;
import prj.trip.nboard.impl.nboardUpdate;

public class ActionFactory {

	public Action getAction(String command) {
		Action action = null;
		
		switch(command){
		case "nboardWrite":
			action = new nboardWrite();
			break;
		case "nboardWriteInsert":
			action = new nboardWriteInsert();
			break;
		case "nboardList":
			action = new nboardList();
			break;
		case "nboardView":
			action = new nboardView();
			break;
		case "nboardUpdate":
			action = new nboardUpdate();
			break;
		case "nboardDelete":
			action = new nboardDelete();
			break;
				
		default: break;
		}
		
		return action;
	}
	
	
}