package controller;

import domain.DomainException;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class Helper {
    public static void setFirstName(List<String> errors, Person person, HttpServletRequest request) {
        try {
            person.setFirstName(request.getParameter("firstname"));
            request.setAttribute("prevFirstName", request.getParameter("firstname"));
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
    }

    public static void setLastName(List<String> errors, Person person, HttpServletRequest request) {
        try {
            person.setLastName(request.getParameter("lastname"));
            request.setAttribute("prevLastName", request.getParameter("lastname"));
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
    }

    public static void setEmail(List<String> errors, Person person, HttpServletRequest request) {
        try {
            person.setUserId(request.getParameter("email"));
            request.setAttribute("prevEmail", request.getParameter("email"));
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
    }

    public static void setGender(List<String> errors, Person person, HttpServletRequest request) {
        try {
            person.setGeslacht(request.getParameter("gender"));
            request.setAttribute("prevGender", request.getParameter("gender"));
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
    }

    public static void setAge(List<String> errors, Person person, HttpServletRequest request) {
        try {
            person.setLeeftijd(request.getParameter("age"));
            request.setAttribute("prevAge", request.getParameter("age"));
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
    }

    public static void setPassWord(List<String> errors, Person person, HttpServletRequest request) {
        try {
            if(!request.getParameter("password").equals(request.getParameter("password2"))) errors.add("Passwords don't match");
            else person.setHashedPassword(request.getParameter("password"));
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
    }


}
