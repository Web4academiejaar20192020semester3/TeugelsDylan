package controller;
import domain.Person;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SignUp extends SynchroonRequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person user = (Person) request.getSession().getAttribute("user");
        String destination = "index.jsp";

        try{
            List<String> errors = new ArrayList<String>();
            Person person = new Person();

            Helper.setFirstName(errors, person, request);
            Helper.setLastName(errors, person, request);
            Helper.setEmail(errors, person, request);
            Helper.setGender(errors, person, request);
            Helper.setAge(errors, person, request);
            Helper.setPassWord(errors, person, request);

            if(errors.size() > 0){
                request.setAttribute("errors", errors);
                destination = "signUp.jsp";
            }else {
                person.initPerson();
                getPersonService().addPerson(person);
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return destination;
    }
}

