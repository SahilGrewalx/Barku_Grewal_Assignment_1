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
	
	public GameManager() throws Exception {
		players = new ArrayList<>();
		appMen = new AppMenu();
		loadData();
		launchApplication(); 
	}

	private void launchApplication() throws IOException {
		// TODO Auto-generated method stub
		boolean flag = true;
		
		while (flag) {
			char option = appMen.displayMainMenu();
			switch(option) {
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
		
		// TODO Auto-generated method stub
		
	}

	private void Search() {
		char option = appMen.displaySubMenu();
		
		switch (option) {
		case 't':
			FindTopPlayer();
			break;
		case 'n':
			Player ply = searchByName();
			appMen.showPlayer(ply);
		case 'e':
			break;
		}
	}

	private Player searchByName() {
		String name = appMen.promptName();
		Player ply = null;
		
		for (Player p: players) {
			if (p.getName().equals(name)) {
				ply = p;
			} else 
				System.out.print("player not found ");
				break;
			
		}
		return ply;
		
	}

	private void FindTopPlayer() {
		// TODO Auto-generated method stub
		
	}

	private void Save() throws IOException {
		File CasinoInfo = new File(FILE_PATH);
		PrintWriter pw = new PrintWriter(CasinoInfo);
		
		System.out.print("Saved");
		
		for (Player p: players) {
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
				Player p = new Player(splittedLine[0], Integer.parseInt(splittedLine[1]), Integer.parseInt(splittedLine[2]));
				players.add(p);
			}
			fileReader.close();
		}
		
		
		// TODO Auto-generated method stub
		
	}
	
	/* In this class toy'll need these methods:
	 * A constructor
	 * A method to load the txt file into an arraylist (if it exists, so you check if the txt file exists first)
	 * A save method to store the arraylist into the the txt file 
	 * A method to search for a player based their name
	 * A method to find the top players
	 * Depending on your designing technique you may need and you can add more methods here 
	 */

	

}
