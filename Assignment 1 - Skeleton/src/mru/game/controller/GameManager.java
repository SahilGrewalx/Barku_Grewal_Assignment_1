package mru.game.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import mru.game.view.AppMenu;

import mru.game.model.Player;

public class GameManager {

	private final String FILE_PATH = "res/CasinoInfo.txt";
	ArrayList<Player> players;
	AppMenu appMen;
	PuntoBancoGame pb;
	Scanner input = new Scanner(System.in);

	public GameManager() throws Exception {
		players = new ArrayList<>();
		appMen = new AppMenu();
		pb = new PuntoBancoGame();

		loadData();
		launchApplication();
	}

	private void launchApplication() throws IOException {
		boolean flag = true;

		while (flag) {
			char option = appMen.displayMainMenu();
			switch (option) {
			case 'p':
				playGame();
			case 's':
				Search();
				break;
			case 'e':
				Save();
				flag = false;
			}

		}
	}

	private void playGame() throws IOException {
		String name = appMen.promptName();
		Player p = searchByName(name);
		int initialBalance = 100;
		int initialWins = 0;
		if (p == null) {
			players.add(new Player(name, initialBalance, initialWins));
			System.out.println("New Player created");
			Save();
			System.out.println("\nWelcome " + name + " your balance is: $100");
		} else {
			System.out.println("\nWelcome back " + name + "\tyour balance is: $" + p.getBalance() + "\n");
		}
		String gmChoice = appMen.showGameMenu();
		double betAmt = appMen.betAmount();
		double newBal;
		if (betAmt <= p.getBalance()) {
			p.setbalance(p.getBalance() - betAmt);
			newBal = p.getBalance();
			String result = pb.runGame();
			if (result.equals(gmChoice)) {
				if (gmChoice.equals("t")) {
					betAmt *= 5;
					System.out.println("PLAYER WON $" + betAmt);
					p.setbalance(newBal + betAmt);
					p.setNummberOfWins(p.getNumberOfWins() + 1);
				} else {
					System.out.println("PLAYER WON $" + betAmt);
					p.setbalance(newBal + (betAmt * 2));
					p.setNummberOfWins(p.getNumberOfWins() + 1);
				}
			} else if (result.equals(gmChoice)) {
				System.out.println("PLAYER LOST $" + betAmt);
				p.setbalance(newBal - betAmt);
			}
			System.out.println("");
			Save();
			// If player does not have sufficient funds
		} else if (betAmt > p.getBalance()) {
			System.out.println("Sorry you have incefficent funds");
		}
		String playAgn;
		System.out.print("\nDo you want to play again(Y/N)?: ");
		playAgn = input.next();
		if (playAgn.equals("y") || playAgn.equals("Y")) {
			playGame();
		} else {
			launchApplication();
		}
	}

	private void Search() {
		char option = appMen.displaySubMenu();
		switch (option) {
		case 't':
			Player top = FindTopPlayer();
			appMen.showPlayer(top);
			break;
		case 'n':
			String name = appMen.promptName();
			Player ply = searchByName(name);
			appMen.showPlayer(ply);
		case 'e':
			break;
		}
	}

	private Player searchByName(String name) {
		Player ply = null;

		for (Player p : players) {
			if (p.getName().equals(name)) {
				ply = p;
				break;
			}
		}
		return ply;

	}

	private Player FindTopPlayer() {
		Player topPlayer = null;
		for (Player p : players) {
			if (topPlayer == null) {
				topPlayer = p;
			} else if (topPlayer.getNumberOfWins() < p.getNumberOfWins()) {
				topPlayer = p;
			}
		}
		return topPlayer;
	}

	private void Save() throws IOException {
		File CasinoInfo = new File(FILE_PATH);
		PrintWriter pw = new PrintWriter(CasinoInfo);

		System.out.print("Saving...\n");

		for (Player p : players) {
			pw.println(p.format());
		}
		pw.close();
	}

	private void loadData() throws Exception {
		File casinoInfo = new File(FILE_PATH);
		String currentLine;
		String[] splittedLine;
		if (casinoInfo.exists()) {
			Scanner fileReader = new Scanner(casinoInfo);
			while (fileReader.hasNextLine()) {

				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(",");
				Player p = new Player(splittedLine[0], Double.parseDouble(splittedLine[1]),
						Integer.parseInt(splittedLine[2]));
				players.add(p);
			}
			fileReader.close();
		}

	}

}
