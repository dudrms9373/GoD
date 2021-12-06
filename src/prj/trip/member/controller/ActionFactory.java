package prj.trip.member.controller;

import prj.trip.member.service.Action;
import prj.trip.member.service.IdCheck;
import prj.trip.member.service.InsertUser;
import prj.trip.member.service.Login;
import prj.trip.member.service.LoginOut;

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
