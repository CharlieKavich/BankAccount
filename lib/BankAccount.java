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
            else
            {
                return -1;
            }
        
        
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
}
