package mru.game.controller;
import mru.game.model.Card;
import mru.game.model.CardDeck;
import mru.game.view.GameMenu;


public class PuntoBancoGame {
	CardDeck myDeck; 
	GameMenu gm;
	 public PuntoBancoGame() {
		 myDeck = new CardDeck();
		 launchGame();
		 gm = new GameMenu();
	 }

	private void launchGame() {
		char gmChoice= gm.showGameMenu();
		double bet= gm.betAmount();
		Card playerC1 = currentCard();
	    System.out.print(playerC1);
	    Card bankerC1 = currentCard();
	    System.out.print(bankerC1);
	    Card playerC2 = currentCard();
	    System.out.print(playerC2);
	    Card bankerC2 = currentCard();
		
		
		
	}
     public Card currentCard() {
    	CardDeck gameDeck = new CardDeck();
    	Card currentCard= gameDeck.getDeck().remove(0);
    	return currentCard; 
     }
	
     public Card Hands() {
    Card playerC1 = currentCard();
    System.out.print(playerC1);
    Card bankerC1 = currentCard();
    
    	 
    	 return null;
    	 
     }
     
     
     
}


