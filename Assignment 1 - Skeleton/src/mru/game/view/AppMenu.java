package mru.game.view;

import java.util.Scanner;

import mru.game.model.Player;

public class AppMenu {
	
	Scanner input;
	
	public AppMenu() {
		input = new Scanner(System.in);
	}

	public char displayMainMenu() {
		System.out.println("Select one of these options: ");
		System.out.println("\t(p) Play game");
		System.out.println("\t(s) Search");
		System.out.println("\t(e) Exit");
		System.out.print("Enter your choice: ");
	char option = input.next().toLowerCase().charAt(0);
	return option;
	}
	
	public char displaySubMenu() {
			System.out.println("Select one of these options: ");
			System.out.println("\t(t) Top Player");
			System.out.println("\t(n) Search by Name");
			System.out.println("\t(b) Exit to main menu");
			System.out.print("Enter your choice: ");
			char option = input.next().toLowerCase().charAt(0);
			return option;
	}
	public String promptName() {
		System.out.println("Enter name here: ");
		String name = input.nextLine().trim();
	return name;
	}
	
	public void showPlayer(Player ply) {
		System.out.println(ply);
	}
	/**
	 * This class will be used to show the menus and sub menus to the user
	 * It also prompts the user for the inputs and validates them 
	 */
}