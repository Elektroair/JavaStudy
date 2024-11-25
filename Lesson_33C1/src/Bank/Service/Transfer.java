package Bank.Service;

import Bank.Model.Account;

public class Transfer implements Runnable
{
	Account accountDonor;
	Account accountRecipient;
	int money;

	public Transfer(Account accountDonor, Account accountRecipient, int money)
	{
		this.accountDonor     = accountDonor;
		this.accountRecipient = accountRecipient;
		this.money              = money;
	}


	@Override
	public void run()
	{
		transferMoney(accountDonor, accountRecipient, money);
	}

	private void transferMoney(Account accountFrom, Account accountTo, int money)
	{
		synchronized (accountTo)
		{
			if (accountFrom.getBalance() >= money)
			{
				accountFrom.debit(money);
				accountTo.credit(money);
			}
		}
	}

	public Account getAccountDonor()
	{
		return accountDonor;
	}

	public void setAccountDonor(Account accountDonor)
	{
		this.accountDonor = accountDonor;
	}

	public Account getAccountRecipient()
	{
		return accountRecipient;
	}

	public void setAccountRecipient(Account accountRecipient)
	{
		this.accountRecipient = accountRecipient;
	}

	public int getMoney()
	{
		return money;
	}

	public void setMoney(int money)
	{
		this.money = money;
	}
}
