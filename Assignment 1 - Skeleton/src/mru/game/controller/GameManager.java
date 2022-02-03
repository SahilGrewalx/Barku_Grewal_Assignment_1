package mru.game.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.game.model.Player;
import mru.game.view.AppMenu;

public class GameManager {

	private ArrayList<Player> players;
	public final String FILE_NAME = "res/Casino.txt";
	AppMenu appMen;

	public GameManager() throws IOException {
		players = new ArrayList<>();
		appMen = new AppMenu();
		loadData();
		runApplication();
	}

	private void runApplication() throws IOException {
		// shows the main menu
		boolean exitCondition = true;
		char choice;
		while (exitCondition) {
			choice = appMen.showMainMenu();
			
			switch (choice) {
			case 'p':
				puntoBancoGame();
				break;
			case 's':
				Search();
				break;
			case 'e':
				save();
				System.out.println("Thank you for playing Punto Banco Game!");
				exitCondition=false;
				
			}
		}
	}

	private void puntoBancoGame() {
		// TODO Auto-generated method stub
		
	}

	private void Search() {
		char choice = appMen.showSubMenu();
		switch	(choice) {
		case 't':
			topPlayer();
			break;
		case 'n':
			Player ply = searchName();
			appMen.playerDisplay(ply);
			break;
		case 'b':
			break;
		}
		
		
	}

	private Player searchName() {
		String name = appMen.promptName();
		Player ply= null;
		
		for (Player p: players) {
			if (p.getName().equals(name)) {
				ply=p;
				break;
			}
		}
		return ply;
	}

	private void topPlayer() {
		// TODO Auto-generated method stub
		
	}

	private void save() throws IOException {
		File db = new File(FILE_NAME);
		PrintWriter printWriter = new PrintWriter(db);
		
		
		for(Player p: players) {
			printWriter.println(p.format());
		}
		
		printWriter.close();
		
	}

	public void loadData() throws FileNotFoundException {
		File db = new File(FILE_NAME);
		String currentLine;
		String[] splittedLine;

		if (db.exists()) {
			Scanner fileReader = new Scanner(db);

			while (fileReader.hasNextLine()) {

				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(",");
				Player p = new Player(splittedLine[0], Double.parseDouble(splittedLine[1]),Integer.parseInt(splittedLine[2]));
				players.add(p);
			}
		fileReader.close();
		}

		
	}
}
