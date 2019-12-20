package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddFriend extends AsynchroonRequestHandler{

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person user = (Person) request.getSession().getAttribute("user");
        String userid = request.getParameter("newFriend");

        if(userid == null || userid.trim().isEmpty()) response.getWriter().write("Empty");
        else{
            Person x = getPersonService().getPerson(userid);
            if(x == null) response.getWriter().write("UserDoesntExist");
            else if(x == user){
                response.getWriter().write("SelfAdd");
            }
            else if(user.isFriend(x)){
                response.getWriter().write("UserIsAlreadyYourFriend");
            }
            else{
                user.addFriend(x);
                x.addFriend(user);
            }
        }
    }
}
