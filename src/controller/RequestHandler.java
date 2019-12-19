package controller;

import domain.ChatService;
import domain.PersonService;

public interface RequestHandler {

	void setModel(PersonService personService, ChatService chatService);

}
