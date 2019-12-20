package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOut extends SynchroonRequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Person person = (Person) session.getAttribute("user");
		person.setStatus("Offline");
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		return "index.jsp";
	}
	
}
