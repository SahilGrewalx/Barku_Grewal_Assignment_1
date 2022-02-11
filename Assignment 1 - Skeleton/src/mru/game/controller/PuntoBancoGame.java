package mru.game.controller;

import java.util.Scanner;

import mru.game.model.Card;
import mru.game.model.CardDeck;
import mru.game.view.AppMenu;

import java.util.ArrayList;

public class PuntoBancoGame {

	/**
	 * In this class you implement the game You should use CardDeck class here See
	 * the instructions for the game rules
	 */

	Scanner input = new Scanner(System.in);
	ArrayList<Card> playersHand = new ArrayList<>();
	ArrayList<Card> bankersHand = new ArrayList<>();

	CardDeck myDeck = new CardDeck();

	/**
	 * runs the puntoBancoGame
	 * 
	 * @return who whon between player and banker
	 */
	public String runGame() {
		String winner = " ";

		int playerValue = 0;
		int bankerValue = 0;
		String header = "+" + "=".repeat(23) + "+" + "=".repeat(23) + "+\n" + "||PLAYER" + " ".repeat(16) + "|BANKER"
				+ " ".repeat(16) + "||\n";

		/**
		 * round 1
		 */
		Card pFirstCard = myDeck.getDeck().get(0);
		myDeck.getDeck().remove(0);
		Card bFirstCard = myDeck.getDeck().get(0);
		myDeck.getDeck().remove(0);
		playersHand.add(pFirstCard);
		bankersHand.add(bFirstCard);

		// adding the cards of the player
		String playersCards1 = playersHand.get(0).toString();
		Scanner parsePlayer1 = new Scanner(playersCards1);

		if (parsePlayer1.hasNextInt()) {
			playerValue += parsePlayer1.nextInt();
		} else if (playersCards1.contains("King") || playersCards1.contains("Queen")
				|| playersCards1.contains("Jack")) {
			playerValue += 10;
		} else if (playersCards1.contains("Ace")) {
			playerValue += 1;
		}
		parsePlayer1.close();

		// adding the cards of the banker
		String bankersCards1 = bankersHand.get(0).toString();
		Scanner parseBanker1 = new Scanner(bankersCards1);
		if (parseBanker1.hasNextInt()) {
			bankerValue += parseBanker1.nextInt();
		} else if (bankersCards1.contains("King") || bankersCards1.contains("Queen")
				|| bankersCards1.contains("Jack")) {
			bankerValue += 10;
		} else if (bankersCards1.contains("Ace")) {
			bankerValue += 1;
		}
		parseBanker1.close();

		System.out.println("\t\t - PUNTO BANCO -");
		System.out.print(header);
		System.out.println("Round One: " + "\n" + "\n" + "Players Card: [" + pFirstCard + "]" + "\n" + "Bankers Card: ["
				+ bFirstCard + "]" + "\n");

		Card pSecondCard = myDeck.getDeck().get(0);
		myDeck.getDeck().remove(0);
		Card bSecondCard = myDeck.getDeck().get(0);

		playersHand.add(pSecondCard);
		bankersHand.add(bSecondCard);

		System.out.println("Round Two: " + "\n" + "\n" + "Players Card: [" + pSecondCard + "]" + "\n"
				+ "Bankers Card: [" + bSecondCard + "]" + "\n");

		// adding the cards of the player
		String playersCards2 = playersHand.get(1).toString();
		Scanner parsePlayer2 = new Scanner(playersCards2);
		if (parsePlayer2.hasNextInt()) {
			playerValue += parsePlayer2.nextInt();
		} else if (playersCards2.contains("King") || playersCards2.contains("Queen")
				|| playersCards2.contains("Jack")) {
			playerValue += 10;
		} else if (playersCards2.contains("Ace")) {
			playerValue += 1;
		}
		parsePlayer2.close();

		// adding the cards of the banker
		String bankersCards2 = bankersHand.get(1).toString();

		Scanner parseBanker2 = new Scanner(bankersCards2);
		if (parseBanker2.hasNextInt()) {
			bankerValue += parseBanker2.nextInt();
		} else if (bankersCards2.contains("King") || bankersCards2.contains("Queen")
				|| bankersCards2.contains("Jack")) {
			bankerValue += 10;
		} else if (bankersCards2.contains("Ace")) {
			bankerValue += 1;
		}
		parseBanker2.close();

		playerValue %= 10;
		bankerValue %= 10;

		System.out.println("The current value of the Player cards: [" + playerValue + "]");
		System.out.println("The current value of the bankers cards: [" + bankerValue + "]" + "\n");
		/**
		 * THIRD ROUND ONLY HAPPENS IF; IF STATEMENTS CONDITIONS ARE MET
		 */

		// initiating a third card for player
		Card pThirdCard = myDeck.getDeck().get(0);
		myDeck.getDeck().remove(0);
		playersHand.add(pThirdCard);

		// initiating a third card for banker
		Card bThirdCard = myDeck.getDeck().get(0);
		myDeck.getDeck().remove(0);
		bankersHand.add(bThirdCard);

		// A - player between 0 - 5

		if (playerValue >= 8 || bankerValue >= 8) {
			if (playerValue > bankerValue) {
				System.out.println("The player Wins");
			} else if (playerValue < bankerValue) {
				System.out.println("The banker Wins");
			} else if (playerValue == bankerValue) {
				System.out.println("Both player and banker have same value [TIE]");
			}
		} else {

			if (playerValue >= 0 && playerValue <= 6) {

				String playersCards3 = playersHand.get(2).toString();
				System.out.println("Round Three: " + "\n" + "\n" + "Players Card: [" + pThirdCard + "]");

				Scanner parsePlayer3 = new Scanner(playersCards3);
				if (parsePlayer3.hasNextInt()) {
					playerValue += parsePlayer3.nextInt();
				} else if (playersCards3.contains("King") || playersCards3.contains("Queen")
						|| playersCards3.contains("Jack")) {
					playerValue += 10;
				} else if (playersCards3.contains("Ace")) {
					playerValue += 1;
				}
				parsePlayer3.close();
				playerValue %= 10;

			}

			// If the Player did not draw a card, the Banker draws if he (the Banker) has
			// 0-5, and stands if he has 6-7
			if (playerValue >= 7 && playerValue <= 9) {
				if (bankerValue >= 0 && bankerValue <= 5) {

					String bankersCards3 = bankersHand.get(2).toString();
					System.out.println("Third Round: " + "\n" + "Bankers Card: [" + bThirdCard + "]");

					Scanner parseBanker3 = new Scanner(bankersCards3);
					if (parseBanker3.hasNextInt()) {
						bankerValue += parseBanker3.nextInt();
					} else if (bankersCards3.contains("King") || bankersCards3.contains("Queen")
							|| bankersCards3.contains("Jack")) {
						bankerValue += 10;
					} else if (bankersCards3.contains("Ace")) {
						bankerValue += 1;
					}
					parseBanker3.close();
					bankerValue %= 10;

				}

			} else if (bankerValue == 6 || bankerValue == 7) {
				System.out.println("The banker did not need a card" + "\n");
			}

			// If the Player drew a 2 or 3, the Banker draws if he (the Banker) has 0-4, and
			// stands if he has 5-7.
			if (pThirdCard.equals("2") || pThirdCard.equals("3")) {
				if (bankerValue >= 0 && bankerValue <= 4) {

					String bankersCards3 = bankersHand.get(2).toString();
					System.out.println("Third Round: " + "\n" + "Bankers Card: [" + bThirdCard + "]");

					Scanner parseBanker3 = new Scanner(bankersCards3);
					if (parseBanker3.hasNextInt()) {
						bankerValue += parseBanker3.nextInt();
					} else if (bankersCards3.contains("King") || bankersCards3.contains("Queen")
							|| bankersCards3.contains("Jack")) {
						bankerValue += 10;
					} else if (bankersCards3.contains("Ace")) {
						bankerValue += 1;
					}
					parseBanker3.close();
					bankerValue %= 10;

				}

			} else if (bankerValue >= 5 && bankerValue <= 7) {
				System.out.println("The Banker did not need a card");
			}

			// If the Player drew a 4 or 5, the Banker draws if he has 0-5, and stands if he
			// has 6-7
			if (pThirdCard.equals(4) || pThirdCard.equals(5)) {
				if (bankerValue >= 0 && bankerValue <= 5) {

					String bankersCards3 = bankersHand.get(2).toString();
					System.out.println("Third Round: " + "\n" + "Bankers Card: [" + bThirdCard + "]");

					Scanner parseBanker3 = new Scanner(bankersCards3);
					if (parseBanker3.hasNextInt()) {
						bankerValue += parseBanker3.nextInt();
					} else if (bankersCards3.contains("King") || bankersCards3.contains("Queen")
							|| bankersCards3.contains("Jack")) {
						bankerValue += 10;
					} else if (bankersCards3.contains("Ace")) {
						bankerValue += 1;
					}
					parseBanker3.close();
					bankerValue %= 10;

				} else if (bankerValue == 6 || bankerValue == 7) {
					System.out.println("The Banker did not need a card");
				}
			}

			// If the Player drew a 6 or 7, the Banker draws if he has 0-6, and stands if he
			// has 7.
			if (pThirdCard.equals(6) || pThirdCard.equals(7)) {
				if (bankerValue >= 0 && bankerValue <= 6) {
					String bankersCards3 = bankersHand.get(2).toString();
					System.out.println("Third Round: " + "\n" + "Bankers Card: [" + bThirdCard + "]");

					Scanner parseBanker3 = new Scanner(bankersCards3);
					if (parseBanker3.hasNextInt()) {
						bankerValue += parseBanker3.nextInt();
					} else if (bankersCards3.contains("King") || bankersCards3.contains("Queen")
							|| bankersCards3.contains("Jack")) {
						bankerValue += 10;
					} else if (bankersCards3.contains("Ace")) {
						bankerValue += 1;
					}
					parseBanker3.close();
					bankerValue %= 10;

				} else if (bankerValue == 7) {
					System.out.println("The Banker did not need a card");
				}
			}

			// If the Player drew an 8, the Banker draws if he has 0-2, and stands if he has
			// 3-7.
			if (pThirdCard.equals(8)) {
				if (bankerValue >= 0 && bankerValue <= 2) {
					String bankersCards3 = bankersHand.get(2).toString();
					System.out.println("Third Round: " + "\n" + "Bankers Card: [" + bThirdCard + "]");

					Scanner parseBanker3 = new Scanner(bankersCards3);
					if (parseBanker3.hasNextInt()) {
						bankerValue += parseBanker3.nextInt();
					} else if (bankersCards3.contains("King") || bankersCards3.contains("Queen")
							|| bankersCards3.contains("Jack")) {
						bankerValue += 10;
					} else if (bankersCards3.contains("Ace")) {
						bankerValue += 1;
					}
					parseBanker3.close();
					bankerValue %= 10;

				} else if (bankerValue >= 3 && bankerValue <= 7) {
					System.out.println("The Banker did not need a card");
				}
			}

			/**
			 * If the Player drew an Ace, 9, 10, or face card (Jack, Queen or King), the
			 * Banker draws if he has 0-3, and stands if he has 4-7
			 */
			if (pThirdCard.equals("King") || pThirdCard.equals("Queen") || pThirdCard.equals("Ace")
					|| pThirdCard.equals(9) || pThirdCard.equals("10")) {

				if (bankerValue >= 0 && bankerValue <= 3) {

					String bankersCards3 = bankersHand.get(2).toString();
					System.out.println("Third Round: " + "\n" + "Bankers Card: [" + bThirdCard + "]");

					Scanner parseBanker3 = new Scanner(bankersCards3);
					if (parseBanker3.hasNextInt()) {
						bankerValue += parseBanker3.nextInt();
					} else if (bankersCards3.contains("King") || bankersCards3.contains("Queen")
							|| bankersCards3.contains("Jack")) {
						bankerValue += 10;
					} else if (bankersCards3.contains("Ace")) {
						bankerValue += 1;
					}
					parseBanker3.close();
					bankerValue %= 10;

				}
			}
			System.out.println("The current value of the Player cards: [" + playerValue + "]");
			System.out.println("The current value of the bankers cards: [" + bankerValue + "]" + "\n");
			if (playerValue > bankerValue) {
				System.out.println("\nPlayer Wins\n");
				winner = "p";
			} else if (bankerValue > playerValue) {
				System.out.println("\nBanker Wins\n");
				winner = "b";
			} else if (bankerValue == playerValue) {
				System.out.println("Tie Game");
				winner = "t";
			}
		}
		return winner;
	}
}
