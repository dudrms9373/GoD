package prj.trip.tboard.service;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;



public interface Action {

	public void excute(HttpServletRequest request,
						HttpServletResponse response)
								throws  ServletException, IOException;
	
}
