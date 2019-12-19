package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import db.PersonRepositoryStub;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetStatus extends AsynchroonRequestHandler{
    PersonRepositoryStub p;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        Person person = (Person) request.getSession().getAttribute("user");
        person.setStatus((String)request.getParameter("newStatus"));
    }
}
