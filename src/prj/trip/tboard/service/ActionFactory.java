package prj.trip.tboard.service;

import prj.trip.tboard.impl.IdCheck;
import prj.trip.tboard.impl.InsertUser;
import TBoard.impl.Login;
import TBoard.impl.LoginOut;

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
		case "Login":
			action = new Login();
			break;
		case "LoginOut":
			action = new LoginOut();
			break;
				
		default: break;
		}
		
		return action;
	}
	
	
}
