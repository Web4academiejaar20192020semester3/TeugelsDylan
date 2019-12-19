package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Chat;
import domain.Message;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SendMessage extends AsynchroonRequestHandler{

    Person sender, receiver;
    String messageString;
    Message message;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        sender = getPersonService().getPerson(request.getParameter("sender"));
        receiver = getPersonService().getPerson(request.getParameter("receiver"));
        messageString = request.getParameter("message");
        message = new Message(sender, messageString);

        Chat chat = getChatService().getChat(sender, receiver);
        chat.setMessage(message);

        try{
            String json = new ObjectMapper().writeValueAsString(chat.getMessages());
            response.setContentType("application/json");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
