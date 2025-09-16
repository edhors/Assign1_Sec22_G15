public class Lunch extends Meal {
    public Lunch(String mealName, double calories, double protein, double carbohydrates, double fats) {
        super(mealName, calories, protein, carbohydrates, fats);
    }

    @Override
    public void displayMeal() {
        System.out.println("Lunch: " + mealName + " " + calories + " calories, " + protein + "g protein, " + carbohydrates + "g carbohydrates, " + fats + "g fats");
    }
}