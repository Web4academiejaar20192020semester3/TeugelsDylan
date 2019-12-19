package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;

public class GetUserInfo extends AsynchroonRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request.getParameter("userInfo"));
        Person person = getPersonService().getPerson(request.getParameter("userInfo"));

        try {
            String json = (new ObjectMapper()).writeValueAsString(person);
            response.setContentType("application/json");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
