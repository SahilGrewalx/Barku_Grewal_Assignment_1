package mru.game.model;

public class Player {
	String name;
	double balance;
	int numberOfWins;

	/**
	 * creates a new user in CasinoInfo.txt
	 * 
	 * @param n            is name
	 * @param b            is balance
	 * @param numberOfWins is how many wins they have
	 */
	public Player(String n, double b, int numberOfWins) {
		this.name = n;
		this.balance = b;
		this.numberOfWins = numberOfWins;

	}

	/**
	 * sets name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gets name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets balance
	 * 
	 * @param balance
	 */
	public void setbalance(double balance) {
		this.balance = balance;
	}

	/**
	 * gets balance
	 * 
	 * @return
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * sets number of wins
	 * 
	 * @param numberOfWins
	 */
	public void setNummberOfWins(int numberOfWins) {
		this.numberOfWins = numberOfWins;
	}

	/**
	 * gets number of wins
	 * 
	 * @return how many wins a user has
	 */
	public int getNumberOfWins() {
		return numberOfWins;
		/**
		 * This class represent each player record in the Database It is basically a
		 * model class for each record in the txt file
		 */
	}

	/**
	 * converts name,balance,and numbver of wins to a string
	 */
	public String toString() {
		return "Name: " + name + " balance: " + balance + " Number of Wins: " + numberOfWins;
	}

	/**
	 * formats the tostring and devides by a ","
	 * 
	 * @return formatted string
	 */
	public String format() {
		return name + "," + balance + "," + numberOfWins;
	}
}