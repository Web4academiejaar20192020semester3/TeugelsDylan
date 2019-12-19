package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.PersonRepositoryStub;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GetStatus extends AsynchroonRequestHandler{

    PersonRepositoryStub p;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        Person person = (Person) request.getSession().getAttribute("user");

        try {
            String json = new ObjectMapper().writeValueAsString(person);
            response.setContentType("application/json");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
