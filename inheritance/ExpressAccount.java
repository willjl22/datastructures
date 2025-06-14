
/**
 * An abstract class for Express Accounts containing fields that the children classes will inherit .
 *
 * @author Jasmine Williams
 * @version 2.14
 */
public abstract class ExpressAccount
{
    int accNumber;
    double accBalance; 
    double baseBonusAmt;
    double mealPrice;
    static int mealNum;
    String accTypeName;
    double amount;
    
    /**
     * @param  accNumber initializes the integer input into the call to the accNumber
     */ 
    public ExpressAccount(int accNumber)
    {
        this.accNumber = accNumber;
    }
    
    public int getAccountNumber(){
        return accNumber;
    }
    
    public double getAccountBalance(){
        return accBalance;
    }
    
    public double getBaseAmtForBonus(){
        return baseBonusAmt;
    }
    
    public double getPricePerMeal(){
        return mealPrice;
    }
    
    public double getNumofMeals(){
        return mealNum;
    }
    
    /**
     * @param  accTypeName prints the String input as the account type name(either student or faculty)
     * @param  accNumber prints the integer as the account number
     * @param  accBalance prints the double as the account balance
     * @param  mealNum prints the integer as the number of meals
     * 
     * @return a print statement that identifies the following in String form
     */ 
    public String toString(String accTypeName, int accNumber, double accBalance, int mealNum){
        return (accTypeName+"#"+accNumber+", BALANCE: "+accBalance+"NUMBER OF MEALS: "+mealNum);
    }
    
    public abstract double deposit(double amount);
    
    public abstract double purchaseMeals(int mealsPurchased);
        // helperMethods();
}
