package sdk.support;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class PingServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	public PingServlet(){
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		if(name == "" || name == null){
			name = "Unknown";
		}
		long timestamp = System.currentTimeMillis();
		JSONArray json = new JSONArray();
		try{
			JSONObject jsono = new JSONObject();
			jsono.put("name", name);
			jsono.put("timestamp",timestamp);
			json.put(jsono);
			System.out.println(json.toString());
			response.setContentType("application/json");
			response.setDateHeader("Last-Modified",(System.currentTimeMillis()/1000*1000));
			response.setCharacterEncoding("UTF-8"); 
			response.getWriter().write(json.toString()); 
		}catch(Exception e)
		{
			System.out.println("Error: " + e);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		if(name == "" || name == null){
			name = "Unknown";
		}
		java.sql.Timestamp t = null;
		long timestamp = t.getTime();
		response.setContentType("application/json");
		JSONArray json = new JSONArray();
		try{
			JSONObject jsono = new JSONObject();
			jsono.put("name", name);
			jsono.put("timestamp",timestamp);
			System.out.println(json.toString());
		}catch(Exception e)
		{
			System.out.println("Error: " + e);
		}
	}

}
