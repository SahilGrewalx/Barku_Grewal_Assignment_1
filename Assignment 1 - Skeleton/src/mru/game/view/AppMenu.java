package mru.game.view;

import java.util.Scanner;

import mru.game.model.Player;

public class AppMenu {

	Scanner input;

	public AppMenu() {
		input = new Scanner(System.in);
	}

	/**
	 * shows the main menu takes user input on where they want to go
	 * 
	 * @return option user has picked
	 */
	public char displayMainMenu() {
		System.out.println("Select one of these options: \n");
		System.out.println("\t(P) Play Game");
		System.out.println("\t(S) Search");
		System.out.println("\t(E) Exit\n");
		System.out.print("Enter your choice: ");
		char option = input.next().toLowerCase().charAt(0);
		return option;
	}

	/**
	 * displays the sub menu and shows options
	 * 
	 * @returns option picked for sub menu
	 */
	public char displaySubMenu() {
		System.out.println("Select one of these options: \n");
		System.out.println("\t(t) Top Player");
		System.out.println("\t(n) Search by Name");
		System.out.println("\t(b) Exit to main menu\n");
		System.out.print("Enter your choice: ");
		char option = input.next().toLowerCase().charAt(0);
		return option;
	}

	/**
	 * prompts the user for the name for the casino
	 * 
	 * @returns name
	 */
	public String promptName() {
		System.out.print("\nEnter name here: ");
		String name = input.next();
		return name;
	}

	/**
	 * shows player matching to what the user has entered
	 * 
	 * @param ply
	 */
	public void showPlayer(Player ply) {
		System.out.println(ply);
	}

	/**
	 * shows the game menu where users decide who wins
	 * 
	 * @returns option for bet
	 */
	public String showGameMenu() {
		System.out.println("Select one of these options: \n");
		System.out.println("\t(P) Player Win");
		System.out.println("\t(B) Banker Win");
		System.out.println("\t(T) Tie Game\n");
		System.out.print("Enter your choice: ");
		String gameOpt = input.next().toLowerCase();
		return gameOpt;
	}

	/**
	 * takes how much the user wants to bet
	 * 
	 * @returns double value of how much user wants to bet
	 */
	public double betAmount() {
		System.out.print("\nHow much do you want to bet this round ?");
		double betAmt = input.nextDouble();
		return betAmt;
	}
}