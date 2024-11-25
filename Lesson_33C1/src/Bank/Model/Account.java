package Bank.Model;

import java.util.Objects;

public class Account
{
	int accountNumber;
	int balance;

	public Account(int accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	@Override
	public boolean equals(Object object)
	{
		if (this == object)
		{
			return true;
		}
		if (object == null || getClass() != object.getClass())
		{
			return false;
		}
		Account account = (Account) object;
		return accountNumber == account.accountNumber && balance == account.balance;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(accountNumber, balance);
	}

	public void debit(int sum)
	{
		balance -= sum;
	}

	public void credit(int sum)
	{
		balance += sum;
	}

	public int getBalance()
	{
		return balance;
	}

	public void setBalance(int balance)
	{
		this.balance = balance;
	}

	public int getAccountNumber()
	{
		return accountNumber;
	}
}
