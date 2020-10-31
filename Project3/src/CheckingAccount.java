/**
 * The CheckingAccount class represents a checking account in the bank.
 * 
 * @author Warren Sink
 *
 */
public class CheckingAccount extends BankAccount {
	
	private static final int FREE_TRANSACTIONS = 3;
	private static final double TRANSACTION_FEE = 2.0;
	
	private int transactionCount = 0;
	
	/**
	 * Initializes a newly constructed CheckingAccount object with initial balance and
	 * owner information.
	 * 
	 * @param initialBalance initial balance
	 * @param owner owner of this account
	 */
	public CheckingAccount(double initialBalance, Customer owner) {
		super(initialBalance,owner);
	}

	/**
	 * Increments the balance of this CheckingAccount object by the specified amount.
	 * 
	 * @param amt amount to increase the balance by
	 * 
	 * @return true if deposit operation is successful, false otherwise
	 */
	public boolean deposit(double amt) {
		// COMPLETE THIS METHOD - REPLACE NEXT STATEMENT WITH YOUR IMPLEMENTATION
		boolean booDepo = super.deposit(amt);
		
		if (booDepo == true) {
			
			transactionCount ++;
			return true;
			
		}
		
		return booDepo;
	}
	
	/**
	 * Decrements the balance of this CheckingAccount object by the specified amount.
	 * 
	 * @param amt amount to decrease the balance by
	 * 
	 * @return true if withdrawal operation is successful, false otherwise
	 */
	public boolean withdraw(double amt) {
		// COMPLETE THIS METHOD - REPLACE NEXT STATEMENT WITH YOUR IMPLEMENTATION
		boolean booWithdraw = super.withdraw(amt);
		
		if (booWithdraw == true) {
			
			transactionCount ++;
			return true;
			
		}
		return booWithdraw;		
	}
	
	/**
	 * Deduct fees (as a withdraw) from the current balance if the number of
	 * transactions is more than the number of free transactions.
	 */
	public void deductFees() {
		// COMPLETE THIS METHOD
		if (transactionCount > FREE_TRANSACTIONS) {
			
			super.withdraw(TRANSACTION_FEE);
			
			
		}
		
	}
	
	/**
	 * Returns a String object representing this CheckingAccount object.
	 * 
	 * @return string representing this CheckingAccount object
	 */
	public String toString() {
		return "Checking Account: " + super.toString();
	}
}
