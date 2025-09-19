package assign1_sec22_G15;

public class Dinner extends Meal {
    public Dinner(String mealName, double calories, double protein, double carbohydrates, double fats) {
        super(mealName, calories, protein, carbohydrates, fats);
    }

    @Override
    public void displayMeal() {
        System.out.println("Dinner: " + mealName + " " + calories + " calories, " + protein + "g protein, " + carbohydrates + "g carbohydrates, " + fats + "g fats");
    }
}