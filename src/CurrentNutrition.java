/* ADD Group Members' details below:
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
Alexey Gorshkov 1090711
*/ 

public class CurrentNutrition {
    private Breakfast breakfast;
    private Lunch lunch;
    private Dinner dinner;
    private Snack snack;
    private double calories;
    private double protein;
    private double carbohydrates;
    private double fats;

    public CurrentNutrition(Breakfast breakfast, Lunch lunch, Dinner dinner, Snack snack) {
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.snack = snack;
        this.calories = breakfast.getCalories() + lunch.getCalories() + dinner.getCalories() + snack.getCalories();
        this.protein = breakfast.getProtein() + lunch.getProtein() + dinner.getProtein() + snack.getProtein();
        this.carbohydrates = breakfast.getCarbohydrates() + lunch.getCarbohydrates() + dinner.getCarbohydrates() + snack.getCarbohydrates();
        this.fats = breakfast.getFats() + lunch.getFats() + dinner.getFats() + snack.getFats();
    }

    public Breakfast getBreakfast() {
        return breakfast;
    }

    public Lunch getLunch() {
        return lunch;
    }

    public Dinner getDinner() {
        return dinner;
    }

    public Snack getSnack() {
        return snack;
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

    public void setBreakfast(Breakfast breakfast) {
        this.breakfast = breakfast;
    }

    public void setLunch(Lunch lunch) {
        this.lunch = lunch;
    }

    public void setDinner(Dinner dinner) {
        this.dinner = dinner;
    }   

    public void setSnack(Snack snack) {
        this.snack = snack;
    }
}