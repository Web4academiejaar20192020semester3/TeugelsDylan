package controller;

import domain.ChatService;
import domain.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonService personService = new PersonService();
	private ChatService chatService = new ChatService();
	private ControllerFactory controllerFactory = new ControllerFactory();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String destination = "index.jsp";
        RequestHandler handler = null;

		if (action != null) {
			try {
				handler = controllerFactory.getController(action, personService, chatService);
				if (handler instanceof AsynchroonRequestHandler) {
					AsynchroonRequestHandler h = (AsynchroonRequestHandler) handler;
					h.handleRequest(request, response);
				} else if (handler instanceof SynchroonRequestHandler) {
					SynchroonRequestHandler h = (SynchroonRequestHandler) handler;
					destination = h.handleRequest(request, response);
				} else if (handler instanceof SynchroonRedirectRequestHandler) {
					SynchroonRedirectRequestHandler h = (SynchroonRedirectRequestHandler) handler;
					destination = h.handleRequest(request, response);
				}
			} catch (NotAuthorizedException exc) {
				List<String> errors = new ArrayList<String>();
				errors.add(exc.getMessage());
				request.setAttribute("errors", errors);
				destination = "index.jsp";
			}
		}
		if (handler == null || handler instanceof SynchroonRequestHandler) {
			RequestDispatcher view = request.getRequestDispatcher(destination);
			view.forward(request, response);
		}else if(handler instanceof SynchroonRedirectRequestHandler){
			response.sendRedirect(request.getContextPath() + "/" + destination);
		}
	}

}
