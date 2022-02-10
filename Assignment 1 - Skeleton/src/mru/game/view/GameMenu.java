package mru.game.view;
import java.util.Scanner;

public class GameMenu {
Scanner input;

public GameMenu() {
	input = new Scanner(System.in);
}

public char showGameMenu() {
	System.out.println("Select one of these options: ");
	System.out.println("\t(P) Player Win");
	System.out.println("\t(B) Banker Win");
	System.out.println("\t(T) Tie Game");
	System.out.print("Enter your choice: ");
char gameOpt = input.next().toLowerCase().charAt(0);
return gameOpt;
	}

public double betAmount() {
	System.out.print("How much do you want to bet this round ?");
	double betAmt = input.nextDouble(); 
	return betAmt;
}














}
