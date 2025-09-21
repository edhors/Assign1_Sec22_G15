/* ADD Group Members' details below:
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
Alexey Gorshkov 1090711
*/ 

public class Snack extends Meal {
    public Snack(String mealName, double calories, double protein, double carbohydrates, double fats) {
        super(mealName, calories, protein, carbohydrates, fats);
    }

    @Override
    public void displayMeal() {
        System.out.println("Snack: " + mealName + " " + calories + " calories, " + protein + "g protein, " + carbohydrates + "g carbohydrates, " + fats + "g fats");
    }
}