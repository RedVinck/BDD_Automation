package database;

import domain.model.Meal;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MealsDB {
    private ArrayList<Meal> meals;

    public MealsDB(ArrayList<Meal> meals) {
        this.meals = meals;
    }


    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }

    public void add(Meal meal){
      if (!this.meals.contains(meal)){
          this.meals.add(meal)
      }
    }

    public boolean contains(Meal mail){
        for (Meal loopedmeal:this.meals){
            if (loopedmeal.getName().equals(mail.getName()))return true;
        }
        return false;
    }
}
