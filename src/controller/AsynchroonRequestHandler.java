package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.ChatService;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AsynchroonRequestHandler implements RequestHandler {

    private PersonService personService;
    private ChatService chatService;

    public abstract void handleRequest (HttpServletRequest request, HttpServletResponse response) throws IOException;

    public void setModel (PersonService personService, ChatService chatService) {
        this.personService = personService;
        this.chatService = chatService;
    }

    public PersonService getPersonService() {
        return personService;
    }

    public ChatService getChatService(){ return chatService;}

}
