import java.util.Scanner;

/* ADD Group Members' details below:
 *  Eduardo Horstmann 1091883
*/ 
public class NutriTrack {
    public static void main(String[] args) {

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
                case 6: NewExtraFunctionality(); break;

                default:
                    System.out.println("Thank you for using CSC301's NutriTrack (A Personal Nutrition Tracker App). Have a healthy day!");
            }
        } while (userChoice != 0);
    }

    public static void DisplayMenu() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Personal Nutrition Tracker System (NutriTrack, Fall 24-25)");
        System.out.println("------------------------------------------------------------");
        System.out.println("1. Log a new meal (Breakfast, Lunch, Dinner, Snack, ...)");
        System.out.println("2. Update meal details (calories, protein, carbs, fats, etc.)");
        System.out.println("3. Set or update nutrition goals.");
        System.out.println("4. View progress toward nutrition goals.");
        System.out.println("5. Generate nutrition reports (daily, weekly, monthly)");
        System.out.println("6. NEW extra functionality of your choice. BE INNOVATIVE.");
        System.out.println("7. BONUS functionalities added here (extra marks).");
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
        return choice;
    }

    public static void LogNewMeal() {
        // To be completed. Feel free to change the input parameters. 
    }

    public static void UpdateMeal() {
        // To be completed. Feel free to change the input parameters. 
    }

    public static void SetUpdateNutritionGoals() {
        // To be completed. Feel free to change the input parameters. 
    }

    public static void ViewNutritionProgress() {
        // To be completed. Feel free to change the input parameters. 
    }

    public static void GenerateNutritionReports() {
        // To be completed. Feel free to change the input parameters. 
    }

    public static void NewExtraFunctionality() {
        // To be completed. Feel free to change the input parameters. 
    }
}
