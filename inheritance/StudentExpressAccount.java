import java.util.Scanner;
/**
 * An inheritance of the ExpressAccount Class where the account will override the deposit function to
 * account for the reward system as well as the meal price specified for students.
 *
 * @author Jasmine Williams
 * @version 2.14
 */
public class StudentExpressAccount extends ExpressAccount
{
    //constuctor that initializes all the required values for a student account
    /**
     * @param  accNumber initializes the integer input into the call to the accNumber for the student
     */ 
    public StudentExpressAccount(int accNumber){
        super(accNumber);
        baseBonusAmt = 500.0;
        mealPrice = 10.0;
        accTypeName = "STUDENT EXPRESS ACCOUNT"; 
        accBalance = 0.0; 
        mealNum = 0;
    }

    public void StudentAcc(){
        // loops the numbers and assigns a statement to each number
        for (int i = 1; i<5; i++){
            System.out.print(i+".) ");
            if(i==1){
                System.out.println("Make a deposit");
            }
            else if(i==2){
                System.out.println("Purchase meals");
            }
            else if (i==3){
                System.out.println("Have meal");

            }
            else{
                System.out.println("Log out");
            }
        }
        System.out.print("Please enter your selection: ");
        Scanner input = new Scanner(System.in);
        String userChoice = input.nextLine(); 
        if(userChoice.equals("1")){
            System.out.print("\n");
            System.out.print("Enter deposit amount: ");
            //sends the user to the deposit method specified for students
            System.out.println("New balance: "+deposit(Double.parseDouble(input.nextLine())));
            //sends the user back to the main student account menu
            StudentAcc();
        }
        else if(userChoice.equals("2")){
            System.out.print("\n");
            System.out.print("Enter the number of meals you want to purchase: ");
            //sends the user to the purchasing meals method
            System.out.println("New balance: "+purchaseMeals(Integer.parseInt(input.nextLine()))); 
            //sends the user back to the main student account menu
            StudentAcc();
        }
        else if(userChoice.equals("3")){
            System.out.print("\n");
            //sends the user to the losing a meal method
            haveMeal();
            //sends the user back to the main student account menu
            StudentAcc();
        }
         else if(userChoice.equals("4")){
            System.out.print("\n");
            System.out.println("Goodbye!");
            //sends the user back to the main menu provided in the driver class
            Driver.mainMenu();
        }

        else{
            System.out.println("Invalid choice, please try again");
            //sends the user back to the main student account menu if invalid input occurs
            Driver.mainMenu();
        }
        
    }
    
    /**
     * @param  amount a double variable that the user would like to deposit into account
     * @return the new account balance with added deposit value as well as the bonus added 
     */
    
    @Override
    public double deposit(double amount){
        // this local variable represents the amount added for money over the bonus provided by the input
        double baseBonusAmt = amount/100.0;
        //represents the reward level for student account
        double rewardLevel = 200.0; 
        //represents the standard amount added for money over the bonus by 
        double rewardAmt = rewardLevel/100.0;
        
        //if the users balance is greater than zero, they do not receive the special baseBonus function
        if(accBalance != 0){
            return accBalance += amount;
        }
        //if the user inputs a negative value, resends them to main student acc menu
        else if (amount<0){
            System.out.println("The deposit must be a positive amount");
            return accBalance;
        }
        //if the users balance is 0 and greater than 500.0 than the reward is given
        else if (amount >= baseBonusAmt){
            double bonusAmt = Math.floor(baseBonusAmt/rewardAmt);
            return accBalance = amount + (rewardAmt*bonusAmt);

        }
        //preventing exception issues, i guess
        else{
            return accBalance += amount;
        }

    }

    /**
     * @param  mealsPurchased a integer variable that represents the number of meals they would like to purchase
     * @return how many meals the customer has and the new account balance after purchasing
     */
    
    @Override
    public double purchaseMeals(int mealsPurchased){
        double deductionPrice;
        // how much money will be taken out of the account balance
        deductionPrice = mealsPurchased * mealPrice;
        //if the deduction price is greater than the account balance, it goes through the method again with one meal item
        if (deductionPrice > accBalance){
            System.out.println("Not enough balance for "+mealsPurchased+"meals");
            purchaseMeals(mealsPurchased -1);
            return accBalance;
        }
        //subtracts the deduction price from the account balance and increases the amount of meals in account
        else{
            accBalance -= deductionPrice;
            mealNum += mealsPurchased;
            System.out.println("Purchased "+mealsPurchased+" meals with $"+mealPrice+" per meal, New Balance $"+accBalance);
            return accBalance;
        }
    }
    
    /**
     * @return the new number of meals in account after purchasing one meal
     */
    
    public static int haveMeal(){
        mealNum -=1;
        if(mealNum ==0){
            System.out.println("No meals left on your account. Please purchase meals first.");
            return mealNum +=1;
        }
        System.out.println("Remaining meals: "+mealNum);
        return mealNum;
    }
}
