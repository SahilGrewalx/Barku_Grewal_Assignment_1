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

	public GameManager() throws Exception {
		players = new ArrayList<>();
		appMen = new AppMenu();
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

	private void playGame() {
		String name = appMen.promptName();
		Player p = searchByName(name);
		int initialBalance = 100;
		int initialWins = 0;
		if (p == null) {
			String id = appMen.promptName();
			players.add(new Player(name, initialBalance, initialWins));
		}
		
		pb = new PuntoBancoGame();
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
			} else
				System.out.print("player not found \n ");
			break;

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

		System.out.print("Saved");

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
