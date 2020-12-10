package domain.model;

public class Meal {
    private float price;
    private String name;
    private String category;
    private Boolean containsNuts;
    private Boolean vegetarian;
    private Boolean containsLactose;

    public Meal(String name, float price, String category){
        this.setName(name);
        this.setPrice(price);
        this.setCategory(getCategory());
        this.setContainsNuts(false);
        this.setVegetarian(false);
        this.setContainsLactose(false);
    }

    public Meal() {
    }

    public Meal(String name, float price, String category, Boolean nuts, Boolean vegetarian, Boolean lactose){
        this.setName(name);
        this.setPrice(price);
        this.setCategory(category);
        this.setContainsNuts(nuts);
        this.setVegetarian(vegetarian);
        this.setContainsLactose(lactose);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getContainsNuts() {
        return containsNuts;
    }

    public void setContainsNuts(Boolean containsNuts) {
        this.containsNuts = containsNuts;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Boolean getContainsLactose() {
        return containsLactose;
    }

    public void setContainsLactose(Boolean containsLactose) {
        this.containsLactose = containsLactose;
    }

}
