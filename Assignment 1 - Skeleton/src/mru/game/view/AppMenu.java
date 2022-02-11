package mru.game.view;

import java.util.Scanner;

import mru.game.model.Player;

public class AppMenu {

	Scanner input;

	public AppMenu() {
		input = new Scanner(System.in);
	}

	public char displayMainMenu() {
		System.out.println("Select one of these options: \n");
		System.out.println("\t(P) Play Game");
		System.out.println("\t(S) Search");
		System.out.println("\t(E) Exit\n");
		System.out.print("Enter your choice: ");
		char option = input.next().toLowerCase().charAt(0);
		return option;
	}

	public char displaySubMenu() {
		System.out.println("Select one of these options: \n");
		System.out.println("\t(t) Top Player");
		System.out.println("\t(n) Search by Name");
		System.out.println("\t(b) Exit to main menu\n");
		System.out.print("Enter your choice: ");
		char option = input.next().toLowerCase().charAt(0);
		return option;
	}

	public String promptName() {
		System.out.print("\nEnter name here: ");
		String name = input.next();
		return name;
	}

	public void showPlayer(Player ply) {
		System.out.println(ply);
	}

	/**
	 * This class will be used to show the menus and sub menus to the user It also
	 * prompts the user for the inputs and validates them
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

	public double betAmount() {
		System.out.print("\nHow much do you want to bet this round ?");
		double betAmt = input.nextDouble();
		return betAmt;
	}
}