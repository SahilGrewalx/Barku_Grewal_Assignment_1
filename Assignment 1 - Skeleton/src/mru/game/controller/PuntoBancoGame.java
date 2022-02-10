package mru.game.controller;

import mru.game.model.Card;
import mru.game.model.CardDeck;

public class PuntoBancoGame {
	CardDeck myDeck = new CardDeck();

	public Card drawCard() {
		Card currentCard = myDeck.getDeck().remove(0);
		System.out.println(currentCard);
		
		
			return currentCard;

	}
	public Card playercard(Card currentCard, Card drawCard) {
		String player;
		//player.currentCard();
		return currentCard;
		


	/**
	 * In this class you implement the game
	 * You should use CardDeck class here
	 * See the instructions for the game rules
	 */

}
}
