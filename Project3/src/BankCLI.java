import java.util.*;
/**
 * BankCLI class implements a command-line user interface (CLI) to the banking application.
 * 
 * @author  Warren Sink
 */
public class BankCLI {

	private static Bank bank = new Bank();
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Main driver of the bank application.
	 * 
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {

		while (true) {
			int choice = displayMenuAndGetSelection();
			switch (choice) {
				case 1:
					addCustomer();
					break;
					
				case 2:
					addAccount();
					break;
					
				case 3:
					listCustomers();
					break;
			
				case 4:
					listAccounts();
					break;
					
				case 5:
					listCustomerAccounts();
					break;
					
				case 6:
					listAccountTransactions();
					break;
					
				case 7:
					accountDeposit();
					break;
					
				case 8:
					accountWithdraw();
					break;
					
				case 9:
					accountBalance();
					break;
					
				case 10:
					transferFunds();
					break;
					
				case 11:
					processAccounts();
					break;
					
				case 12:
					System.out.println("Good Bye!!!");
					System.exit(0);
			}
		}
	}
	
	/**
	 * Displays the command menu, prompts and reads the command choice from the user.
	 * 
	 * @return command choice
	 */
	private static int displayMenuAndGetSelection() {
		int choice;
		boolean repeat;
		
		do {
			System.out.println("<<<<<<<<< GVSU Lakers Bank Menu >>>>>>>>>");
			System.out.println("1.  Add Customer");
			System.out.println("2.  Add Account");
			System.out.println("3.  List All Customers");
			System.out.println("4.  List All Accounts");
			System.out.println("5.  List Customer's Accounts");
			System.out.println("6.  List Account's Transactions");
			System.out.println("7.  Account Deposit");
			System.out.println("8.  Account Withdraw");
			System.out.println("9.  Account Balance");
			System.out.println("10. Funds Transfer");
			System.out.println("11. Process Accounts");
			System.out.println("12. Quit");
			System.out.print("Enter your selection: ");
			choice = Integer.parseInt(sc.nextLine());
			repeat = choice < 1 || choice > 12;
			if (repeat) {
				System.out.println("Invalid selection. Try again....");
			}
		} while (repeat);
		
		return choice;
	}
	
	/**
	 * Handles the "Add Customer" menu choice
	 */
	private static void addCustomer() {		
		// COMPLETE THIS METHOD
		System.out.print("Customer SSN: ");
		String ssn = sc.nextLine().trim();
		System.out.print("Customer name: ");
		String custName = sc.nextLine();
		System.out.print("Customer phone: ");
		String phone = sc.nextLine();
		
		boolean newCustomer = bank.addCustomer(ssn, custName, phone);
		if (newCustomer) {
			System.out.println("Add customer successfull.");
		} else {
			System.out.println("Add customer failed.");
		}
		
	}
	
	/**
	 * Handles the "Add Account" menu choice
	 */
	private static void addAccount() {
		// COMPLETE THIS METHOD
		System.out.print("Customer SSN: ");
		String ssn = sc.nextLine().trim();
		System.out.print("Initial Amount: ");
		double balance = Double.parseDouble(sc.nextLine());
		
				
		System.out.print("Account Type (c/C or s/S): ");
		String accountType = sc.nextLine();
				
		if (accountType.equals("c") || accountType.equals("C")) {
			
			boolean newChecking = bank.addCheckingAccount(ssn, balance);
			
			if(newChecking) {
				
				System.out.println("Add account successfull.");
				
			} else {
				
				System.out.println("Add account failed.");
				
			}
			
		} else {
						
			System.out.print("Interest Rate: ");
			double interestRate = Double.parseDouble(sc.nextLine());
			
			boolean newSavings = bank.addSavingsAccount(ssn, balance, interestRate);
			
            if(newSavings) {
				
				System.out.println("Add account successfull.");
				
			} else {
				
				System.out.println("Add account failed.");
				
			}
            			
			
		}
		
		
		
	}
	
	/**
	 * Handles the "List All Customers" menu choice
	 */
	private static void listCustomers() {
		// COMPLETE THIS METHOD
		ArrayList<Customer> customers = bank.getCustomers();
		int nbrCustomers = bank.getNbrCustomers();
        if (nbrCustomers == 0) {
			
			System.out.println("The bank has no customers at this time.");
			
		} else {
			
			for (Customer customer : customers) {
				
				System.out.print(customer.toString());
				System.out.println();
				
			}
			
			
		}
		
				
	}
	
	/**
	 * Handles the "List All Accounts" menu choice
	 */
	private static void listAccounts() {
		// COMPLETE THIS METHOD
        ArrayList<BankAccount> accounts = bank.getAccounts();
		
		for (BankAccount account : accounts) {
			
			System.out.print(account.toString());
			System.out.println();
			
		}
		
		int nbrAccounts = bank.getNbrAccounts();
		if (nbrAccounts == 0) {
			
			System.out.println("The bank has no accounts at this time.");
			
		}
	}
	
	/**
	 * Handles the "List Customer's Accounts" menu choice
	 */
	private static void listCustomerAccounts() {
		// COMPLETE THIS METHOD
		System.out.print("Customer SSN: ");
		String ssn = sc.nextLine().trim();
		Customer customer = bank.getCustomer(ssn);
		
		if (customer == null) {
			
			System.out.println("Customer not found.");
			
		} else {
			
			ArrayList<BankAccount> custAccounts = customer.getAccounts();
			for (BankAccount account : custAccounts) {
				
				System.out.print(account.toString());
				System.out.println();
				
			}
			
		}
		
	}
	
	/**
	 * Handles the "List Account's Transactions" menu choice
	 */
	private static void listAccountTransactions() {
		// COMPLETE THIS METHOD
		System.out.print("Account number: ");
		String actNbr = sc.nextLine();
		BankAccount account = bank.getAccount(actNbr);
		
        if (account == null) {
			
			System.out.println("Account not found.");
			
		} else {
			
			ArrayList<Transaction> transactions = account.getTransactions();
			for (Transaction transaction : transactions) {
				
				System.out.println(transaction.toString());
				
			}	
			
		}
		
	}
	
	/**
	 * Handles the "Account Deposit" menu choice
	 */
	private static void accountDeposit() {
		// COMPLETE THIS METHOD
		System.out.print("Account number: ");
		String actNbr = sc.nextLine();
		BankAccount account = bank.getAccount(actNbr);
		
		System.out.print("Deposit amount: ");
		double amt = Double.parseDouble(sc.nextLine());
		
        if (account == null) {
						
			System.out.println("Deposit failed!");
			
			
		} else {
			
			boolean deposited = account.deposit(amt);
			
			if (deposited == true) {
				
				System.out.println("Deposit successful.");
				
			} else {
				
				System.out.println("Deposit failed!");
				
			}
			
			
		}
		
	}
	
	/**
	 * Handles the "Account Withdraw" menu choice
	 */
	private static void accountWithdraw() {
		// COMPLETE THIS METHOD
		System.out.print("Account number: ");
		String actNbr = sc.nextLine();
		BankAccount account = bank.getAccount(actNbr);
		
		System.out.print("Withdraw amount: ");
		double amt = Double.parseDouble(sc.nextLine());
		
        if (account == null) {
			
			System.out.println("Withdraw failed!");
			
		} else {
			
			boolean withdrawn = account.withdraw(amt);
			
			if (withdrawn == true) {
				
				System.out.println("Withdraw successful.");
				
			} else {
				
				System.out.println("Withdraw failed!");
				
			}	
			
		}
		
	}
	
	/**
	 * Handles the "Account Balance" menu choice
	 */
	private static void accountBalance() {
		// COMPLETE THIS METHOD
		System.out.print("Account number: ");
		String actNbr = sc.nextLine();
		BankAccount account = bank.getAccount(actNbr);
		
        if (account == null) {
			
			System.out.println("Account not found.");
			
		} else {
			
			double balance = account.getBalance();
			System.out.printf("Account balance: $%.2f\n", balance);	
			
		}
		
	}
	
	/**
	 * Handles the "Funds Transfer" menu choice
	 */
	private static void transferFunds() {
		// COMPLETE THIS METHOD
		System.out.print("From Account Number: ");
		String actNbr1 = sc.nextLine();
		BankAccount from = bank.getAccount(actNbr1);
		
		System.out.print("To Account Number: ");
		String actNbr2 = sc.nextLine();
		BankAccount to = bank.getAccount(actNbr2);
		
		System.out.print("Transfer Amount: ");
		double amt = Double.parseDouble(sc.nextLine());
		
        if (from == null || to == null) {
			
			System.out.println("Funds transfer failed!");
			
		} else {
			
			boolean transferred = bank.transferFunds(from, to, amt);
			
			if (transferred == true) {
				
				System.out.println("Funds transfer successful.");
				
			} else {
				
				System.out.println("Funds transfer failed!");
				
			}
			
		}
		
	}

	/**
	 * Handles the "Process Accounts" menu choice.
	 * For each CheckingAccount in the bank, fee is deducted.
	 * For each SavingsAccount in the bank, interest is added.
	 */
	private static void processAccounts() {
		ArrayList<BankAccount> acts = bank.getAccounts();
		if (acts == null || acts.isEmpty()) {
			System.out.println("The bank currently has no accounts to process.");
			return;
		}
		for (BankAccount act : acts) {
			if (act instanceof CheckingAccount) {
				((CheckingAccount) act).deductFees();
			}
			if (act instanceof SavingsAccount) {
				((SavingsAccount) act).addInterest();
			}
		}
		System.out.println("Accounts processed.");
	}
}
