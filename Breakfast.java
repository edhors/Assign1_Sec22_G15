package assign1_sec22_G15;

public class Breakfast extends Meal {
    public Breakfast(String mealName, double calories, double protein, double carbohydrates, double fats) {
        super(mealName, calories, protein, carbohydrates, fats);
    }

    @Override
    public void displayMeal() {
        System.out.println("Breakfast: " + mealName + " " + calories + " calories, " + protein + "g protein, " + carbohydrates + "g carbohydrates, " + fats + "g fats");
    }
}