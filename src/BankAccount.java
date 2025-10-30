import java.util.Calendar;

/**
 * BankAccount class that stores a balance that can be deposited or withdrawn from.
 * Additionally creates and stores a record of transactions with a receipt.
 * @author Charlie Kavich
 * @author Ben Kaw
 * @since 10-29-25
 */
public class BankAccount {
    Calendar calendar = Calendar.getInstance();

    private double balance;

    private int accountNum;

    private StringBuilder receipt = new StringBuilder();

    /**
     * default constructor
     */
    public BankAccount()
    {
        balance = 0.0;
    }

    /**
     * Override constructor that allows a balance to be declared.
     * @param amount Constructor parameter for starting balance.
     */
    public BankAccount(double amount)
    {
        balance = amount;
    }

    /**
     * deposit method that adds to balance
     * @param amount to deposit
     * @return 1 if deposit successful, -1 if failed
     */
    public int deposit(double amount)
    {
        if(amount >= 0)
        {
            balance += amount;
            statementMod(amount, "Deposited");
            return 1;
        }
        else
        {
            errorMod (amount, "Cannot deposit $%.2f  Deposit amount negative.");
            return -1;
        }
    }

    /**
     * withdraw method that detracts from balance
     * @param amount to withdraw
     * @return 1 if withdrawal successful, -1 if failed
     */
    public int withdraw(double amount)
    {
        
            if(balance >= amount && amount >= 0)
            {
                balance -= amount;
                statementMod(amount, "Withdrawn");
                return 1;
            }
            else if (amount < 0)
            {
                errorMod (amount, "Cannot withdraw $%.2f Withdrawal amount negative.");
            }
            else if (balance < amount)
            {
                errorMod(amount, "Cannot withdraw $%.2f Insufficient funds.");
            }
            return -1;
        
        
    }

    /**
     * getBalance getter method for balance
     * @return The total balance of the account
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * getStatement getter setment for bank statement / receipt
     * @return bank statement
     */
    public String getStatement()
    {
        return receipt.toString();
    }

    /**
     * statementMod for successful transactions
     * @param change the total change in balance from the transaction
     * @param type of transaction (deposit or withdrawal)
     */
    private void statementMod(double change, String type)
    {
        String transaction = String.format(calendar.getTime() + ": %-10s $%-9.2f In Account: $%.2f  \n", type + ":", change, balance);
        receipt.append(transaction);
    }

    /**
     * errorMod for failed transactions
     * @param change attempted change in balance
     * @param error message explaining type of error (insufficient funds or negative amount)
     */
    private void errorMod (double change, String error)
    {
        String transaction = String.format(calendar.getTime() + ": Error: " + error + "\n", change);
        receipt.append(transaction);
    }
}
