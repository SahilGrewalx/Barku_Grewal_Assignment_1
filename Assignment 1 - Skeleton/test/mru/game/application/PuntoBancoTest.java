package mru.game.application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import mru.game.controller.PuntoBancoGame;
import mru.game.model.Card;
import mru.game.model.CardDeck;
import mru.game.model.Player;



class PuntoBancoTest {
	@Test
	void testnewCard() {
		Card newCard = new Card(3, "Clubs");
		int rank = newCard.getRank();
		String suit = newCard.getSuit();
		
		if (rank !=3) {
			fail();
		} else if (suit == null) {
			fail();
		}
		
	}
	@Test
	void testRnkMap() {
		Card newCard = new Card(1, "Clubs");
			if (!newCard.toString().equals("Ace of Clubs")) {
				fail();
			}
			newCard.setRank(11);
			if(!newCard.toString().equals("Jack of Clubs")) {
				fail();
			}
			newCard.setRank(12);
			if (!newCard.toString().equals("Queen of Clubs")) {
				fail();
			}
			newCard.setRank(13);
			if (!newCard.toString().equals("King of Clubs")) {
				fail();
			}
	}
		
	
	@Test
		void testnewDeck() {
			CardDeck deck = new CardDeck();
			
			assertNotNull(deck);
			
			
		}
	@Test
	void testshuffleDeck() {
		CardDeck deckOne = new CardDeck();
		CardDeck deckTwo = new CardDeck();
		deckOne.shuffleDeck();
		assertNotEquals(deckOne, deckTwo);
	}
	@Test
	void testdealCard() {
		CardDeck deck = new CardDeck();
		ArrayList<Card> newHand = new ArrayList<>();
		Card firstCard = deck.getDeck().get(0);
		deck.getDeck().remove(0);
		newHand.add(firstCard);
		if (newHand.size() !=1){
		fail();
		}
		}
	
	
		@Test
		void testdealHand() {
			
				CardDeck deck = new CardDeck();
				ArrayList<Card> newHand=new ArrayList<>();
				Card firstCard = deck.getDeck().get(0);
				deck.getDeck().remove(0);
				Card secondCard = deck.getDeck().get(0);
				deck.getDeck().remove(0);
				Card thirdCard= deck.getDeck().get(0);
				deck.getDeck().remove(0);

				newHand.add(firstCard);
				newHand.add(secondCard);
				newHand.add(thirdCard);
				if (newHand.size() !=3){
				fail();
			}
	}
		@Test
		void testCard() {
		Card newCard = new Card(3, "Hearts");
				if (!newCard.toString().equals("3 of Hearts")) {
					fail();
				}
		
	}
		@Test
		void testRetrieveHand() {
			
				CardDeck deck = new CardDeck();
				ArrayList<Card> newHand=new ArrayList<>();
				Card firstCard = deck.getDeck().get(0);
				deck.getDeck().remove(0);
				Card secondCard = deck.getDeck().get(0);
				deck.getDeck().remove(0);
				Card thirdCard= deck.getDeck().get(0);
				deck.getDeck().remove(0);

				newHand.add(firstCard);
				newHand.add(secondCard);
				newHand.add(thirdCard);
				System.out.print(firstCard);
				System.out.print(secondCard);
				System.out.print(thirdCard);
}
		@Test
		void testCreateHand() {
			
				CardDeck deck = new CardDeck();
				ArrayList<Card> newHand=new ArrayList<>();
				if (newHand.size() !=0) {
					fail();
				}
}
		@Test
		void testSuitMap() {
			Card diamond = new Card(1, "Diamonds");
					if (!diamond.toString().equals("Ace of Diamonds")) {
						fail();
					}
					Card Spade = new Card(11, "Spades");
					if(!Spade.toString().equals("Jack of Spades")) {
						fail();
					}
					Card Clubs = new Card(12, "Clubs");
					if (!Clubs.toString().equals("Queen of Clubs")) {
						fail();
					}
					Card Hearts = new Card(13, "Hearts");
					
					if (!Hearts.toString().equals("King of Hearts")) {
						fail();
					}
				

}
		@Test
		void testrunGame() {
			PuntoBancoGame pbg = new PuntoBancoGame();
			boolean gameRun = false;
			if (pbg.runGame().equals(false)){
				fail();
			}
		}
		
}


