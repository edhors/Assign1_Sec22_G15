public class NutritionGoals extends Meal {
    public NutritionGoals(double calories, double protein, double carbohydrates, double fats) {
        super("Nutrition Goals", calories, protein, carbohydrates, fats);
    }

    @Override
    public void displayMeal() {
        System.out.println("Nutrition Goals:");
        System.out.println("Calories: " + getCalories());
        System.out.println("Protein: " + getProtein() + "g");
        System.out.println("Carbohydrates: " + getCarbohydrates() + "g"); 
        System.out.println("Fats: " + getFats() + "g");
    }
}
