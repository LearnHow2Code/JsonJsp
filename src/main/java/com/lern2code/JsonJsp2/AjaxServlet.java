package com.lern2code.JsonJsp2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AjaxServlet", value = "/AjaxServlet")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String topicName = request.getParameter("topicName");
        if (topicName != null){
            response.setContentType("text/html");
            response.getWriter().write(generateJSONData(topicName));
        }
    }
    public String generateJSONData(String topicName){
        StringBuffer returnData = null;
        if (topicName.equals("java")){
            returnData = new StringBuffer("{\"topic\":{");
            returnData.append("\"name\": \"JAVA\",");
            returnData.append("\"tutorial\": [");
            returnData.append("{\"name\": \"Introduction to Java Sockets\"},");
            returnData.append("{\"name\": \"Introduction to RMI\"},");
            returnData.append("{\"name\": \"Equals Metho\"}]");
            returnData.append("}}");

        } else if (topicName.equals("oodp")){
            returnData = new StringBuffer("{\"topic\":{");
            returnData.append("\"name\": \"Object Oriente Design Patters\",");
            returnData.append("\"tutorial\": [");
            returnData.append("{\"name\": \"Factory Method\"},");
            returnData.append("{\"name\": \"Abstract Factory\"},");
            returnData.append("{\"name\": \"Singleton\"},");
            returnData.append("{\"name\": \"Command\"}]");
            returnData.append("}}");

        } else {
            returnData = new StringBuffer("{\"topic\":{");
            returnData.append("\"name\": \"Topic" +topicName + "\",");
            returnData.append("\"tutorial\": [");
            returnData.append("{\"name\": \"No tutorials found\"}]");
            returnData.append("}}");
        }
        return returnData.toString();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
