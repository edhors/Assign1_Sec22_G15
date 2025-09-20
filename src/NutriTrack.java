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
                case 5: createDailyReport(); break;
                case 6: ViewLoggedMeals(); break;
                case 7: SetUpdateCurrentNutrition(); break;
                case 8: initializeDataForAdvice();break;
             
                default:
                    System.out.println("Thank you for using CSC301's NutriTrack (A Personal Nutrition Tracker App). Have a healthy day!");
            }
        } while (userChoice != 0);
    }
    
    public static ArrayList<Meal> loggedBreakfasts = new ArrayList<>();
    public static ArrayList<Meal> loggedLunchs = new ArrayList<>();
    public static ArrayList<Meal> loggedDinner = new ArrayList<>();
    public static ArrayList<Meal> loggedSnacks = new ArrayList<>();
    public static NutritionGoals nutritionGoals = new NutritionGoals(0, 0, 0, 0);
    public static CurrentNutrition currentNutrition = new CurrentNutrition(null, null, null, null);

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
        System.out.println("7. Set or update current nutrition.");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------------");
    }

    public static int UserMenuChoice() {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Your Choice (0-7):");
            choice = input.nextInt();
        } while (choice > 7);
        input.close();
        return choice;
    }

    public static void LogNewMeal() {
        Scanner input = new Scanner(System.in);
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
        input.close();
    }

    public static void UpdateMeal() {
        Scanner input = new Scanner(System.in);
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
        input.close();
    }

    public static void SetUpdateNutritionGoals() {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        
        do {
            try {
                
            } catch (Exception e) {
                System.out.println("");
            }
            input.nextLine();
        } while (choice != 0);
        input.close();
    }

    public static void ViewNutritionProgress() {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("(0 to go back to the main menu, any other number to generate another report):");
            choice = input.nextInt();
        } while (choice != 0);
        input.close();
    }

    public static void GenerateNutritionReports() {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("(0 to go back to the main menu, any other number to generate another report):");
            choice = input.nextInt();
        } while (choice != 0);
        input.close();
    }

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

        //default Current Nutrition
        currentNutrition = new CurrentNutrition(loggedBreakfasts.get(0), loggedLunchs.get(0), loggedDinner.get(0), loggedSnacks.get(0));
    }

    public static void DisplayMealTypes() {
        System.out.println("Select meal type:");
        System.out.println("1. Breakfast");
        System.out.println("2. Lunch");
        System.out.println("3. Dinner");
        System.out.println("4. Snack");
    }

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
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("(0 to go back to the main menu, any other number to view logged meals):");
            choice = input.nextInt();
        } while (choice != 0);
        input.close();
    }

    public static void SetUpdateCurrentNutrition() {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("(0 to go back to the main menu, any other number to set or update current nutrition):");
            choice = input.nextInt();
        } while (choice != 0);
        input.close();
    }

     public static void SetUpdateNutritionGoals1() {
    	try {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new protein :");
        double protein = input.nextDouble();

        System.out.println("set fat target :");
        double fat = input.nextDouble();
        System.out.println("set calories target :");
        double calories = input.nextDouble();
        System.out.print("Enter your carbs: ");
        double carbs = input.nextDouble();

        nutritionGoals.setProtein(protein);
        nutritionGoals.setFats(fat);
        nutritionGoals.setCalories(calories);
		nutritionGoals.setCarbohydrates(carbs);	
    	}catch (Exception e) {
            System.out.println("Sorry ! An error occur ");
}
    	
    
    }
    
    public static void ViewNutritionProgress1() {
    	System.out.println("Your Progress");
        System.out.println("Fats: " + currentNutrition.getFats() + "-" + nutritionGoals.getFats());
        System.out.println("Protein: " + currentNutrition.getProtein() + "- " + nutritionGoals.getProtein());
        System.out.println("Calories: " + currentNutrition.getCalories() + " -" + nutritionGoals.getCalories());
		 System.out.println("Carbs: " + currentNutrition.getCarbohydrates() +" -"  nutritionGoals.getCarbohydrates());
    }
    

    public static void GenerateNutritionReports1() {
    	System.out.println("Nutrition Report :");
         currentNutrition.getBreakfast().displayMeal();
         currentNutrition.getLunch().displayMeal();
         currentNutrition.getDinner().displayMeal();
         currentNutrition.getSnack().displayMeal();
    }
 
 public static void initializeDataForAdvice(){
		  
		   Scanner input = new Scanner(System.in);
		    double m;
		    double h;
		    
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
		  
		  
		  MealAdvice advice = new MealAdvice(m,h);

    advice.setBMI();
		  
		  System.out.printf("BMI: %.1f%n", advice.getBMI());
		  
		  System.out.println(advice.getAdvice());
  
    input.close();
	
}
	public static void createDailyReport() {
	todaysMeals.clear();
	todaysMeals.addAll(loggedBreakfasts);
    todaysMeals.addAll(loggedLunchs);
    todaysMeals.addAll(loggedDinner);
    todaysMeals.addAll(loggedSnacks);
   
	if (todaysMeals.isEmpty()) {
        System.out.println("Meals are not added yet.");
        return;
    }
	double totalCal = 0, totalP = 0, totalCarbs = 0, totalF = 0;
	for(Meal M : todaysMeals){
		totalCal = totalCal + M.getCalories();
		totalP = totalP + M.getProtein();
		totalCarbs = totalCarbs + M.getCarbohydrates();
		totalF = totalF + M.getFats();
	}
	System.out.println("==================================================");
	if (totalCal > nutritionGoals.getCalories()) {
    System.out.println("You exceed your calorie intake by: " + (totalCal - nutritionGoals.getCalories()));
} else if (totalCal == nutritionGoals.getCalories()) { 
    System.out.println("Goal Completed (Calories)");
} else {
    System.out.println("Remaining Calories: " + (nutritionGoals.getCalories() - totalCal));
}

	
	if (totalP > nutritionGoals.getProtein()) {
    System.out.println("You exceed your protein intake by: " + (totalP - nutritionGoals.getProtein()));
} else if (totalP == nutritionGoals.getProtein()) {
    System.out.println("Goal Completed (Protein)");
} else {
    System.out.println("Remaining Proteins: "  + (nutritionGoals.getProtein() - totalP));
}

	
	if (totalCarbs > nutritionGoals.getCarbohydrates()) {
    System.out.println("You exceed your Carbohydrates intake by: "+ (totalCarbs - nutritionGoals.getCarbohydrates()));
} else if (totalCarbs == nutritionGoals.getCarbohydrates()) {
    System.out.println("Goal Completed (Carbohydrates)");
} else {
    System.out.println("Remaining Carbohydrates: "+ (nutritionGoals.getCarbohydrates() - totalCarbs));
}

	
	if (totalF > nutritionGoals.getFats()) {
    System.out.println("You exceed your Fats intake by: "+ (totalF - nutritionGoals.getFats()));
} else if (totalF == nutritionGoals.getFats()) {
    System.out.println("Goal Completed (Fats)");
} else {
    System.out.println("Remaining Fats: "+ (nutritionGoals.getFats() - totalF));
}

	System.out.println("==================================================");
	
		 
		
		
}
}


































