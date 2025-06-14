import java.util.Scanner;
/**
 * Allows user to repeatedly create and manage express card accounts with the purpose of purchasing meals.
 *
 * @author Jasmine Williams
 * @version 2.14
 */
public class Driver
{
     double accountBalance = 0.0;
     static int totalNumOfAccs = 3;
    
    //demo code given in project details
    public String toString(){
        return("Account balance: $"+accountBalance);
    }
    
    // main menu method that gives all options in the main menu of the express account
    public static void mainMenu(){
        System.out.println("MAIN MENU");
        // loops the numbers and assigns a statement to each number
        for (int i = 1; i<4; i++){
            System.out.print(i+".) ");
            if(i==1){
                System.out.println("Create new account");
            }
            else if(i==2){
                System.out.println("Log into an exisiting account");
            }
            else{
                System.out.println("Exit banking system");
            }
        }
        System.out.print("Please enter your selection: ");
        Scanner input = new Scanner(System.in);
        String userChoice = input.nextLine(); 
        //calls the new acc method in the driver class
        if(userChoice.equals("1")){
            newAcc();
        }
        //calls the existing acc method in the driver class
        else if(userChoice.equals("2")){
            existingAcc();
        }
        //ends system
        else if(userChoice.equals("3")){
            exitBank();
        }
        //sends user back to main menu when an invalid input is entered
        else{
            System.out.println("Invalid choice, please try again");
            mainMenu();
        }
    }
    
    //creates either a new student or faculty account using their express account class objects
    public static void newAcc(){
        System.out.println("\n");
        System.out.println("CHOOSE THE TYPE FOR THE NEW ACCOUNT");
        // loops the numbers and assigns a statement to each number
        for(int i = 1; i<3; i++){
            System.out.print(i+".) ");
            if(i==1){
                System.out.println("Student express account");
            }
            else{
                System.out.println("Faculty express account");
            }
        }
        System.out.print("Please enter your selection: ");
        Scanner newInput = new Scanner(System.in);
        String input = newInput.nextLine();
        //creates a new student account via student express account class
        if(input.equals("1")){
            StudentExpressAccount stuAcc = new StudentExpressAccount(0);
            stuAcc.StudentAcc();
        }
        //creates a new faculty account via faculty express account class
        else if(input.equals("2")){
            FacultyExpressAccount facAcc = new FacultyExpressAccount(1);
            facAcc.FacultyAcc();
        }
        else{
            System.out.println("Please try again");
            mainMenu();
        }//System.out.println(test.toString());

    }
    
    // enters a pre-existing account
    public static void existingAcc(){
        System.out.println("\n");
        System.out.print("Enter account number: "); // turn input String into an int using a new scanner
        Scanner newInput = new Scanner(System.in);
        String input = newInput.nextLine();
        
        //ensures that the account number exists
        if (((input.compareTo("totalNumOfAccs"))<=1)&&(input.compareTo("totalNumOfAccs"))>0){
            System.out.println("Invalid account number (must be between 0 and "+totalNumOfAccs+")");
        }
        else{
            System.out.println("Welcome back Student Express account #"+input+", BALANCE: $,NUMBER OF MEALS:");
        }
        
        System.out.println("What type of account: ");
        if(newInput.nextLine().equals("Student")){
            StudentExpressAccount stuAcc2 = new StudentExpressAccount(2);
            stuAcc2.StudentAcc();
        }
        else if(newInput.nextLine().equals("Student")){
            FacultyExpressAccount facAcc2 = new FacultyExpressAccount(3);
            facAcc2.FacultyAcc();
        }
    }
    
    //exits the whole program 
    public static void exitBank(){
        System.out.println("Exiting the system");
    }

    public static void main(String[] args){
        Driver test = new Driver();

        System.out.println("Welcome to Express Account Company");
        System.out.println("\n");
        mainMenu(); 

    }
}
