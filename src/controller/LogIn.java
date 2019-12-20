package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Person;
import domain.PersonService;

public class LogIn extends SynchroonRequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String destination = "chatApp.jsp";
		List<String> errors = new ArrayList<String>();
		
		String email = request.getParameter("email");
		if (email == null || email.isEmpty()) {
			errors.add("No email given");
		}else{
			request.setAttribute("prevEmail", email);
		}
		
		String password = request.getParameter("password");
		if (password == null || password.isEmpty()) {
			errors.add("No password given");
		}
		
		if (errors.size() == 0) {
			PersonService personService = super.getPersonService();
			Person person = personService.getAuthenticatedUser(email, password);
			if (person != null) {
				createSession(person, request, response);
				person.setStatus("Online");
				response.sendRedirect(request.getContextPath() + "/chatApp.jsp");
			} else {
				errors.add("No valid email/password");
			}
		}
		
		if (errors.size() > 0) {
			request.setAttribute("errors", errors);
			destination = "index.jsp";
		}

		return destination;
	}
	
	private void createSession(Person person, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("user", person);
		session.setMaxInactiveInterval(10);
	}

}
