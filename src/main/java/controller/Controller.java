package controller;

import domain.service.MealService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private MealService service = MealService.getInstance();
    private HandlerFactory handlerFactory = new HandlerFactory();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");

        if (command == null) {
            command = "Index";
        }

        String destination;

        try {
            RequestHandler handler = handlerFactory.getHandler(command);
            destination = handler.handleRequest(request, response);
        } catch (Exception e) {
            System.out.println(e.getStackTrace()[0] + " : " + e.getMessage());
            request.setAttribute("error", e.getMessage());
            destination = "error.jsp";
        }

        request.getRequestDispatcher(destination).forward(request, response);

    }
}
