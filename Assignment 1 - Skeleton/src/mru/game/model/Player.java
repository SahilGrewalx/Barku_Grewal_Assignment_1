package mru.game.model;

public class Player {
    String name;
    double balance;
    int wins;

    public Player(String name, double balance, int w) {
        this.name = name;
        this.balance = balance;
        this.wins = w;

    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setbalance(int balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void setNummberOfWins(int w) {
        this.wins = w;
    }
    public int getNumberOfWins () {
    return wins;
    /**
     * This class represent each player record in the Database
     * It is basically a model class for each record in the txt file
     */
    }
    public String toString() {
        return "Name: " + name + "balance: " + balance + "Number of Wins: " + wins;
    }
    public String format() {
    	return name+","+balance+","+wins;
    }
}
