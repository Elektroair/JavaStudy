package Bank.Main;

import Bank.Model.Account;
import Bank.Service.Transfer;

public class BankApp
{
	public static void main(String[] args) throws InterruptedException
	{
		Account account_1 = new Account(1000);
		Account account_2 = new Account(2000);
		account_1.credit(1000);
		account_2.credit(1000);
		Transfer transfer_1 = new Transfer(account_1, account_2, 900);
		Transfer transfer_2 = new Transfer(account_2, account_1, 900);
		Thread thread_1 = new Thread(transfer_1);
		Thread thread_2 = new Thread(transfer_2);
		thread_1.start();
		thread_2.start();
		thread_1.join();
		thread_2.join();

		System.out.println("Balance of account: " + account_1.getAccountNumber() + " = " + account_1.getBalance());
		System.out.println("Balance of account: " + account_2.getAccountNumber() + " = " + account_2.getBalance());
	}
}
