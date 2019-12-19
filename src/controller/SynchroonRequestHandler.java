package controller;

import domain.ChatService;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class SynchroonRequestHandler implements RequestHandler {

    private PersonService personService;
    private ChatService chatService;

    public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response) throws IOException;

    public void setModel (PersonService personService, ChatService chatService) {
        this.personService = personService;
        this.chatService = chatService;
    }

    public PersonService getPersonService() { return personService; }

    public ChatService getChatService(){ return chatService;}

}
