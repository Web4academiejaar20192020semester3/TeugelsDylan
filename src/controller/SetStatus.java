package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import db.PersonRepositoryStub;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetStatus extends AsynchroonRequestHandler{
    PersonRepositoryStub p;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String status = request.getParameter("newStatus");

        if(status == null || status.trim().isEmpty()) response.getWriter().write("Empty");
        else ((Person) request.getSession().getAttribute("user")).setStatus(status);
    }
}
