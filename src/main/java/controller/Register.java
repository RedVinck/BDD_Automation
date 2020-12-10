package controller;

import domain.model.Meal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class Register extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        int price = Integer.parseInt(request.getParameter("price"));
        boolean vegetarian = Boolean.parseBoolean((request.getParameter("vegetarian")));
        boolean containsNuts = Boolean.parseBoolean((request.getParameter("containsNuts")));
        boolean containsLactose = Boolean.parseBoolean((request.getParameter("containsLactose")));
        Meal meal = new Meal( name,  price,  category,  containsNuts,  vegetarian,  containsLactose);
        service.add(meal);
        return "index.jsp";
    }
}
/*
    private float price;
    private String name;
    private String category;
    private Boolean containsNuts;
    private Boolean vegetarian;
    private Boolean containsLactose;*/
