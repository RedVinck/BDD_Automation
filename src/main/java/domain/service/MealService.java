package domain.service;

import domain.model.Meal;
import domain.model.Meal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MealService {
/*    private float price;
    private String name;
    private String category;
    private Boolean containsNuts;
    private Boolean vegetarian;
    private Boolean containsLactose;*/

    private static MealService INSTANCE;
    private List<Meal> meals = new ArrayList<Meal>();

    public MealService() {
//        meals.add(new Meal("Zalm",5,"Vis"));
    }

    public static MealService getInstance() {

        if(INSTANCE == null) {
            INSTANCE = new MealService();
        }
        return INSTANCE;
    }

    public List<Meal> getAllMeals () {
        Collections.sort(meals);return meals;
    }

    public void add (Meal meal) {
        meals.add(meal);
    }

    public void delete (String ssn) {

    }

    public void deleteAll () {
        meals = new ArrayList<Meal>();
    }

    public Meal getMealFromName(String mealName) {
        for (Meal meal: meals) {
            if (meal.getName().equals(mealName)) {
                return meal;
            }
        }
        return null;
    }
}
