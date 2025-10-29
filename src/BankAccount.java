import java.util.Calendar;

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
     * 
     * @param amount Constructor parameter for starting balance.
     */
    public BankAccount(double amount)
    {
        balance = amount;
    }

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

    public double getBalance()
    {
        return balance;
    }
    public String getStatement()
    {
        return receipt.toString();
    }

    private void statementMod(double change, String type)
    {
        String transaction = String.format(calendar.getTime() + ": %-10s $%-9.2f In Account: $%.2f  \n", type + ":", change, balance);
        receipt.append(transaction);
    }

    private void errorMod (double change, String error)
    {
        String transaction = String.format(calendar.getTime() + ": Error: " + error + "\n", change);
        receipt.append(transaction);
    }
}
