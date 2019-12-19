package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SignUp extends SynchroonRequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String destination = "index.jsp";
        List<String> errors = new ArrayList<String>();

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String geslacht = request.getParameter("gender");
        String leeftijd = request.getParameter("age");

        if(firstname == null || firstname.isEmpty()) errors.add("No first name given");
        if(lastname == null || lastname.isEmpty()) errors.add("No last name given");
        if(email == null || email.isEmpty()) errors.add("No email given");
        if(password == null || password.isEmpty()) errors.add("No password given");
        if(!password.equals(password2)) errors.add("Passwords don't match");
        if(geslacht == null || geslacht.isEmpty()) errors.add("No gender given");
        if(leeftijd == null || leeftijd.isEmpty()) errors.add("No age given");

        if(errors.size() == 0){
            Person p = new Person(email, password, firstname, lastname, geslacht, leeftijd);
            PersonService service = super.getPersonService();
            service.addPerson(p);
        }else{
            request.setAttribute("errors", errors);
            destination = "signUp.jsp";
        }

        return destination;
    }
}
