package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddFriend extends AsynchroonRequestHandler{

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        HttpSession session = request.getSession();
        Person user = (Person) session.getAttribute("user");
        PersonService service = super.getPersonService();

        String userid = (String) request.getParameter("newFriend");
        Person x = service.getPerson(userid);

        if(x != null && x != user && !user.isFriend(x)){
            user.addFriend(x);
            x.addFriend(user);
        }
    }
}
