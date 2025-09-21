/* ADD Group Members' details below:
Eduardo Horstmann 1091883
Ali Mousa Tanbouz 1088413 
Alexey Gorshkov 1090711
*/ 

public class Breakfast extends Meal {
    public Breakfast(String mealName, double calories, double protein, double carbohydrates, double fats) {
        super(mealName, calories, protein, carbohydrates, fats);
    }

    @Override
    public void displayMeal() {
        System.out.println("Breakfast: " + mealName + " " + calories + " calories, " + protein + "g protein, " + carbohydrates + "g carbohydrates, " + fats + "g fats");
    }
}