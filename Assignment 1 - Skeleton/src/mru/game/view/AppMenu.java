package mru.game.view;

import java.util.Scanner;

import mru.game.model.Player;

public class AppMenu {
	Scanner scanner;
	
	public AppMenu() {
		scanner = new Scanner(System.in);
	}
	public char showMainMenu() {
		System.out.println("Select one of these options:\n");
		System.out.println("(P) Play Game");
		System.out.println("(S) Search");
		System.out.println("(E) Exit\n");
		System.out.print("Enter a choice: ");
		char choice = scanner.nextLine().toLowerCase().charAt(0);
		return choice;
	}
	public char showSubMenu() {
		System.out.println("Select one of these options: \n");
		System.out.println("(T) Top Player (most number of wins)");
		System.out.println("(N) Looking for a Name");
		System.out.println("(B) Back to Main Menu\n" );
		System.out.print("Enter a choice: ");
		char choice = scanner.nextLine().toLowerCase().charAt(0);
		return choice;
	}
	public String promptName() {
		System.out.print("Enter a Name Here: ");
		String name= scanner.nextLine().trim();
		return name;
	}
	public void playerDisplay(Player ply) {
		System.out.println(ply);
	}

}