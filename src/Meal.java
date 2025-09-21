/* ADD Group Members' details below:
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
Alexey Gorshkov 1090711
*/ 

public abstract class Meal {
    protected String mealName;
    protected double calories;
    protected double protein;
    protected double carbohydrates;
    protected double fats;

    public Meal(String mealName, double calories, double protein, double carbohydrates, double fats) {
        this.mealName = mealName;
        this.calories = calories;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
    }

    public String getMealName() {
        return mealName;
    }

    public double getCalories() {
        return calories;
    }

    public double getProtein() {
        return protein;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getFats() {
        return fats;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public abstract void displayMeal();
}