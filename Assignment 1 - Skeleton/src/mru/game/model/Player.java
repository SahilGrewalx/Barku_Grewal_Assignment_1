package mru.game.model;

public class Player {
	String name;
	double balance;
	int numberOfWins;
	
	public Player(String n, double b, int numberOfWins) {
		this.name = n;
		this.balance = b;
		this.numberOfWins = numberOfWins;
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setbalance(double balance) {
		this.balance = balance;
	}
	public double getBalance() {
		return balance;
	}
	public void setNummberOfWins(int numberOfWins) {
		this.numberOfWins = numberOfWins;
	}
	public int getNumberOfWins () {
	return numberOfWins;
	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 */
	}
	public String toString() {
		return "Name: " + name + " balance: " + balance + " Number of Wins: " + numberOfWins;
	}
	
	public String format() {
		return name+","+balance+","+numberOfWins;
	}
}