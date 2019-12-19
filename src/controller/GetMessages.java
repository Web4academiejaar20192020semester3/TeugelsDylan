package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Chat;
import domain.ChatService;
import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetMessages extends AsynchroonRequestHandler {

    Person sender, receiver;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        sender = getPersonService().getPerson(request.getParameter("sender"));
        receiver = getPersonService().getPerson(request.getParameter("receiver"));

        Chat c = getChatService().getChat(sender, receiver);

        try {
            String json = (new ObjectMapper()).writeValueAsString(c.getMessages());
            response.setContentType("application/json");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
