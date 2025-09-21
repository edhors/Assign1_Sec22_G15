import java.util.Scanner;
import java.util.ArrayList;

/* ADD Group Members' details below:
Eduardo Horstmann 1091883
 Ali Mousa Tanbouz 1088413 
 Alexey Gorshkov 1090711
*/ 
public class NutriTrack {
    public static void main(String[] args) {        
        initializeDefaultMeals();
        int userChoice;
        do {
            DisplayMenu();
            userChoice = UserMenuChoice();
            switch (userChoice) {
                case 1: LogNewMeal(); break;
                case 2: UpdateMeal(); break;
                case 3: SetUpdateNutritionGoals(); break;
                case 4: ViewNutritionProgress(); break;
                case 5: GenerateNutritionReports(); break;
                case 6: ViewLoggedMeals(); break;
                case 7: SetUpdateDailyMeals(); break;
                case 8: MealAdvice();break;
             
                default:
                    System.out.println("Thank you for using CSC301's NutriTrack (A Personal Nutrition Tracker App). Have a healthy day!");
            }
        } while (userChoice != 0);
        input.close();
    }
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Meal> loggedBreakfasts = new ArrayList<>();
    public static ArrayList<Meal> loggedLunchs = new ArrayList<>();
    public static ArrayList<Meal> loggedDinner = new ArrayList<>();
    public static ArrayList<Meal> loggedSnacks = new ArrayList<>();
    public static NutritionGoals nutritionGoals = new NutritionGoals(0, 0, 0, 0);
    public static ArrayList<DailyMeals> weeklyMeals = new ArrayList<>();

    public static void DisplayMenu() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Personal Nutrition Tracker System (NutriTrack, Fall 24-25)");
        System.out.println("------------------------------------------------------------");
        System.out.println("1. Log a new meal (Breakfast, Lunch, Dinner, Snack, ...)");
        System.out.println("2. Update meal details (calories, protein, carbs, fats, etc.)");
        System.out.println("3. Set or update nutrition goals.");
        System.out.println("4. View progress toward nutrition goals.");
        System.out.println("5. Generate nutrition reports (daily, weekly, monthly)");
        System.out.println("6. View logged meals.");
        System.out.println("7. Set or update daily meals.");
        System.out.println("8. Get meal advice.");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------------");
    }

    public static int UserMenuChoice() {
        int choice;
        do {
            System.out.println("Your Choice (0-8):");
            choice = input.nextInt();
        } while (choice > 8);
        return choice;
    }

    // 1. Log a new meal (Breakfast, Lunch, Dinner, Snack, ...)
    public static void LogNewMeal() {
        int choice = -1;
        do {
            DisplayMealTypes();
            try {
                int mealType = input.nextInt();
                input.nextLine();
                System.out.print("Enter the meal name: ");
                String mealName = input.nextLine();
                System.out.print("Enter the meal calories:");
                double calories = input.nextDouble();
                System.out.print("Enter the meal protein:");
                double protein = input.nextDouble();
                System.out.print("Enter the meal carbohydrates:");
                double carbohydrates = input.nextDouble();
                System.out.print("Enter the meal fats:");
                double fats = input.nextDouble();
                switch (mealType) {
                    case 1:
                        loggedBreakfasts.add(new Breakfast(mealName, calories, protein, carbohydrates, fats));
                        break;
                    case 2:
                        loggedLunchs.add(new Lunch(mealName, calories, protein, carbohydrates, fats));
                        break;
                    case 3:
                        loggedDinner.add(new Dinner(mealName, calories, protein, carbohydrates, fats));
                        break;
                    case 4:
                        loggedSnacks.add(new Snack(mealName, calories, protein, carbohydrates, fats));
                        break;
                    default:
                        System.out.println("Invalid meal type selected");
                        return;
                }
                System.out.println("Meal logged successfully");
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
            input.nextLine();
            System.out.println("(0 to go back to the main menu, any other number to log another meal):");
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("");
            }
            input.nextLine();
        } while (choice != 0);
    }

    // 2. Update meal details (calories, protein, carbs, fats, etc.)
    public static void UpdateMeal() {
        int choice = -1;
        do {
            DisplayMealTypes();
            try {
                int mealType = input.nextInt();
                input.nextLine();
                switch (mealType) {
                    case 1:
                        for(int i = 0; i < loggedBreakfasts.size(); i++) System.out.println((i+1) + ". " + loggedBreakfasts.get(i).getMealName());      
                        break;
                    case 2:
                        for(int i = 0; i < loggedLunchs.size(); i++) System.out.println((i+1) + ". " + loggedLunchs.get(i).getMealName());      
                        break;
                    case 3:
                        for(int i = 0; i < loggedDinner.size(); i++) System.out.println((i+1) + ". " + loggedDinner.get(i).getMealName());      
                        break;
                    case 4:
                        for(int i = 0; i < loggedSnacks.size(); i++) System.out.println((i+1) + ". " + loggedSnacks.get(i).getMealName());      
                        break;
                    default:
                        break;
                }
                System.out.print("Enter the number of the meal to update: ");
                int mealNumber = input.nextInt() - 1;
                input.nextLine();
                System.out.print("Enter the meal name: ");
                String mealName = input.nextLine();
                System.out.print("Enter the meal calories:");
                double calories = input.nextDouble();
                System.out.print("Enter the meal protein:");
                double protein = input.nextDouble();
                System.out.print("Enter the meal carbohydrates:");
                double carbohydrates = input.nextDouble();
                System.out.print("Enter the meal fats:");
                double fats = input.nextDouble();
                switch (mealType) {
                    case 1:
                        loggedBreakfasts.get(mealNumber).setMealName(mealName);
                        loggedBreakfasts.get(mealNumber).setCalories(calories);
                        loggedBreakfasts.get(mealNumber).setProtein(protein);
                        loggedBreakfasts.get(mealNumber).setCarbohydrates(carbohydrates);
                        loggedBreakfasts.get(mealNumber).setFats(fats);
                        break;
                    case 2:
                        loggedLunchs.get(mealNumber).setMealName(mealName);
                        loggedLunchs.get(mealNumber).setCalories(calories);
                        loggedLunchs.get(mealNumber).setProtein(protein);
                        loggedLunchs.get(mealNumber).setCarbohydrates(carbohydrates);
                        loggedLunchs.get(mealNumber).setFats(fats);
                        break;
                    case 3:
                        loggedDinner.get(mealNumber).setMealName(mealName);
                        loggedDinner.get(mealNumber).setCalories(calories);
                        loggedDinner.get(mealNumber).setProtein(protein);
                        loggedDinner.get(mealNumber).setCarbohydrates(carbohydrates);
                        loggedDinner.get(mealNumber).setFats(fats);
                        break;
                    case 4:
                        loggedSnacks.get(mealNumber).setMealName(mealName);
                        loggedSnacks.get(mealNumber).setCalories(calories);
                        loggedSnacks.get(mealNumber).setProtein(protein);
                        loggedSnacks.get(mealNumber).setCarbohydrates(carbohydrates);
                        loggedSnacks.get(mealNumber).setFats(fats);
                        break;
                }
                System.out.println("Meal updated successfully");
                System.out.println("(0 to go back to the main menu, any other number to update another meal):");
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
            input.nextLine();
            System.out.println("(0 to go back to the main menu, any other number to update another meal):");
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("");
            }
            input.nextLine();
        } while (choice != 0);
    }

    // 3. Set or update nutrition goals.
    public static void SetUpdateNutritionGoals() {
        int choice = -1;
        do {
            try {
                System.out.print("Enter protein target: ");
                double protein = input.nextDouble();
    
                System.out.print("Enter fat target: ");
                double fat = input.nextDouble();
                System.out.print("Enter calories target: ");
                double calories = input.nextDouble();
                System.out.print("Enter carbohydrates target: ");
                double carbs = input.nextDouble();
    
                nutritionGoals.setProtein(protein);
                nutritionGoals.setFats(fat);
                nutritionGoals.setCalories(calories);
                nutritionGoals.setCarbohydrates(carbs);	
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
            System.out.println("(0 to go back to the main menu, any other number to set or update nutrition goals):");
            choice = input.nextInt();
        } while (choice != 0);
    }

    // 4. View progress toward nutrition goals.
    public static void ViewNutritionProgress() {
        int choice = -1;
        do {
            System.out.println("Your Progress");
            for(int i = 0; i < weeklyMeals.size(); i++) {
                System.out.println("Day " + (i+1) + ":");
                System.out.println("Calories towards goal: " + (weeklyMeals.get(i).getCalories() - nutritionGoals.getCalories()));
                System.out.println("Protein towards goal: " + (weeklyMeals.get(i).getProtein() - nutritionGoals.getProtein()) + "g");
                System.out.println("Carbohydrates towards goal: " + (weeklyMeals.get(i).getCarbohydrates() - nutritionGoals.getCarbohydrates()) + "g");
                System.out.println("Fats towards goal: " + (weeklyMeals.get(i).getFats() - nutritionGoals.getFats()) + "g");
            }
            System.out.println("(0 to go back to the main menu, any other number to view nutrition progress):");
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("");
            }
            input.nextLine();
        } while (choice != 0);
    }

    // 5. Generate nutrition reports (daily, weekly, monthly)
	public static void GenerateNutritionReports() {
        int choice = -1;
        do {
            DailyMeals dailyMeals = weeklyMeals.get(weeklyMeals.size() - 1);
            if (dailyMeals.getBreakfast() == null || dailyMeals.getLunch() == null || dailyMeals.getDinner() == null || dailyMeals.getSnack() == null) {
                System.out.println("Meals are not added yet.");
            }
            else {
                double totalCal = dailyMeals.getCalories();
                double totalP = dailyMeals.getProtein();
                double totalCarbs = dailyMeals.getCarbohydrates();
                double totalF = dailyMeals.getFats();
                System.out.println("==================================================");
                    if (totalCal > nutritionGoals.getCalories()) {
                    System.out.println("You exceed your calorie intake by: " + (totalCal - nutritionGoals.getCalories()));
                } else if (totalCal == nutritionGoals.getCalories()) { 
                    System.out.println("Goal Completed (Calories)");
                } else {
                    System.out.println("You must intake more calories: " + (nutritionGoals.getCalories() - totalCal));
                }
        
                
                if (totalP > nutritionGoals.getProtein()) {
                    System.out.println("You exceed your protein intake by: " + (totalP - nutritionGoals.getProtein()) + "g");
                } else if (totalP == nutritionGoals.getProtein()) {
                    System.out.println("Goal Completed (Protein)");
                } else {
                    System.out.println("You must intake more proteins: "  + (nutritionGoals.getProtein() - totalP) + "g");
                }
        
                
                if (totalCarbs > nutritionGoals.getCarbohydrates()) {
                    System.out.println("You exceed your Carbohydrates intake by: "+ (totalCarbs - nutritionGoals.getCarbohydrates()) + "g");
                } else if (totalCarbs == nutritionGoals.getCarbohydrates()) {
                    System.out.println("Goal Completed (Carbohydrates)");
                } else {
                    System.out.println("You must intake more carbohydrates: "+ (nutritionGoals.getCarbohydrates() - totalCarbs) + "g");
                }
        
                
                if (totalF > nutritionGoals.getFats()) {
                    System.out.println("You exceed your Fats intake by: "+ (totalF - nutritionGoals.getFats()) + "g");
                } else if (totalF == nutritionGoals.getFats()) {
                    System.out.println("Goal Completed (Fats)");
                } else {
                    System.out.println("You must intake more fats: "+ (nutritionGoals.getFats() - totalF) + "g");
                }
        
                System.out.println("==================================================");  
            }
            System.out.println("(0 to go back to the main menu, any other number to generate another report):");
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("");
            }
            input.nextLine();
        } while (choice != 0);        
    }

    // 6. View logged meals.
    public static void ViewLoggedMeals() {
        for (Meal meal : loggedBreakfasts) {
            meal.displayMeal();
        }
        for (Meal meal : loggedLunchs) {
            meal.displayMeal();
        }
        for (Meal meal : loggedDinner) {
            meal.displayMeal();
        }
        for (Meal meal : loggedSnacks) {
            meal.displayMeal();
        }
        int choice;
        do {
            System.out.println("(0 to go back to the main menu, any other number to view logged meals):");
            choice = input.nextInt();
        } while (choice != 0);
    }

    // 7. Set or update daily meals.
    public static void SetUpdateDailyMeals() {
        int choice = -1;
        do {
            try {
                System.out.println("Choose your day (enter the number): ");
                int dayNumber;
                for(dayNumber = 0; dayNumber <= weeklyMeals.size(); dayNumber++) {
                    if(dayNumber < weeklyMeals.size()) System.out.println((dayNumber+1) + ". ");
                    else System.out.println((dayNumber+1) + ". " + "Add a new day");
                }      
                dayNumber = input.nextInt() - 1;
                if(dayNumber == weeklyMeals.size()) weeklyMeals.add(new DailyMeals(null, null, null, null));
                
                DailyMeals dailyMeals = weeklyMeals.get(dayNumber);

                System.out.println("Choose your breakfast(enter the number): ");
                for(int i = 0; i < loggedBreakfasts.size(); i++) System.out.println((i+1) + ". " + loggedBreakfasts.get(i).getMealName());      
                int breakfastNumber = input.nextInt() - 1;
                System.out.println("Choose your lunch(enter the number): ");
                for(int i = 0; i < loggedLunchs.size(); i++) System.out.println((i+1) + ". " + loggedLunchs.get(i).getMealName());      
                int lunchNumber = input.nextInt() - 1;
                System.out.println("Choose your dinner(enter the number): ");
                for(int i = 0; i < loggedDinner.size(); i++) System.out.println((i+1) + ". " + loggedDinner.get(i).getMealName());      
                int dinnerNumber = input.nextInt() - 1;
                System.out.println("Choose your snack(enter the number): ");
                for(int i = 0; i < loggedSnacks.size(); i++) System.out.println((i+1) + ". " + loggedSnacks.get(i).getMealName());      
                int snackNumber = input.nextInt() - 1;
                dailyMeals.setBreakfast(loggedBreakfasts.get(breakfastNumber));
                dailyMeals.setLunch(loggedLunchs.get(lunchNumber));
                dailyMeals.setDinner(loggedDinner.get(dinnerNumber));
                dailyMeals.setSnack(loggedSnacks.get(snackNumber));
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
            System.out.println("(0 to go back to the main menu, any other number to set or update daily meals):");
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("");
            }
            input.nextLine();
        } while (choice != 0);
    }

    // 8. Get meal advice.
    public static void MealAdvice(){ 
        int choice = -1;
        do {
            double m;
            double h;
                
            try {
                while (true){
                    System.out.println("Enter your Bodymass in kg: ");
                    if(input.hasNextDouble()) {
                        
                        m = input.nextDouble();
                        
                        if(m>0) break;
                    }else {
                        input.next();
                        }
                    System.out.println("Please enter a positive number.");
            
                }
                
                
                while (true){
                    System.out.println("Enter your Height in cm: ");
                    
                    if(input.hasNextDouble()) {
                        
                        h = input.nextDouble();
                        
                        if(h>0) break;
                    }else {
                        input.next();
                        }
                    System.out.println("Please enter a positive number.");
                }

                MealAdvice advice = new MealAdvice(m,h/100);

                advice.setBMI();
                    
                System.out.printf("BMI: %.1f%n", advice.getBMI());
                
                System.out.println(advice.getAdvice());

            } catch (Exception e) {
                System.out.println("Invalid input");
            }
            System.out.println("(0 to go back to the main menu, any other number to get meal advice):");
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("");
            }
            input.nextLine();   
        } while (choice != 0);
    }

    //helper method for displaying meal types
    public static void DisplayMealTypes() {
        System.out.println("Select meal type:");
        System.out.println("1. Breakfast");
        System.out.println("2. Lunch");
        System.out.println("3. Dinner");
        System.out.println("4. Snack");
    }

    //initialize default meals data
    private static void initializeDefaultMeals() {
        //default Breakfasts
        loggedBreakfasts.add(new Breakfast("Oatmeal with Berries", 350, 12, 60, 8));
        loggedBreakfasts.add(new Breakfast("Scrambled Eggs & Toast", 420, 20, 35, 15));
        loggedBreakfasts.add(new Breakfast("Greek Yogurt Parfait", 300, 15, 45, 10));
        loggedBreakfasts.add(new Breakfast("Breakfast Burrito", 550, 25, 65, 20));

        //default Lunches
        loggedLunchs.add(new Lunch("Grilled Chicken Salad", 450, 35, 25, 12));
        loggedLunchs.add(new Lunch("Turkey Sandwich", 480, 28, 55, 15));
        loggedLunchs.add(new Lunch("Quinoa Buddha Bowl", 520, 18, 80, 18));
        loggedLunchs.add(new Lunch("Tuna Wrap", 400, 30, 45, 14));

        //default Dinners
        loggedDinner.add(new Dinner("Salmon with Rice", 650, 40, 70, 22));
        loggedDinner.add(new Dinner("Pasta Primavera", 550, 18, 90, 15));
        loggedDinner.add(new Dinner("Stir-Fry Tofu", 480, 25, 60, 18));
        loggedDinner.add(new Dinner("Lean Beef Steak", 600, 45, 40, 25));

        //default Snacks
        loggedSnacks.add(new Snack("Apple with Peanut Butter", 200, 7, 25, 8));
        loggedSnacks.add(new Snack("Trail Mix", 180, 6, 20, 10));
        loggedSnacks.add(new Snack("Protein Smoothie", 250, 20, 30, 5));
        loggedSnacks.add(new Snack("Hummus with Carrots", 150, 5, 18, 8));

        //default Nutrition Goals
        nutritionGoals = new NutritionGoals(2000, 150, 200, 50);

        //default Weekly Meals
        weeklyMeals.add(new DailyMeals((Breakfast)loggedBreakfasts.get(0), (Lunch)loggedLunchs.get(0), (Dinner)loggedDinner.get(0), (Snack)loggedSnacks.get(0)));
        weeklyMeals.add(new DailyMeals((Breakfast)loggedBreakfasts.get(1), (Lunch)loggedLunchs.get(1), (Dinner)loggedDinner.get(1), (Snack)loggedSnacks.get(1)));
        weeklyMeals.add(new DailyMeals((Breakfast)loggedBreakfasts.get(2), (Lunch)loggedLunchs.get(2), (Dinner)loggedDinner.get(2), (Snack)loggedSnacks.get(2)));
        weeklyMeals.add(new DailyMeals((Breakfast)loggedBreakfasts.get(3), (Lunch)loggedLunchs.get(3), (Dinner)loggedDinner.get(3), (Snack)loggedSnacks.get(3)));
    }

}
