package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckChatPartner extends AsynchroonRequestHandler {

    Person sender, receiver;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person sender = getPersonService().getPerson((String) request.getParameter("sender"));
        Person receiver = getPersonService().getPerson(request.getParameter("receiver"));

        if(receiver == null){
            try {
                response.getWriter().write("notInDb");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(!sender.getFriends().contains(receiver)){
            try {
                response.getWriter().write("notAsFriend");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
