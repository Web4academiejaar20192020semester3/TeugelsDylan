package controller;
import domain.ChatService;
import domain.PersonService;

public class ControllerFactory {
	
    public RequestHandler getController(String key, PersonService personService, ChatService chatService) {
        return createHandler(key, personService, chatService);
    }
    
	private RequestHandler createHandler(String handlerName, PersonService personService, ChatService chatService) {
		RequestHandler handler = null;
		try {
			Class<?> handlerClass = Class.forName("controller."+ handlerName);
			Object handlerObject = handlerClass.newInstance();
			handler = (RequestHandler) handlerObject;
	    	handler.setModel(personService, chatService);
		} catch (Exception e) {
			throw new RuntimeException("Deze pagina bestaat niet!!!!");
		}
		return handler;
	}


}
