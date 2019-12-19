package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetPersons extends AsynchroonRequestHandler{

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        setAccessControlHeaders(response);

        try{
            String json = (new ObjectMapper()).writeValueAsString(super.getPersonService().getPersons());
            response.setContentType("application/json");
            response.getWriter().write(json);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void setAccessControlHeaders(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setHeader("Access-Control-Allow-Methods", "GET");
    }


}

