package controller;

import domain.service.MealService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {

    protected MealService service = MealService.getInstance();

    public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response);

    public void setModel (MealService contactTracingService) {
        this.service = contactTracingService;
    }

    public MealService getService() {
        return service;
    }

}
