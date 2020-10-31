/**
 * The SavingsAccount class represents a checking account in the bank.
 * 
 * @author Warren Sink
 *
 */
public class SavingsAccount extends BankAccount {

	private double interestRate;
	
	/**
	 * Initializes a newly constructed SavingsAccount object with initial balance, interest rate,
	 * and owner information.
	 * 
	 * @param initialBalance initial balance
	 * @param interestRate interest rate to be paid
	 * @param owner owner of this account
	 */
	public SavingsAccount(double initialBalance, double interestRate, Customer owner) {
		super(initialBalance,owner);
		this.interestRate = interestRate;
	}
	
	/**
	 * Calculate and adds interest (as a deposit) to the current balance.
	 */
	public void addInterest() {
		// COMPLETE THIS METHOD
		double balance = super.getBalance();
		double decInterestRate = interestRate * 0.01;
		super.deposit(decInterestRate * balance);
		
	}
	
	/**
	 * Returns a String object representing this SavingsAccount object.
	 * 
	 * @return string representing this SavingsAccount object
	 */
	public String toString() {
		return "Savings Account: " + super.toString() + " Interest Rate: " + interestRate;
	}
}
