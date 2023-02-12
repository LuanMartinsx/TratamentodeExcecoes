package model.entities;

import exceptions.BusinessExceptions;

public class Account {
	
	private Integer number;
	private String holder; 
	private Double balance;
	private Double limitWithdraw;
	
	public Account() {
		
	}
	
	
	
	
	public Account(Integer number, String holder, Double balance, Double limitWithdraw) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.limitWithdraw = limitWithdraw;
	}
	
	




	public Integer getNumber() {
		return number;
	}




	public String getHolder() {
		return holder;
	}



	public void setHolder(String holder) {
		this.holder = holder;
	}




	public Double getBalance() {
		return balance;
	}




	public Double getLimitWithdraw() {
		return limitWithdraw;
	}


	
	public void setLimitWithdraw(Double limitWithdraw) {
		this.limitWithdraw = limitWithdraw;
	}




	public double Deposit(double amount) {
		return balance += amount;
	}
	
	public double Withdraw(double amount) {
		ValidateWithdraw(amount);
		return balance -= amount;
		
	}
	
	
	public void ValidateWithdraw(double amount) {
		if (amount > getLimitWithdraw()) {
			throw new BusinessExceptions("Withdraw error: The amount exceeds withdraw limit");
		}
		else if (getLimitWithdraw() > getBalance()) {
			throw new BusinessExceptions("Withdraw error: Not enough balance");
		}
	}
}

