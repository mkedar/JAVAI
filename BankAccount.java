import java.util.Vector;

public class BadValueException extends Exception {
    private int reasonCode;
    private double badValue;

    public BadValueException(int reasonCode, double badValue) {
        this.reasonCode = reasonCode;
        this.badValue = badValue;
    }

    public int getReasonCode() {
        return reasonCode;
    }

    public double getBadValue() {
        return badValue;
    }

    @Override
    public String getMessage() {
        String reason;
        switch (reasonCode) {
            case 1:
                reason = "Negative balance";
                break;
            case 2:
                reason = "Negative interest rate";
                break;
            case 3:
                reason = "Depositing negative amount";
                break;
            case 4:
                reason = "Withdrawing an amount larger than the current balance";
                break;
            default:
                reason = "Unknown reason";
        }
        return reason + " " + badValue;
    }
}


public class BankAccount {
private double m_balance ;
public BankAccount(double balance)
{
m_balance = balance;
}
public String toString()
{
return "BANK-ACCOUNT($" + m_balance + ")" ;
}
public double deposit(double amount)
{
m_balance += amount;
return m_balance ;
}
public double withdraw(double amount)
{
m_balance -= amount ;
return m_balance ;
}
public double balance()
{
return ( m_balance ) ;
}
public static void main(String[] args){
BankAccount acct = new BankAccount(1000.0) ;
System.out.println( acct ) ;
System.out.println("Test deposit: " +
acct.deposit(200)) ;
System.out.println("Test withdrawal: " +
acct.withdraw(100)) ;
System.out.println("Test balance: " + acct.balance());
}
}
public class Checking extends BankAccount {
    public Checking(double balance) throws BadValueException {
        super(balance);
        validateBalance();
    }

    private void validateBalance() throws BadValueException {
        if (super.balance() < 0) {
            throw new BadValueException(1, super.balance());
        }
    }

    @Override
    public double deposit(double amount) {
        return super.deposit(amount);
    }
    

    @Override
    public double withdraw(double amount) {
        if (amount < 0) {
            throw new BadValueException(3, amount);
        }
        if (amount > super.balance()) {
            throw new BadValueException(4, amount);
        }
        return super.withdraw(amount);
    }

    @Override
    public String toString() {
        return "CHECKING($" + super.balance() + ")";
    }

    public void merge(BankAccount account) {
        super.deposit(account.balance());
        account.withdraw(account.balance());
    }
}

public class Saving extends Checking {
    private double interestRate;

    public Saving(double balance) throws BadValueException {
        this(balance, 0.0);
    }

    public Saving(double balance, double interestRate) throws BadValueException {
        super(balance);
        setInterestRate(interestRate);
    }

    public void setInterestRate(double interestRate) throws BadValueException {
        if (interestRate < 0) {
            throw new BadValueException(2, interestRate);
        }
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void addInterest() {
        double interest = balance() * interestRate;
        deposit(interest);
    }

    @Override
    public String toString() {
        return "SAVING($" + balance() + ") RATE(" + interestRate + ")";
    }

    public static Checking mergeAll(Vector<Checking> accounts) {
        double totalBalance = 0;

        for (int i = 0; i < accounts.size(); i++) {
            Checking account = accounts.get(i);
            totalBalance += account.balance();
            account.withdraw(account.balance());
        }

        return new Checking(totalBalance);
    }

    public static BankAccount createChecking(double balance, double interestRate) {
        try {
            if (interestRate == 0.0) {
                return new Checking(balance);
            } else if (interestRate > 0.0) {
                return new Saving(balance, interestRate);
            } else {
                throw new BadValueException(2, interestRate);
            }
        } catch (BadValueException e) {
            if (e.getReasonCode() == 2) {
                return new Checking(balance);
            } else {
                return null;
            }
        }
    }
}




